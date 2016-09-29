@ECHO OFF

REM this script flattens the folder structure of some projects to make development more convenient
REM symbolic links (mklink) are used to link to the git repository
REM This script works only for NTFS filesystem

SET parent=%~dp0
SET dest=%~1

if "%dest%"=="" (
    ECHO Provide a destination folder for symbolic links !
    EXIT /B
)

IF NOT EXIST "%dest%" (
	ECHO Destination folder for symbolic links does not exist: %dest% !
    EXIT /B
)

@ECHO ON

REM examples
mklink /J %dest%\org.eclipse.etrice.tutorials.c %parent%..\examples\org.eclipse.etrice.tutorials.c
mklink /J %dest%\org.eclipse.etrice.tutorials.cpp %parent%..\examples\org.eclipse.etrice.tutorials.cpp
mklink /J %dest%\org.eclipse.etrice.tutorials.java %parent%..\examples\org.eclipse.etrice.tutorials.java

mklink /J %dest%\org.eclipse.etrice.examples.c %parent%..\examples\org.eclipse.etrice.examples.c
mklink /J %dest%\org.eclipse.etrice.examples.java %parent%..\examples\org.eclipse.etrice.examples.java

mklink /J %dest%\org.eclipse.etrice.generator.c.reference %parent%..\examples\org.eclipse.etrice.generator.c.reference
mklink /J %dest%\org.eclipse.etrice.generator.cpp.reference %parent%..\examples\org.eclipse.etrice.generator.cpp.reference

REM runtime
mklink /J %dest%\org.eclipse.etrice.modellib.c %parent%..\runtime\org.eclipse.etrice.modellib.c
mklink /J %dest%\org.eclipse.etrice.modellib.java %parent%..\runtime\org.eclipse.etrice.modellib.java
mklink /J %dest%\org.eclipse.etrice.modellib.cpp %parent%..\runtime\org.eclipse.etrice.modellib.cpp
mklink /J %dest%\org.eclipse.etrice.runtime.c %parent%..\runtime\org.eclipse.etrice.runtime.c
mklink /J %dest%\org.eclipse.etrice.runtime.cpp %parent%..\runtime\org.eclipse.etrice.runtime.cpp
mklink /J %dest%\org.eclipse.etrice.runtime.java %parent%..\runtime\org.eclipse.etrice.runtime.java

REM tests
mklink /J %dest%\org.eclipse.etrice.generator.common.tests %parent%..\tests\org.eclipse.etrice.generator.common.tests
mklink /J %dest%\org.eclipse.etrice.runtime.c.tests %parent%..\tests\org.eclipse.etrice.runtime.c.tests
mklink /J %dest%\org.eclipse.etrice.runtime.cpp.tests %parent%..\tests\org.eclipse.etrice.runtime.cpp.tests



