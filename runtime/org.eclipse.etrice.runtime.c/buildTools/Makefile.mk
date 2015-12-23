#-----------------------------------------------------------------------------------------------
# Generic makefile for executable/library

# All options:
# IN_TARGET 
# IN_TARGET_DIR
# IN_BUILD_DIR
# IN_TARGET_PLATFORM
# IN_INCDIRS
# IN_SRCDIRS_REC
# IN_SOURCES
# IN_CFLAGS
# IN_DEFS
# IN_LDFLAGS
# IN_LDLIBS
# IN_PREREQS

# Note: avoid trailing spaces !

# Note: Variables from environment or cmd are unmodifiable.
# E.g. use additional variables:
# IN_SRCDIRS_REC 	+= ${APP_SRCDIRS_REC}
# IN_SRCDIRS_REC 	+= ...

#-----------------------------------------------------------------------------------------------

# relative to basedir or absolute if not possible
define CANONICAL_PATH
$(patsubst ${CURDIR}/%,%,$(abspath ${1}))
endef

# $1 = path, should end with '/' to avoid wildcard matching of directories
# $2 = file (extension)
define REC_FILE_SEARCH
$(wildcard $(addsuffix $2, $1)) $(foreach d,$(wildcard $(addsuffix *, $1)),$(call REC_FILE_SEARCH,$d/,$2))
endef

#   USE WITH EVAL
define TARGET_RULE
    ifeq "$$(suffix $${M_TARGET})" ".a"
        # static library
        $${M_TARGET}: $${M_OBJS}
	    @mkdir -p $$(dir $$@)
	    $$(strip $${AR} $${ARFLAGS} $${M_TARGET_DIR}/$$@ $${M_OBJS})
    else
    	# executable
        $${M_TARGET}: $${M_OBJS} $${M_PREREQS}
	    @mkdir -p $$(dir $$@)
	    $$(strip $${CC} -o $${M_TARGET_DIR}/$$@ $${M_LDFLAGS} $${M_OBJS} $${M_LDLIBS} )
    endif
endef


ifeq ($(strip ${IN_BUILD_DIR}),)
# TODO: TARGET_BUILD_DIR should not be here
	IN_BUILD_DIR := ${TARGET_BUILD_DIR}
endif

ifeq ($(strip ${IN_TARGET_DIR}),)
	IN_TARGET_DIR := ${IN_BUILD_DIR}
endif

# Locals, no override from 'outside'
M_TARGET 			:= ${IN_TARGET}
M_TARGET_DIR		:= ${IN_TARGET_DIR}
M_BUILD_DIR			:= ${IN_BUILD_DIR}
M_INCDIRS 			:= ${IN_INCDIRS}
M_SRCDIRS_REC 		:= ${IN_SRCDIRS_REC}
M_SOURCES 			:= ${IN_SOURCES}
M_CFLAGS 			:= ${IN_CFLAGS}
M_DEFS 				:= ${IN_DEFS}
M_LDFLAGS   		:= ${IN_LDFLAGS}
M_LDLIBS    		:= ${IN_LDLIBS}
M_PREREQS 			:= ${IN_PREREQS}
M_OBJS 				:=

M_SOURCES 	:= $(call CANONICAL_PATH, ${M_SOURCES})
M_SOURCES 	+= $(call CANONICAL_PATH,$(foreach DIR,${IN_SRCDIRS_REC},$(call REC_FILE_SEARCH,${DIR}/,*.c)))
M_SOURCES 	+= $(call CANONICAL_PATH,$(foreach DIR,${IN_SRCDIRS_REC},$(call REC_FILE_SEARCH,${DIR}/,*.cpp)))
M_OBJS 		+= $(addprefix ${M_BUILD_DIR}/,$(addsuffix .o,$(basename ${M_SOURCES})))

M_DEFS := $(addprefix -D,${M_DEFS})
M_INCDIRS := $(addprefix -I,$(call CANONICAL_PATH,${M_INCDIRS}))  

#-----------------------------------------------------------------------------------------------

${M_BUILD_DIR}/%.o: %.c
		@mkdir -p $(dir $@)
		$(strip ${CC} -o $@ -c ${M_CFLAGS} ${M_SRC_CFLAGS} ${M_INCDIRS} \
		    ${M_SRC_INCDIRS} ${M_SRC_DEFS} ${M_DEFS} $<)

${M_BUILD_DIR}/%.o: %.cpp
		@mkdir -p $(dir $@)
		$(strip ${CXX} -o $@ -c ${M_CFLAGS} ${M_SRC_CFLAGS} ${M_INCDIRS} \
		    ${M_SRC_INCDIRS} ${M_SRC_DEFS} ${M_DEFS} $<)

.PHONY: build clean-all

all: clean build # CDT default

build: ${M_TARGET} # see M_PREREQS in target rule

$(eval $(call TARGET_RULE))

clean: clean_${M_TARGET} 

clean_${M_TARGET}:
	$(strip rm -f ${M_TARGET_DIR}/${M_TARGET} ${M_OBJS:%.o=%.[doP]})
	
# special clean: delete all mains
clean_build: clean
	rm -rf ${M_BUILD_DIR}

clean-all: clean $(foreach REQ, ${M_PREREQS}, clean_${REQ})


