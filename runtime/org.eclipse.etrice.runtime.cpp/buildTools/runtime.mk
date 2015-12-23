include ${RUNTIME_ROOTDIR}/buildTools/defaults.mk

# Includes
CPP_RUNTIME_INCDIRS := ${CPP_RUNTIME_ROOTDIR}/src ${CPP_RUNTIME_ROOTDIR}/src-gen


IN_INCDIRS += ${CPP_RUNTIME_INCDIRS}

IN_LDFLAGS += -L${CPP_RUNTIME_ROOTDIR}/${TARGET_BUILD_DIR}
IN_LDLIBS  += -lorg.eclipse.etrice.runtime.cpp
ifeq ($(strip ${ECLIPSE_MODE}),)
	IN_PREREQS += liborg.eclipse.etrice.runtime.cpp.a
endif

liborg.eclipse.etrice.runtime.cpp.a:
	${MAKE} -C ${CPP_RUNTIME_ROOTDIR} build
	
clean_liborg.eclipse.etrice.runtime.cpp.a:
	${MAKE} -C ${CPP_RUNTIME_ROOTDIR} clean
	
include ${RUNTIME_ROOTDIR}/buildTools/runtime.mk


	






