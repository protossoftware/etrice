Examples
========

The eTrice examples can be installed using the new wizard.

Choose File &gt; New &gt; Other (or Ctrl-N), open category “eTrice”. There are examples for C and for Java. Each of them consists of a single Eclipse project that contains several examples which are described in the next sections. Select the desired one, click Next and Finish and you are ready to go.

As already mentioned each example project contains several examples. Each of them comes with a room model, a mapping model a launch configuration for the code generation and a launch configuration to run the compiled example.

The C examples project
----------------------

This example project `org.eclipse.etrice.examples.c` illustrates a simplified traffic light control. It actually consists of four different steps of increasing complexity that can be generated and built one by one (but not in parallel).

Most of the classes are contained in a common ROOM model `model/TrafficLight/TrafficLight.room` that also shows how ROOM classes can form a library and used as building blocks for several systems. Also the physical model is shared by all steps of this example.

Contained in the example you will find a little Java GUI that some of the example use to simulate a real traffic light. The GUI is contacted using TCP/IP ports 4441 and subsequent. The protocol used on the TCP/IP socket connection is a simple text protocol with commands for the lights. Three of the example steps make use of this simulator GUI. They also contain a launch configuration for it.

**Note:** Before compiling and linking a new step of the example the project should be cleaned to avoid duplicate symbols due to artifacts from the previous build.

### Traffic light - step 1

The main ROOM model and the mapping model of this example is contained in `org.eclipse.etrice.examples.c/model/TrafficLight_step1`. It also contains launch configurations for the code generation and for running the application.

#### Purpose

This example illustrates how a single actor can be tested against a test harness.

#### Details

A `PedestrianTrafficLightController` is an actor that controls a traffic light consisting of a traffic light with red, yellow and green for the cars, a second traffic light with just red and green and a request button for the pedestrians.

The controller has two ports, `fct` and `tlInterface`. The first one uses a protocol `PTrafficLightController` that offers the high level commands `standby`, `start` and `stop`. The second one uses a conjugated protocol `PTrafficLightInterface` which controls each of the lights separately.

The test harness `TrafficLightControllerTestHarness` is connected to both ports and drives the test in several steps.

To run the test first generate the code using `gen_TrafficLight_step1.launch`, then compile and link it (using the CDTbuild). Since this step doesn’t use a GUI you can just start the application using `run_TrafficLight_step1.launch`.

#### Noteworthy

-   usage of a ROOM model as library for several systems

-   creation of a test harness for an actor

### Traffic light - step 2

The main ROOM model and the mapping model of this example is contained in `org.eclipse.etrice.examples.c/model/TrafficLight_step2`. It also contains launch configurations for the code generation, for launching the simulator GUI and for running the application.

#### Purpose

This example shows the control of a single block of traffic lights containing a car light and a light for the pedestrians. It illustrates how a stack of abstraction levels is used to conveniently divide the problem into relatively simple parts.

#### Details

The 4 levels of this application starts with a `TrafficLightHeadquarters` on the top. It controls the global operating mode of the traffic light block. The test harness `TrafficLightControllerTestHarness` is connected to both ports and drives the test in several steps.

On the next level we have a `PedestrianTrafficLightController` which offers some very general commands like `start`, `stop` and `standby`.

On the second level we find an actor `PTrafficLightInterface` that offers basic traffic light control in the form of switching the state of each single light separately.

On the base level we have an actor handling a TCP/IP socket connection with a general text protocol.

To run the test first generate the code using `gen_TrafficLight_step2.launch`, then compile and link it (using the CDTbuild). Since this step uses a GUI with a single block of lights you’ll have to launch the simulator using `run_simulator_1_block.launch`. Then you can just start the application using `run_TrafficLight_step2.launch`.

After going through a short initialization and standby phase the traffic light goes into a mode of permanent green for cars. After pressing the ’request’ button in the simulator GUI the light switches to red for cars and green for pedestrians and back to permanent green for cars.

#### Noteworthy

-   use abstraction levels to break a problem into smaller pieces.

### Traffic light - step 3

The main ROOM model and the mapping model of this example is contained in `org.eclipse.etrice.examples.c/model/TrafficLight_step3`. It also contains launch configurations for the code generation, for launching the simulator GUI and for running the application.

#### Purpose

This example shows the control of two blocks of traffic lights each containing a car light and a light for the pedestrians. It uses a replicated stack of actors as introduced in step 2.

#### Details

The head quarters actor of this example controls two blocks of traffic lights. It already has a replicated port which is now connected to a doubled `PedestrianTrafficLightController`. Of course the replication then has also to be applied to the other levels of the stack introduced in step 2.

