include buildTools/defaults.mk

DIR_COMMON := ./src/common
DIR_CONFIG := ./src/config
DIR_UTIL := ./src/util
DIR_PLATFORM := ./src/platforms/${TARGET_PLATFORM}
RUNTIME_INCDIRS := ${DIR_COMMON} ${DIR_CONFIG} ${DIR_UTIL} ${DIR_PLATFORM}


IN_TARGET := lib$(notdir $(shell pwd)).a
IN_INCDIRS := ${RUNTIME_INCDIRS}
IN_SRCDIRS_REC := ${RUNTIME_INCDIRS}

include buildTools/Makefile.mk



