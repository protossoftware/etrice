
Dave-eTrice Toolchain Tutorial
==============================

Introduction
------------

As you already know, eTrice is a ROOM-Tool that provides a high level modeling language for embedded systems. It is perfectly suited for event driven, real time systems. However, each embedded SW relies on an underlying HW, with components like digital I/Os, Sensors, ADCs, DACs, PWMs and so on to connect the real world. Therefore some driver SW is required to control all this HW components and to provide easy access for the higher level SW. To develop the HW-drivers as well as your application logic without changing the development environment, you need a tool chain that provides both, driver development and high level application development. For Infineon's XMC&trade; ARM Cortex M0/M4 devices special support is provided to combine the Dave&trade; tool for driver development with eTrice for application development. This tutorials will guide you through the first steps.

The tutorials relies on the XMC4700 Relax Lite Kit. As a precondition you should be familiar with Dave&trade;. It is very easy to adapt the tutorials to any other development board or to your own HW.           

Getting Started without Operating System
----------------------------------------

Within this tutorial you will perform the following steps:

-   create a Dave&trade; basic model
-   run the *New Set of eTrice Models* wizard
-   create a simple blinky model
-   generate, build and run the application
-   optionally extend the blinky state machine and create a button controller to switch blinky on and off


###Step 1:###
As a starting point you should create a Dave&trade; project for the target HW. Let's call the project *BlinkyTutorial_RelaxKit4700_ST*, where *ST* stands for *Single Threaded*. The following APPs should be included:

-   Systimer
-   2 * Digital outputs for the two LEDs.
-   2 * Digital inputs for the buttons.

The resulting project should look like this:

![image](images/400-DaveBasicProject.png)

Make sure that the pins are configured correctly. It is a good idea to run it on the real HW to verify that everything is configured correctly.

###Step 2:###
Run the *New Set of new eTrice Models" wizard.

Before you can run the wizard you have to create a folder called *model*.
*right click on the project -> new -> other*

![image](images/400-DaveCreateFolder.png)

Name the folder *model*

Run the *New Set of eTrice Models" wizard.
*Right click on the newly created folder -> new -> other*
Select *eTrice/C/New Set of eTrice Models*

![image](images/400-RunNewModelWizzard.png)

Click *Next*
Name the model *BlinkyTutorial*

Click *Next*
Enable the check box *Copy C-Runtime into project*
Select *ST_XMC_Dave* as active platform.
Rename main to *etStart*.

![image](images/400-SelectRuntime.png)

Click *Finish*

The resulting project should look like this:

![image](images/400-FirstEtriceModel.png)

The following files/folders should have been created:

-   *etrice_c_runtime*
-   *etrice_c_modellib* within the *model* folder
-   *BlinkyTutorial.etmap*
-   *BlinkyTutorial.etphys*
-   *BlinkyTutorial.room*
-   *gen_BlinkyTutorial.launch*
-   *run_BlinkyTutorial.launch*

Now you have successfully created your first eTrice model. To complete the step you should generate C-Code out of the model.
Right click on *gen_BlinkyTutorial.launch -> Run As -> gen_BlinkyTutorial*

![image](images/400-RunGenerator.png)

Make sure that your outline view is activated. *Window -> Show View -> Outline*.

Once the code is generated you should build the application. After the first build two additional folders are created:
-   *src-gen*
-   *src-gen-info*

To start the model, you should call etStart from the Dave&trade; generated main function.

![image](images/400-DaveMain.png)

###Step 3:###
Now everything is arranged to start modeling with eTrice. 

The first step is to import some predefined services. Open the *BlinkyTutorial.room* and add the two import statements:
 
```room
RoomModel BlinkyTutorial {

    import room.basic.types.* from "etrice_c_modellib/Types.room"

    import room.basic.service.timing.* from "etrice_c_modellib/TimingService.room"

    LogicalSystem BlinkyTutorial {
        SubSystemRef main: MainSubSystem
    }
```
In the outline view right click the SubSystem and opne the structure editor:

![image](images/400-OpenStructureEditorSubsystem.png)

Drag and Drop an *ActorRef* into the subsystem.

![image](images/400-AddActorRefDragAndDrop.png)

Select the ActorClass *ATimingService* and name the reference *timing*.

Draw a connection from *application* to *timing*.

![image](images/400-SubSystemWithTimingService.png)