To run the test first generate the code using `gen_TrafficLight_step3.launch`, then compile and link it (using the CDTbuild). Since this step uses a GUI with a two blocks of lights you’ll have to launch the simulator using `run_simulator_2_blocks.launch`. Then you can just start the application using `run_TrafficLight_step3.launch`.

#### Noteworthy

-   use replication for multiple instances of the same.

### Traffic light - step 4

The main ROOM model and the mapping model of this example is contained in `org.eclipse.etrice.examples.c/model/TrafficLight_step4`. It also contains launch configurations for the code generation, for launching the simulator GUI and for running the application.

#### Purpose

This example shows the control of two blocks of traffic lights each containing a car light and a light for the pedestrians. It uses a container actor for the three lower levels of the stack introduced in step 2. Then replication has to applied only to the container actor which simplifies the task.

#### Details

The head quarters actor of this example controls two blocks of traffic lights. It already has a replicated port which is now connected to a doubled `TrafficLightControllerWithInfrastructure`. The latter one

#### Noteworthy

-   use hierarchy to group levels functionality to reusable blocks.

### Features

This project illustrates the various ways how replication can be exploited in ROOM. Replication can be chosen for ports and for actor references. The example enumerates a number of typical combinations of the two possibilities.

#### Purpose

Five different ways to combine replicated ports and replicated actor references are shown in this example.

Each of these combination consists of one ore more receivers and one or more senders.

All five combinations are contained in the actor class `ExampleMultiplicity`.

-   `sender1` and `receiver1` - a single sender and a single receiver, both with plain ports, are connected.

-   `multiSender2` with a replication factor of 10 is connected to `multiReceiver2` also with a replication factor of 10 - this is equivalent to 10 single senders each of which is connected to one single out of 10 receivers

-   `multiSender3` with a replication factor of 2 is connected to `receiverMultiPort3` which has a port with replication factor 2

-   `multiSender4` with a replication factor of 10 is connected to `multiReceiverMultiPort4` with a replicated port with cardinality 2 and replicated 5 times - this is equivalent to 5 receivers where each is connected to two senders

-   `multiSender5` is connected to

    -   `receiver5` which is a simple receiver not using any replication

    -   `multiReceiver5` which is a replicated receiver

    -   `` which is not replicated but uses a replicated portreceiverMultiPort5

    -   `multiReceiverMultiPort5` which is replicated and has replicated ports

    So `multiSender5` is connected

    -   once to `receiver5`

    -   three times to `multiReceiver5`

    -   two times to `receiverMultiPort5` and

    -   four times to `multiReceiverMultiPort5`

    which totals to 10 (implicit) connections and matches the replication factor of 10 of `multiSender5`.

#### Details

The head quarters actor of this example controls two blocks of traffic lights. It already has a replicated port which is now connected to a doubled `TrafficLightControllerWithInfrastructure`. The latter one

#### Noteworthy

-   use hierarchy to group levels of functionality to reusable blocks.

The Java examples project
-------------------------

The example project `org.eclipse.etrice.examples.java` currently contains a number of examples that are all related to dynamic actors.

The examples can be generated and executed one by one but not several at the same time. Inside the model folder there exists a sub folder for each example containing all models and launch configurations for code generation and to run the application.

### Dynamic Actors 1

This example is contained in `model/dynamicactors1`.

#### Purpose

The example demonstrates the usage of an optional actor. It is shown that several actor classes derived from the type of the optional actor reference can be optionally created in place of the optional actor reference. Optional actor instances can also be destroyed and another instance can be created in the free slot.

#### Details

The structure of this system is simple.

![image](images/039-DynAct1-Main_instanceTree.jpg)

However, this is only the initial system structure. The leaf instance is just a place holder for an optional actor instance. In this place an instance of a compatible type can be created at run time. Compatible types are the type of the reference itself and all of its sub types as long as they are not abstract. Together with the instance all of its contained instances will be created and all ports are connected.

This example demonstrates how an optional actor is created and destroyed and another one of another type is created to hold the same place.

![image](images/039-DynAct1-Container_behavior.jpg)

When the example is executed the `Container` actor first dumps the instance tree to the console (line 56 of the listing below). Then it creates an instance of `Optional2` (line 57). Now that the `p0` port of the container is connected a message `sayHello()` is sent to the newly created actor instance and the instance tree is dumped a second time. As soon as it receives the answer it prints it to the console. Then the optional actor is destroyed again and another one, now of type `Optional1`, is created and once more `sayHello()` is sent.

The console output of the running application starts with

