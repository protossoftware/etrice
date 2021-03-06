Standalone Generators
=====================

The eTrice generators can be called from the command line. This is useful e.g. if they should participate in a build process driven by command line tools like make.

The generators are distributed as self contained jars and can be called using

`java -jar <the generator.jar> [arguments]`.

The options for the Java generator are

    org.eclipse.etrice.generator.java.Main [-saveGenModel <genmodel path>] [-genDocu] [-lib]
    [-noexit] [-saveGenModel <genmodel path>] [-inc] [-genDir <generation directory>]
    [-genInfoDir <generation info directory>] [-genDocDir <gen documentation directory>]
    [-debug] [-msc_instr] [-gen_as_verbose] [-help] [-persistable]
    [-storeDataObj] <list of model file paths>

          <list of model file paths>         # model file paths may be specified as
                                             # e.g. C:\path\to\model\mymodel.room
          -genDocu                           # if specified documentation is created
          -lib                               # if specified all classes are generated
                                             # and no instances
          -noexit                            # if specified the JVM is not exited
          -saveGenModel <genmodel path>      # if specified the generator model will
                                             # be saved to this location
          -inc                               # if specified the generation is incremental
          -genDir <generation directory>     # the directory for generated files
          -genInfoDir <generation info dir>  # the directory for generated info files
          -genDocDir <gen documentation dir> # the directory for generated documentation files
          -debug                             # if specified create debug output
          -msc_instr                         # generate instrumentation for MSC generation
          -gen_as_verbose                    # generate instrumentation for verbose console output
          -help                              # display this help text

          -persistable                       # if specified make actor classes persistable
          -storeDataObj                      # if specified equip actor classes with
                                             # store/restore using POJOs

The options for the C generator are

    org.eclipse.etrice.generator.c.Main [-saveGenModel <genmodel path>] [-genDocu] [-lib]
    [-noexit] [-saveGenModel <genmodel path>] [-inc] [-genDir <generation directory>]
    [-genInfoDir <generation info directory>] [-genDocDir <gen documentation directory>]
    [-debug] [-msc_instr] [-gen_as_verbose] [-help] [-persistable]
    [-storeDataObj] <list of model file paths>

          <list of model file paths>         # model file paths may be specified as
                                             # e.g. C:\path\to\model\mymodel.room
          -genDocu                           # if specified documentation is created
          -lib                               # if specified all classes are generated
                                             # and no instances
          -noexit                            # if specified the JVM is not exited
          -saveGenModel <genmodel path>      # if specified the generator model will
                                             # be saved to this location
          -inc                               # if specified the generation is incremental
          -genDir <generation directory>     # the directory for generated files
          -genInfoDir <generation info dir>  # the directory for generated info files
          -genDocDir <gen documentation dir> # the directory for generated documentation files
          -debug                             # if specified create debug output
          -msc_instr                         # generate instrumentation for MSC generation
          -gen_as_verbose                    # generate instrumentation for verbose console output
          -help                              # display this help text