Open *BlinkyTutorial.room* and create a new Actor called AHWAbstraction by adding the following text:

```room
ActorClass AHWAbstraction {
    Structure {
        usercode1 {
            "#include \"Dave.h\""
        }
    }
}
```
Check the outline view to verify that the actor was created.

Create a new protocol class by adding the following:

```room
ProtocolClass POnOff {
    incoming {
        Message on()
        Message off()
    }
    outgoing { }
}
```
Check the outline view to see that the protocol was created.

In the outline view right click on *AHWAbstraction -> Edit Structure* to open the structure editor of the actor.    

![image](images/400-OpenStructureEditor.png)

Within the structure editor create a new *Interface Port*

![image](images/400-CreateInterfacePort.png)

Name the port *LED1*, the port must be from the newly created protocol type *POnOff*.

![image](images/400-NewInterfacePort.png)

Create the state machine of the *AHWAbstraction* actor:
Inside the structure editor, right click on the actor.
Select *Open Class Behavior*

![image](images/400-OpenClassBehaviour.png)

The resulting FSM should look like this:

![image](images/400-HWActorFSM.png)

It is just one state with two transitions. Each transition carries one action to switch a digital IO. Here we have the interface to the Dave&trade; generated code. The transitions will be triggered from the *POnOff* protocol.

The resulting textual representation should look like this:

```room
ActorClass AHWAbstraction {
    Interface {
        Port LED1: POnOff
    }
    Structure {
        usercode1 {
            "#include \"Dave.h\""
        }
        external Port LED1
    }
    Behavior {
        StateMachine {
            State state0
            Transition init: initial -> state0
            Transition tr0: state0 -> state0 {
                triggers {
                    <on: LED1>
                }
                action {
                    "DIGITAL_IO_SetOutputHigh(&LED1_P5_9);"
                }
            }
            Transition tr1: state0 -> state0 {
                triggers {
                    <off: LED1>
                }
                action {
                    "DIGITAL_IO_SetOutputLow(&LED1_P5_9);"
                }
            }
        }
    }
}
```

Now create an ActorClass called *ABlinky* by adding the following text:

```room
ActorClass ABlinky {
    Structure {
        SAP timer: PTimer
    }
}
```
Recognize that the structure contains a Service Access Point (SAP) which allows you to use the timing service.

Now, add an additional interface port called *out* as you did it before and make it a *conjugated* port. Create the following state machine:

![image](images/400-BlinkyFSM.png)

On the initial transition the timer will be started. On the transitions between the states a message *on* or *off* will be sent via the *out* port.

The resulting textual representation looks like this:

```room
ActorClass ABlinky {
    Interface {
        conjugated Port ^out: POnOff
    }
    Structure {
        SAP timer: PTimer
        external Port ^out
    }
    Behavior {
        StateMachine {
            State state0
            State state1
            Transition init: initial -> state0 {
                action {
                    "timer.startTimer(300);"
                }
            }
            Transition tr0: state0 -> state1 {
                triggers {
                    <timeout: timer>
                }
                action {
                    "out.on();"
                }
            }
            Transition tr1: state1 -> state0 {
                triggers {
                    <timeout: timer>
                }
                action {
                    "out.off();"
                }
            }
        }
    }
}
```
 
The last step is to build up the application containing the actor classes *ABlinky* and *AHWAbstraction*.
In the outline view right click to *application -> Edit Structure*
Add *ActorRef* blinky of ActorClass *ABlinky*. The same for the *AHWAbstraction*.
Draw the binding between the ports. The resulting system should look like this:

![image](images/400-ApplicationABlinkyHW.png)

The resulting representation of the complete model should look like this:

```room
RoomModel BlinkyTutorial {

    import room.basic.types.* from "etrice_c_modellib/Types.room"

    import room.basic.service.timing.* from "etrice_c_modellib/TimingService.room"

    LogicalSystem BlinkyTutorial {
        SubSystemRef main: MainSubSystem
    }

    SubSystemClass MainSubSystem {
        ActorRef appl: Application
        LogicalThread defaultThread
        LayerConnection ref appl satisfied_by timing.timer
        ActorRef timing: ATimingService
    }

    ActorClass ABlinky {
        Interface {
            conjugated Port ^out: POnOff
        }
        Structure {
            SAP timer: PTimer
            external Port ^out
        }
        Behavior {
            StateMachine {
                State state0
                State state1
                Transition init: initial -> state0 {
                    action {
                        "timer.startTimer(300);"
                    }
                }
                Transition tr0: state0 -> state1 {
                    triggers {
                        <timeout: timer>
                    }
                    action {
                        "out.on();"
                    }
                }
                Transition tr1: state1 -> state0 {
                    triggers {
                        <timeout: timer>
                    }
                    action {
                        "out.off();"
                    }
                }
            }
        }
    }

    ActorClass AHWAbstraction {
        Interface {
            Port LED1: POnOff
        }
        Structure {
            usercode1 {
                "#include \"Dave.h\""
            }
            external Port LED1
        }
        Behavior {
            StateMachine {
                State state0
                Transition init: initial -> state0
                Transition tr0: state0 -> state0 {
                    triggers {
                        <on: LED1>
                    }
                    action {
                        "DIGITAL_IO_SetOutputHigh(&LED1_P5_9);"
                    }
                }
                Transition tr1: state0 -> state0 {
                    triggers {
                        <off: LED1>
                    }
                    action {
                        "DIGITAL_IO_SetOutputLow(&LED1_P5_9);"
                    }
                }
            }
        }
    }

    ProtocolClass POnOff {
        incoming {
            Message on()
            Message off()
        }
        outgoing { }
    }

    ActorClass Application {
        Structure {
            ActorRef hw: AHWAbstraction
            ActorRef blinky: ABlinky
            Binding blinky.^out and hw.LED1
        }
    }
}
```

The model is finished know.
If you missed some steps in between, you also can copy the complete model to your .room file.

###Step 4:###
Generate, build and run the application.

Generate the application as you did it in step1. Build the generated code and download it to the target as you normally do it.
The LED1 should blink in a 300ms interval.

Congratulations, you have built you first eTrice Application on top of the Dave&trade; drivers!!!

###Step 5:###
As further exercise you can extend the model in the following way:

-   add a control port to *ABlinky* from type *POnOff*
-   extend the behavior so that you can switch off and on the blink light
-   create a button controller, that recognizes button presses
-   do it for both buttons and LEDs
-   put everything together to create the complete application

There are many solutions. Here is one of the possible solutions:

![image](images/400-DualBlinkyStruct.png)

and the complete textual model:

```room
RoomModel BlinkyTutorial {

    import room.basic.types.* from "etrice_c_modellib/Types.room"

    import room.basic.service.timing.* from "etrice_c_modellib/TimingService.room"

    LogicalSystem BlinkyTutorial {
        SubSystemRef main: MainSubSystem
    }

    SubSystemClass MainSubSystem {
        ActorRef appl: Application
        LogicalThread defaultThread
        LayerConnection ref appl satisfied_by timing.timer
        ActorRef timing: ATimingService
    }

    ActorClass ABlinky {
        Interface {
            conjugated Port ^out: POnOff
            Port ctrl: POnOff
        }
        Structure {
            SAP timer: PTimer
            external Port ^out
        external Port ctrl
        }
        Behavior {
            StateMachine {
                State off
                
                State blinking {
                    subgraph {
                        State on {
                            entry {
                                "out.on();"
                            }
                        }
                        State off {
                            entry {
                                "out.off();"
                            }
                        }
                        EntryPoint tp0
                        Transition tr0: on -> off {
                            triggers {
                                <timeout: timer>
                            }
                        }
                        Transition tr1: off -> on {
                            triggers {
                                <timeout: timer>
                            }
                        }
                        Transition tr2: my tp0 -> on {
                            action {
                                "timer.startTimer(300);"
                            }
                        }
                    }
                }
                Transition init: initial -> off {
                    }
                
                Transition tr0: off -> tp0 of blinking {
                    triggers {
                        <on: ctrl>
                    }
                }
            Transition tr1: blinking -> off {
                    triggers {
                        <off: ctrl>
                    }
                    action {
                        "timer.kill();"
                        "out.off();"
                    }
                }
            }
        }
    }

    ActorClass AHWAbstraction {
        Interface {
            Port LED1: POnOff
            Port LED2: POnOff
            conjugated Port BUTTON1: POnOff
            conjugated Port BUTTON2: POnOff
        }
        Structure {
            usercode1 {
                "#include \"Dave.h\""
            }
            SAP timer: PTimer
            external Port LED1
            external Port LED2
            external Port BUTTON1
            external Port BUTTON2
            Attribute b1Status: int8
            Attribute b2Status: int8
        }
        Behavior {
            StateMachine {
                State state0
                Transition init: initial -> state0 {
                    action {
                        "timer.startTimer(50);"
                    }
                }
                Transition tr0: state0 -> state0 {
                    triggers {
                        <on: LED1>
                    }
                    action {
                        "DIGITAL_IO_SetOutputHigh(&LED1_P5_9);"
                    }
                }
                Transition tr1: state0 -> state0 {
                    triggers {
                        <off: LED1>
                    }
                    action {
                        "DIGITAL_IO_SetOutputLow(&LED1_P5_9);"
                    }
                }
                Transition tr2: state0 -> state0 {
                    triggers {
                        <on: LED2>
                    }
                    action {
                        "DIGITAL_IO_SetOutputHigh(&LED2_P5_8);"
                    }
                }
                Transition tr3: state0 -> state0 {
                    triggers {
                        <off: LED2>
                    }
                    action {
                        "DIGITAL_IO_SetOutputLow(&LED2_P5_8);"
                    }
                }
                Transition tr4: state0 -> state0 {
                    triggers {
                        <timeout: timer>
                    }
                    action 
                {
                        "if (DIGITAL_IO_GetInput(&BUTTON1_P15_13) == 0){"
                        "  if (b1Status == 0){"
                        "\t// input changed"
                        "\tb1Status = 1;"
                        "\tBUTTON1.on();"
                        "  }"
                        "}"
                        "else{"
                        "  if (b1Status == 1){"
                        "\t// input changed"
                        "\tb1Status = 0;"
                        "\tBUTTON1.off();"
                        "  }"
                        "}"
                        ""
                        "if (DIGITAL_IO_GetInput(&BUTTON2_P15_12) == 0){"
                        "  if (b2Status == 0){"
                        "\t// input changed"
                        "\tb2Status = 1;"
                        "\tBUTTON2.on();"
                        "  }"
                        "}"
                        "else{"
                        "  if (b2Status == 1){"
                        "\t// input changed"
                        "\tb2Status = 0;"
                        "\tBUTTON2.off();"
                        "  }"
                        "}"
                    }
                }
            }
        }
    }

    ProtocolClass POnOff {
        incoming {
            Message on()
            Message off()
        }
        outgoing { }
    }
    ActorClass AButtonController {
        Interface {
            Port ctrl: POnOff
            conjugated Port ^out: POnOff
        }
        Structure {
            external Port ctrl
            external Port ^out
        }
    Behavior {
            StateMachine {
                State off
                State on
                Transition init: initial -> off
                Transition tr0: off -> on {
                    triggers {
                        <on: ctrl>
                    }
                    action {
                        "out.on();"
                    }
                }
                Transition tr1: on -> off {
                    triggers {
                        <on: ctrl>
                    }
                    action {
                        "out.off();"
                    }
                }
            }
        }
    }
    ActorClass Application {
        Structure {
            ActorRef hw: AHWAbstraction
            ActorRef blinky1: ABlinky
            Binding blinky1.^out and hw.LED1
        Binding blinky2.^out and hw.LED2
            ActorRef blinky2: ABlinky
        Binding hw.BUTTON1 and button1.ctrl
            Binding button2.ctrl and hw.BUTTON2
            Binding button2.^out and blinky2.ctrl
            Binding blinky1.ctrl and button1.^out
            ActorRef button1: AButtonController
            ActorRef button2: AButtonController
        }
    }

}
```

In the tutorial we used the Systimer APP as timing base for the model. It is also possible to run the model without the Systimer APP. Please open *etrice-c-runtime/src/platforms/ST_XMC_Dave/etPlatform.h*. To work without Systimer APP you just need to undef *ET_USE_DAVE_SYSTIMER_APP*. In this case you have to remove the Systimer APP from the Dave&trade; model.


Getting Started with FreeRTOS
-----------------------------

To start with an operating system the steps are almost the same.

-   create the Dave&trade; project and add the FreeRTOS APP and all other required components
-   run the "New Set of eTrice models* wizard and select the appropriate runtime library
-   model your application (or make a copy from the *ST*-Tutorial)
-   adapt the thread deployment to your needs 

###Step 1:###

Create the Dave&trade; project and add the necessary components. For the *BlinkyTutorial* we need again two LEDs, two buttons and the FreeRTOS APP.

![image](images/500-DaveProjectFreeRTOS.png)