```
***   T H E   B E G I N   ***
*** MainComponent /LS/main::init ***
type 'quit' to exit
before creation of Optional2
LS
  main
    RTSystemPort
    MessageService_MessageService_PhysicalThread1
      Dispatcher
      Queue
    ActorClass(className=Appl, instancePath=/LS/main/appl)
      port RTSystemPort
      ActorClass(className=Container, instancePath=/LS/main/appl/cont)
        port RTSystemPort
        port p0
        ScalarOptionalActorInterface(className=Optional, instancePath=/LS/main/appl/cont/opt)
          RTSystemPort
          port p0
    port RTSystemPort0
    port RTSystemPort1
```

The `ScalarOptionalActorInterface(className=Optional, instancePath=/LS/main/appl/cont/opt)` is an object which is responsible for the life cycle of the dynamic actor (including its contained instances) and for the mediation of the port connections. It contains a replicated `RTSystemPort` which is used to trigger the initial transition and the port `p0` of the interface of the `Optional` actor class.

After creation of `Optional2` the interesting part of the dumped tree is

```
ScalarOptionalActorInterface(className=Optional, instancePath=/LS/main/appl/cont/opt)
  RTSystemPort
  port p0
  ActorClass(className=Optional2, instancePath=/LS/main/appl/cont/opt/opt)
    port RTSystemPort
    ActorClass(className=AC2, instancePath=/LS/main/appl/cont/opt/opt/sub2)
      port RTSystemPort
      ActorClass(className=AC3, instancePath=/LS/main/appl/cont/opt/opt/sub2/deep_sub)
        port RTSystemPort
        port p0
  port RTSystemPort0
  port RTSystemPort1
  port RTSystemPort2
```

It can be seen that the sub tree corresponding to `Optional2` was inserted right below the `ScalarOptionalActorInterface`.

After deletion of the optional actor the dumped instance tree looks exactly as in the beginning.

To illustrate the dynamic behavior of the system we can finally have a look at the generated sequence diagram \[fig:dynact1\_msc\]. During the sub system initialization three actor instances are created. Then the system is started and the `Container` actor dynamically creates an instance of `Optional2`. This is indicated by the note on the life line of `/LS/main/appl/cont`. Then `sayHello()` is sent and the answer `hello()` is received and the optional actor is destroyed again.

The same is repeated with a new optional instance of `Optional1`.

![Sequence diagram of Dynamic Actors Example 1](images/039-DynAct1-MSC.jpg)

#### Noteworthy

-   To obtain an executable the launch configuration `gen_DynAct1_sys.launch` has to be executed. In this case also the SubsystemClass `Node_nodeRef1_main` is generated as well as factory classes for the valid optional actors. If `Optional` were not `abstract` then also for this class a factory is created. However, in this class the relay port isn’t connected and a request `sayHello()` would be left without reply.

-   To generate a library the launch configuration `gen_DynAct1.launch` has to be executed. In this case no factory classes are generated.

### Dynamic Actors 2

This example is contained in `model/dynamicactors2`.

#### Purpose

A modified version of `dynamicactors1` is used to analyze eventual memory leaks of the application.

#### Details

In this modified version creation and deletion of optional actors is looped. Each loop consists of 4 steps:

1.  create an instance of `Optional2`

2.  destroy the instance

3.  create an instance of `Optional1`

4.  destroy the instance

All together 600 steps are performed which corresponds to 300 creations and deletions.

