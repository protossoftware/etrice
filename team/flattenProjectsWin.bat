REM this script flattens the folder structure of some projects to make development more convenient
REM symbolic links (mklink) are used to link to the git repository
REM This script works only for NTFS filesystem  

REM create folder for flat world
mkdir ..\..\FlatWorld

REM examples
mklink /J ..\..\FlatWorld\org.eclipse.etrice.tutorials.simulators.trafficlight.example ..\examples\org.eclipse.etrice.tutorials.simulators.trafficlight.example
mklink /J ..\..\FlatWorld\org.eclipse.etrice.tutorials.c ..\examples\org.eclipse.etrice.tutorials.c
mklink /J ..\..\FlatWorld\org.eclipse.etrice.tutorials.java ..\examples\org.eclipse.etrice.tutorials.java
mklink /J ..\..\FlatWorld\org.eclipse.etrice.generator.c.reference ..\examples\org.eclipse.etrice.generator.c.reference

mklink /J ..\..\FlatWorld\org.eclipse.etrice.examples.dynamicactors1 ..\examples\org.eclipse.etrice.examples.dynamicactors1
mklink /J ..\..\FlatWorld\org.eclipse.etrice.examples.dynamicactors2 ..\examples\org.eclipse.etrice.examples.dynamicactors2
mklink /J ..\..\FlatWorld\org.eclipse.etrice.examples.dynamicactors3 ..\examples\org.eclipse.etrice.examples.dynamicactors3
mklink /J ..\..\FlatWorld\org.eclipse.etrice.examples.dynamicactors4 ..\examples\org.eclipse.etrice.examples.dynamicactors4
mklink /J ..\..\FlatWorld\org.eclipse.etrice.examples.dynamicactors5 ..\examples\org.eclipse.etrice.examples.dynamicactors5
mklink /J ..\..\FlatWorld\org.eclipse.etrice.examples.dynamicactors6 ..\examples\org.eclipse.etrice.examples.dynamicactors6
mklink /J ..\..\FlatWorld\org.eclipse.etrice.examples.dynamicactors7 ..\examples\org.eclipse.etrice.examples.dynamicactors7
mklink /J ..\..\FlatWorld\org.eclipse.etrice.examples.dynamicactors8 ..\examples\org.eclipse.etrice.examples.dynamicactors8

mklink /J ..\..\FlatWorld\org.eclipse.etrice.tutorials.java.aspecttrace ..\examples\org.eclipse.etrice.tutorials.java.aspecttrace
mklink /J ..\..\FlatWorld\org.eclipse.etrice.runtime.java.aspects ..\runtime\org.eclipse.etrice.runtime.java.aspects


REM runtime
mklink /J ..\..\FlatWorld\org.eclipse.etrice.modellib.c ..\runtime\org.eclipse.etrice.modellib.c
mklink /J ..\..\FlatWorld\org.eclipse.etrice.modellib.java ..\runtime\org.eclipse.etrice.modellib.java
mklink /J ..\..\FlatWorld\org.eclipse.etrice.runtime.c ..\runtime\org.eclipse.etrice.runtime.c
mklink /J ..\..\FlatWorld\org.eclipse.etrice.runtime.java ..\runtime\org.eclipse.etrice.runtime.java

REM tests
mklink /J ..\..\FlatWorld\org.eclipse.etrice.runtime.c.tests ..\tests\org.eclipse.etrice.runtime.c.tests