Configure the FreeRTOS APP. Set the Tick rate to 1000.
![image](images/500-FreeRtosConfig1.png)

Increase the heap size to 8192 bytes and enable *Use tick hook*
![image](images/500-FreeRtosConfig2.png)

Start the Dave&trade; code generator, compile and debug the application. Make sure that the Dave&trade; settings are complete.  
###Step 2:###
Create a new folder called *model*, right click on the folder *New -> Other* select *Other/eTrice/C/New Set of eTrice Models*

Name the model *BlinkyTutorial*, enable *Copy C-runtime into project*, select *MT_XMC_Dave_FreeRTOS* and rename main to *etStart*.

![image](images/500-NewModelWizzardFreeRTOS.png)
 
Click *Finish*

Run the code generator as you did it in the ST-Tutorial. Compile your project.

Open *main.c* and call *etStart* as you did it in the ST-Tutorial.

###Step 3:###

From now on you can create your model or you can copy the *BlinkyTutorial.room* file from the ST-Tutorial to the new project.

Generate the code, compile and debug.

###Step 4:###
In the ST-Tutorial you have created an application that runs without operating system. That means, everything runs in a single main loop. Now we have an underlying preemtive operating system and we can deploy SW-Components to different threads. With eTrice 3 simple steps are necessary:

-   create physical threads
-   create logical threads and map actors to logical threads
-   map logical threads to physical threads

Physical thread creation must be done in *BlinkyTutorial.etphys*. Open the file, create 2 additional physical threads:

```etphys
PhysicalModel BlinkyTutorial {

    PhysicalSystem PhysSys1 {
        NodeRef nodeRef1 : NodeClass1
    }

    NodeClass NodeClass1 {
        runtime = RuntimeClass1
        priomin = -10
        priomax = 10
        DefaultThread PhysicalThread1 {
            execmode = mixed
            interval = 100ms
            prio = 2
            stacksize = 128
            msgblocksize = 32
            msgpoolsize = 10
        }
        Thread HighPrioThread {
            execmode = mixed
            interval = 10ms
            prio = 3
            stacksize = 128
            msgblocksize = 32
            msgpoolsize = 10
        }
        
        Thread LowPrioThread {
            execmode = mixed
            interval = 200ms
            prio = 3
            stacksize = 128
            msgblocksize = 32
            msgpoolsize = 10
        }
    }

    RuntimeClass RuntimeClass1 {
        model = multiThreaded
    }
}
```

Adapt priorities and stack sizes to your needs. Keep in mind to reserve memory in the FREERTOS APP configuration.

Logical thread creation must be done in the logical model *BlinkyTutorial.room*. Open the file and add two threads and map actor instances to the newly created threads.

```room
RoomModel BlinkyTutorial {

    import room.basic.types.* from "etrice_c_modellib/Types.room"

    import room.basic.service.timing.* from "etrice_c_modellib/TimingService.room"

    LogicalSystem BlinkyTutorial {
        SubSystemRef main: MainSubSystem
    }

    SubSystemClass MainSubSystem {
        ActorRef appl: Application
        LogicalThread defaultThread
        LogicalThread highPrioThread
        LogicalThread lowPrioThread
        LayerConnection ref appl satisfied_by timing.timer
        ActorRef timing: ATimingService
        ActorInstanceMapping timing -> highPrioThread
        ActorInstanceMapping appl/blinky1->lowPrioThread
        ActorInstanceMapping appl/button1->lowPrioThread
    }
```

We created three logical threads and deployed the timing service to the *highPrioThread*, *blinky1* and *button1* to the *lowPrioThread*. All other actors are automatically deployed to the default thread.
Please recognize that you deploy actor instances and not actor classes.

The last step is the mapping of the logical threads to physical threads. Open *BlinkyTutorial.etmap* and do your mapping:

```etmap
MappingModel BlinkyTutorial {
	import BlinkyTutorial.* from "BlinkyTutorial.room"
	import BlinkyTutorial.* from "BlinkyTutorial.etphys"
	Mapping BlinkyTutorial -> PhysSys1 {
		SubSystemMapping main -> nodeRef1 {
			ThreadMapping defaultThread -> PhysicalThread1
			ThreadMapping highPrioThread -> HighPrioThread
			ThreadMapping lowPrioThread -> LowPrioThread
		}
	}
}
```

Generate your code, compile and debug the application.
Have fun.
