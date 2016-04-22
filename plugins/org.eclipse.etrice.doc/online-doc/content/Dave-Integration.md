
Dave-eTrice Toolchain Tutorial
==============================

Intruduction
------------

As you already know, eTrice is a ROOM-Tool that provides a high level modeling language for embedded systems. It is perfectly suited for event driven, real time systems. However, each embedded SW relies on an underlying HW, with components like digital I/Os, Sensors, ADCs, DACs, PWMs and so on to connect the real world. Therefore some driver SW is required to control all this HW components and to provide easy access for the higher level SW. To develop the HW-drivers as well as your application logic without changing the development environment, you need a tool chain that provides both. For Infineon´s XMC&trade; ARM Cortex M0/M4 devices special support is provided to combine the Dave&trade; tool for driver development with eTrice for application development. This tutorials will guide you through the first steps.

The tutorials relies on the XMC4700 Relax Lite Kit. As a precondition you should be familiar with Dave&trade;. It is very easy to adapt the tutorials to any other development board or to your own HW.           

Getting Started without Operating System
----------------------------------------

Within this tutorial you will perform the following steps:

-   create a Dave&trade; basic model
-   create a model folder
-   run the *New Set of new eTrice Models* wizzard
-   create a blinky state machine
-   optionally extend the blinky state machine and create a button controller to switch blinky on and off


###Step 1:###
As a starting point you should create a Dave&trade; project for the target HW. Let´s call the project *BlinkyTutorial_RelaxKit4700_ST*, where *ST* stands for *Single Threaded*. The following APPs should be included:

-   Systimer
-   2 * Digital outputs for the two LEDs.
-   2 * Digital inputs for the buttons.

The resulting project should look like this:

![image](images/400-DaveBasicProject.png)

Make sure that the pins are configured correctly. It is a good idea to run it on the real HW to verify that everything is configured correctly.

###Step 2:###
Create a folder called *model*.
*right click on the project -> new -> other*

![image](images/400-DaveCreateFolder.png)

Name the folder *model*

###Step 3:###
Run the *New Set of new eTrice Models" wizzard.
*right click on the newly created folder -> new -> other*
Select *eTrice/C/New Set of eTrice Models*

![image](images/400-RunNewModelWizzard.png)

Klick *Next*
Name the model *BlinkyTutorial*

Klick *Next*
Enable the check box *Copy C-Runtime into project*
Select *ST_XMC_Dave* as active platform.
Rename main as *etStart*.

![image](images/400-SelectRuntime.png)

Klick *Finish*

The resulting projects should look like this:

![image](images/400-FirstEtriceModel.png)

The following files/folders should be created:

-   *etrice-c-runtime*
-   *etrice-c-modellib* within the *model* folder
-   *BlinkyTutorial.etmap*
-   *BlinkyTutorial.etphys*
-   *BlinkyTutorial.room*
-   *gen_BlinkyTutorial.launch*
-   *run_BlinkyTutorial.launch*

Now you have successfully created your first eTrice model. To complete the step you should generate C-Code out of the model.
Right klick on *gen_BlinkyTutorial.launch -> Run As -> gen_BlinkyTutorial*

![image](images/400-RunGenerator.png)

Once the code is generated you build the application. After the first build two additional folders should be created:
-   *src-gen*
-   *src-gen-info*

###Step 4:###
Now everything is arranged to start modeling with eTrice. Make sure that your outline view is activated. *Window -> Show View -> Outline*. 

  


Getting Started with FreeRTOS
-----------------------------


