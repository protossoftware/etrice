# environment variables: RUNTIME_ROOTDIR, MODELLIB_ROOTDIR, TARGET_PLATFORM, TARGET_BUILD_DIR, ECLIPSE_MODE
# default is windows mingw

# CDT Environment:
# RUNTIME_ROOTDIR: ${workspace_loc:org.eclipse.etrice.runtime.c}
# MODELLIB_ROOTDIR: ${workspace_loc:org.eclipse.etrice.modellib.c}
# ECLIPSE_MODE (no value)

ifeq ($(strip ${RUNTIME_ROOTDIR}),)
	RUNTIME_ROOTDIR := ../org.eclipse.etrice.runtime.c
endif
ifeq ($(strip ${CPP_MODELLIB_ROOTDIR}),)
	CPP_MODELLIB_ROOTDIR := ../org.eclipse.etrice.modellib.cpp
endif
ifeq ($(strip ${CPP_RUNTIME_ROOTDIR}),)
	CPP_RUNTIME_ROOTDIR := ../org.eclipse.etrice.runtime.cpp
endif

include ${CPP_MODELLIB_ROOTDIR}/buildTools/modellib.mk
include ${CPP_RUNTIME_ROOTDIR}/buildTools/runtime.mk

# --- 
IN_TARGET 			:= $(notdir $(shell pwd)).exe
IN_INCDIRS 			+= ./src-gen ./src
IN_SRCDIRS_REC 		+= ./src-gen ./src
CC					= ${CXX}
IN_CFLAGS			+= -std=c++98 -O0 -g3 -pedantic -Wall
#---


# Create rules
include ${RUNTIME_ROOTDIR}/buildTools/Makefile.mk
