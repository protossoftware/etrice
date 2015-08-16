# CANONICAL_PATH - Given one or more paths, converts the paths to the canonical
#   form. The canonical form is the path, relative to the project's top-level
#   directory (the directory from which "make" is run), and without
#   any "./" or "../" sequences. For paths that are not  located below the
#   top-level directory, the canonical form is the absolute path (i.e. from
#   the root of the filesystem) also without "./" or "../" sequences.
define CANONICAL_PATH
$(patsubst ${CURDIR}/%,%,$(abspath ${1}))
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
	IN_BUILD_DIR := ${TARGET_BUILD_DIR}
endif

ifeq ($(strip ${IN_TARGET_DIR}),)
	IN_TARGET_DIR := ${IN_BUILD_DIR}
endif

# Locals, no override
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


# add sources from M_SRCDIRS_REC
_TRAVERSECHILDREN = ${1} $(foreach CHILD,$(filter-out ${1}/,$(sort $(dir $(wildcard ${1}/*/)))),$(call ${0},$(patsubst %/,%,${CHILD})))
_RECDIRS := $(foreach BASEDIR, ${M_SRCDIRS_REC}, $(call _TRAVERSECHILDREN, $(patsubst %/,%,${BASEDIR})))
M_SOURCES += $(foreach DIR, ${_RECDIRS}, $(wildcard ${DIR}/*.c))

M_DEFS := $(addprefix -D,${M_DEFS})
M_INCDIRS := $(addprefix -I,$(call CANONICAL_PATH,${M_INCDIRS}))  
M_SOURCES	:= $(call CANONICAL_PATH,${M_SOURCES})

# Convert the source file names to their corresponding object file names.
M_OBJS := $(addprefix ${M_BUILD_DIR}/,$(addsuffix .o,$(basename ${M_SOURCES})))

${M_BUILD_DIR}/%.o: %.c
		@mkdir -p $(dir $@)
		$(strip ${CC} -o $@ -c ${M_CFLAGS} ${M_SRC_CFLAGS} ${M_INCDIRS} \
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


