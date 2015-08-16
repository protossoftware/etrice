include ${RUNTIME_ROOTDIR}/buildTools/defaults.mk

# ---
IN_INCDIRS += ${MODELLIB_ROOTDIR}/src-gen

IN_LDFLAGS += -L${MODELLIB_ROOTDIR}/${TARGET_BUILD_DIR}
IN_LDLIBS  += -lorg.eclipse.etrice.modellib.c
ifeq ($(strip ${ECLIPSE_MODE}),)
	IN_PREREQS += liborg.eclipse.etrice.modellib.c.a
endif

liborg.eclipse.etrice.modellib.c.a: 
	${MAKE} -C ${MODELLIB_ROOTDIR} build

clean_liborg.eclipse.etrice.modellib.c.a:
	${MAKE} -C ${MODELLIB_ROOTDIR} clean

