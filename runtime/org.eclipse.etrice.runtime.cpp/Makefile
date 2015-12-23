ifeq ($(strip ${RUNTIME_ROOTDIR}),)
	RUNTIME_ROOTDIR := ../org.eclipse.etrice.runtime.c
endif

include ${RUNTIME_ROOTDIR}/buildTools/runtime.mk

CPP_RUNTIME_INCDIRS := ./src ./src-gen

IN_TARGET 			:= lib$(notdir $(shell pwd)).a
IN_INCDIRS 			+= ${CPP_RUNTIME_INCDIRS}
IN_SRCDIRS_REC 		:= ${CPP_RUNTIME_INCDIRS}
CC					= ${CXX}
IN_CFLAGS			+= -std=c++98 -O0 -g3 -pedantic -Wall

include ${RUNTIME_ROOTDIR}/buildTools/Makefile.mk