The free memory is printed to the console. Also the overall execution time is measured. After the loop is finished the heap is analyzed using `JConsole` (which is a part of the Java6 distribution) to dump the heap and [`org.eclipse.mat`](http://www.eclipse.org/mat/) to analyze it.

The measured total execution time on a Intel Core 2 Duo at 2.66 GHz was 110 ms. This corresponds to about 370 \(\mu\)s.

The result of the heap analysis for `org.eclipse.etrice.*` objects is listed in figure \[fig:dynact2\_heap\]. The small numbers per object and the retained heap size indicate that the application has no memory leak.

![Heap analysis after 600 steps](images/039-DynAct2-HeapAnalysis.jpg)

#### Noteworthy

-   Calling the garbage collector every time before the free memory is dumped costs a significant amount of time and the execution time is increased to the order of seconds.

-   The measured free memory is close to constant. Only a small step is observed which wasn’t analyzed further.

### Dynamic Actors 3

This example is contained in `model/dynamicactors3`.

#### Purpose

The example demonstrates the usage of an optional actor array. It is shown that several actor classes derived from the type of the optional actor reference can be created as array members. The array members can be destroyed in arbitrary order and the array size grows and shrinks as appropriate.

#### Details

This example again is similar to example 1. One difference is that the (scalar) optional actor is replaced by a replicated optional actor (or array of optional actors if you wish). The port of the `Container` was also changed to a replicated port. All replication factors in this example are of arbitrary multiplicity (\*). The sizes vary dynamically and are unbound as far as the model is concerned.

The behavior was changed to the following: Two instances of different classes are created as members of this array and both are deleted and one is created again. The replicated port is used to send (broadcast) messages to the optional actors.

#### Noteworthy

-   the generated MSC `main_Async.seq` is a good illustration of the dynamic changes in the system structure

-   careful inspection of the console output reveals that objects are created and destroyed as expected

### Dynamic Actors 4

This example is contained in `model/dynamicactors4`.

#### Purpose

The example demonstrates the usage of an optional actor. But here not the actor containing the optional reference is communicating with the optional actor but one level above.

#### Details

The `Controller` which has a reference to the `Container` is asking the latter for the creation of the dynamic actor. When it receives `ok()` it is requesting `sayHello()` from the newly created actor.

After the `Controller` receives `hello()` it tells the `Container` to create another actor which fails because the old one is still in place.

#### Noteworthy

-   the generated MSC `main_Async.seq` is a good illustration of the dynamic changes in the system structure

### Dynamic Actors 5

This example is contained in `model/dynamicactors5`.

#### Purpose

The example shows that the optional actor can not only have relay ports but also external end ports.

#### Details

This simple example just shows that the optional actor may directly handle inbound messages by using an external end port rather than the relay port of the previous examples.

#### Noteworthy

-   the generated MSC `main_Async.seq` is a good illustration of the dynamic changes in the system structure

### Dynamic Actors 6

This example is contained in `model/dynamicactors6`.

#### Purpose

The example demonstrates the use of nested dynamic actors.

#### Details

In this example the dynamically created actor `Optional2` has again an optional reference two levels down in its hierarchy. On creation it immediately creates a nested dynamic actor of class `Optional1` which is sending `hello()` back to the outer `Container`.

#### Noteworthy

-   the generated MSC `main_Async.seq` is a good illustration of the dynamic changes in the system structure

-   when a dynamic actor is created its structure is there immediately and all ports are connected. But the initial transition is executed asynchronously. So after the outer dynamic actor is created the port of the `Container` is not yet connected because the initial transition which is responsible for the creation of the inner dynamic actor wasn’t executed yet. So a message sent from this port directly after creation of the outer dynamic actor would get lost.

### Dynamic Actors 7

This example is contained in `model/dynamicactors7`.

#### Purpose

The example demonstrates the use of communication between two optional actors.

#### Details

In this example two sub trees of dynamic actors are created. The container is sending a message to one of them which is forwarding it to the other one which in turn is replying back to the container.

#### Noteworthy

-   the generated MSC `main_Async.seq` is a good illustration of the dynamic changes in the system structure

### Dynamic Actors 8

This example is contained in `model/dynamicactors8`.

#### Purpose

The example demonstrates the use of the persistence interface for dynamic actors.

#### Details

Dynamic actors can be persisted and restored. To this end the user has to pass an `java.io.ObjectOutput` to the creation method (`createOptionalActor()`) and an `java.io.ObjectInput` to the deletion method (`destroyOptionalActor()`).

The code generation has to be invoked with the `-persistable` (e.g. by setting the ’generate persistence interface’ flag in the Java Generator tab of the launch configuration). This lets the generator implement the `IPersistable` interface for actor classes.

The example adds a manually coded very simple `FilePersistor` with four static methods for creation and deletion of scalar and replicated dynamic actors.

The `Container` class first creates an optional actor of type `Optional1` in the scalar reference `opt`. Then messages are sent to this actor instance which lead to some state changes. Finally it is saved and destroyed. Now another actor class is instantiated in the same actor reference and also destroyed. Then the first instance is loaded from file. It directly starts in the state it had when it was saved. The second part of the example loads copies of the two instances created in the beginning into the `optarr` reference.

#### Noteworthy

-   the generated MSC `main_Async.seq` is a good illustration of the dynamic changes in the system structure

### Dynamic Actors 9

This example is contained in `model/dynamicactors9`.

#### Purpose

The example demonstrates the use of SAPs in dynamic actors.

#### Details

This simple example re-uses the PingPong tutorial. The static part of the system introduces a `TimingService` as SPP and the `Receiver` embedded in the optional part uses a SAP of this protocol.

The sub system during initialization adds broker ports to the optional actor interface that are connected to all available services.

On the other hand the factory for the optional actor maps SAPs to those broker ports.

#### Noteworthy

- *Caution:* currently the generator informs about unsatisfied services in dynamic actors. But it is still possible to create such an instance. The consequence is an unbound SAP
