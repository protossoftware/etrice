include ${CPP_RUNTIME_ROOTDIR}/buildTools/runtime.mk

# --- 
IN_TARGET 			:= $(notdir $(shell pwd)).exe
IN_BUILD_DIR 		:= ./bin
IN_INCDIRS 			+= ./src
IN_SRCDIRS_REC 		+= ./src
CC					= ${CXX}
IN_CFLAGS			+= -std=c++98 -O0 -g3 -pedantic -Wall
#---


# Create rules
include ${RUNTIME_ROOTDIR}/buildTools/Makefile.mk
