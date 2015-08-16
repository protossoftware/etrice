# environment variables: RUNTIME_ROOTDIR, MODELLIB_ROOTDIR, TARGET_PLATFORM, TARGET_BUILD_DIR, ECLIPSE_MODE
# default is windows mingw

# CDT Environment:
# RUNTIME_ROOTDIR: ${workspace_loc:org.eclipse.etrice.runtime.c}
# MODELLIB_ROOTDIR: ${workspace_loc:org.eclipse.etrice.modellib.c}

ifeq ($(strip ${RUNTIME_ROOTDIR}),)
	RUNTIME_ROOTDIR := ../org.eclipse.etrice.runtime.c
endif
ifeq ($(strip ${MODELLIB_ROOTDIR}),)
	MODELLIB_ROOTDIR := ../org.eclipse.etrice.modellib.c
endif

include ${MODELLIB_ROOTDIR}/buildTools/modellib.mk
include ${RUNTIME_ROOTDIR}/buildTools/runtime.mk

# --- 
IN_TARGET 			:= $(notdir $(shell pwd)).exe
IN_INCDIRS 			+= ./src-gen ./src
IN_SRCDIRS_REC 		+= ./src-gen ./src
#---

# Do NOT set IN_XX as make paramater or environment variable,
# instead make variables from outside explicit:
# IN_TARGET 		:= ${APP_TARGET}
# IN_INCDIRS 		+= ${APP_INCDIRS}
# IN_SRCDIRS_REC 	+= ${APP_SRCDIRS_REC}

# All options:
#IN_TARGET 
#IN_TARGET_DIR
#IN_BUILD_DIR
#IN_TARGET_PLATFORM
#IN_INCDIRS
#IN_SRCDIRS_REC
#IN_SOURCES
#IN_CFLAGS
#IN_DEFS
#IN_LDFLAGS
#IN_LDLIBS
#IN_PREREQS

# Create rules
include ${RUNTIME_ROOTDIR}/buildTools/Makefile.mk