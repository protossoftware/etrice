include ${RUNTIME_ROOTDIR}/buildTools/defaults.mk

# ---
IN_INCDIRS += ${CPP_MODELLIB_ROOTDIR}/src-gen

IN_LDFLAGS += -L${CPP_MODELLIB_ROOTDIR}/${TARGET_BUILD_DIR}
IN_LDLIBS  += -lorg.eclipse.etrice.modellib.cpp
ifeq ($(strip ${ECLIPSE_MODE}),)
	IN_PREREQS += liborg.eclipse.etrice.modellib.cpp.a
endif

liborg.eclipse.etrice.modellib.cpp.a: 
	${MAKE} -C ${CPP_MODELLIB_ROOTDIR} build

clean_liborg.eclipse.etrice.modellib.cpp.a:
	${MAKE} -C ${CPP_MODELLIB_ROOTDIR} clean

