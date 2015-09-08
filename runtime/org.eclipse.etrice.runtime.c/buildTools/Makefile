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


# Create rules
include ${RUNTIME_ROOTDIR}/buildTools/Makefile.mk