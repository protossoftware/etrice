# Global variables, can be in set environment or overriden
# RUNTIME_ROOTDIR 		e.g. ${workspace_loc:org.eclipse.etrice.runtime.c} 	default: ../org.eclipse.etrice.runtime.c
# MODELLIB_ROOTDIR		e.g. ${workspace_loc:org.eclipse.etrice.modellib.c}	default: ../org.eclipse.etrice.modellib.c
# TARGET_PLATFORM		MT_WIN_MinGW|MT_POSIX_GENERIC_GCC					default MT_WIN_MinGW
# TARGET_BUILD_DIR		automatically derived from TARGET_PLATFORM
# ECLIPSE_MODE			if present, makefile won't build modellib and runtime (let eclipse handle this)

#ifeq ($(strip ${RUNTIME_ROOTDIR}),)
#	RUNTIME_ROOTDIR := ../org.eclipse.etrice.runtime.c
#endif

#ifeq ($(strip ${MODELLIB_ROOTDIR}),)
#	MODELLIB_ROOTDIR := ../org.eclipse.etrice.modellib.c
#endif

ifeq ($(strip ${TARGET_PLATFORM}),)
	TARGET_PLATFORM := MT_WIN_MinGW
endif

ifeq (${TARGET_PLATFORM},MT_POSIX_GENERIC_GCC)
	TARGET_BUILD_DIR := LinuxPosix
else ifeq (${TARGET_PLATFORM},MT_WIN_MinGW)
	TARGET_BUILD_DIR := WindowsMinGW
endif