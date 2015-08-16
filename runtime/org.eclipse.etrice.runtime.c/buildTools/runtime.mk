include ${RUNTIME_ROOTDIR}/buildTools/defaults.mk

# Includes
DIR_COMMON := ${RUNTIME_ROOTDIR}/src/common
DIR_CONFIG := ${RUNTIME_ROOTDIR}/src/config
DIR_UTIL := ${RUNTIME_ROOTDIR}/src/util
DIR_PLATFORM := ${RUNTIME_ROOTDIR}/src/platforms/${TARGET_PLATFORM}
RUNTIME_INCDIRS := ${DIR_COMMON} ${DIR_CONFIG} ${DIR_UTIL} ${DIR_PLATFORM}


IN_INCDIRS += ${RUNTIME_INCDIRS}

IN_LDFLAGS += -L${RUNTIME_ROOTDIR}/${TARGET_BUILD_DIR}
IN_LDLIBS  += -lorg.eclipse.etrice.runtime.c
ifeq ($(strip ${ECLIPSE_MODE}),)
	IN_PREREQS += liborg.eclipse.etrice.runtime.c.a
endif

liborg.eclipse.etrice.runtime.c.a:
	${MAKE} -C ${RUNTIME_ROOTDIR} build
	
clean_liborg.eclipse.etrice.runtime.c.a:
	${MAKE} -C ${RUNTIME_ROOTDIR} clean

# Linker flags
ifeq (${TARGET_PLATFORM},MT_POSIX_GENERIC_GCC)
IN_LDLIBS  += -lpthread -lrt -lm
else ifeq (${TARGET_PLATFORM},MT_WIN_MinGW)
IN_LDLIBS  += -lws2_32
endif


	






