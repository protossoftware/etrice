ifeq ($(strip ${RUNTIME_ROOTDIR}),)
	RUNTIME_ROOTDIR := ../org.eclipse.etrice.runtime.c
endif

include ${RUNTIME_ROOTDIR}/buildTools/runtime.mk

# --- 
IN_TARGET := lib$(notdir $(shell pwd)).a
IN_INCDIRS += ./src-gen
IN_SRCDIRS_REC := ./src-gen
# --- 


# Create rules
include ${RUNTIME_ROOTDIR}/buildTools/Makefile.mk