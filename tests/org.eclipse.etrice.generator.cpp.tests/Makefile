# for make.xml

#include ${CPP_MODELLIB_ROOTDIR}/buildTools/modellib.mk
include ${CPP_RUNTIME_ROOTDIR}/buildTools/runtime.mk

# --- 
IN_TARGET 		:= ${APP_TARGET}
IN_BUILD_DIR 	:= ${APP_BUILD_DIR}
IN_INCDIRS 		+= ${APP_SRCDIRS_REC}
IN_SRCDIRS_REC 	+= ${APP_SRCDIRS_REC}
CC				= ${CXX}
IN_CFLAGS		+= -std=c++98 -O0 -g3 -pedantic -Wall
#---

# Create rules
include ${RUNTIME_ROOTDIR}/buildTools/Makefile.mk