ifeq ($(strip ${RUNTIME_ROOTDIR}),)
	RUNTIME_ROOTDIR := ../org.eclipse.etrice.runtime.c
endif
ifeq ($(strip ${CPP_RUNTIME_ROOTDIR}),)
	CPP_RUNTIME_ROOTDIR := ../org.eclipse.etrice.runtime.cpp
endif

include ${CPP_RUNTIME_ROOTDIR}/buildTools/runtime.mk

# --- 
IN_TARGET 			:= lib$(notdir $(shell pwd)).a
IN_INCDIRS 			+= ./src-gen
IN_SRCDIRS_REC 		:= ./src-gen
CC					= ${CXX}
IN_CFLAGS			+= -std=c++98 -O0 -g3 -pedantic -Wall
# --- 


# Create rules
include ${RUNTIME_ROOTDIR}/buildTools/Makefile.mk