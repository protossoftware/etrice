ROOM Concepts
=============

This chapter gives an overview over the ROOM language elements and their textual and graphical notation. The formal ROOM grammar based on Xtext (EBNF) you can find in the eTrice repository:
<http://git.eclipse.org/c/etrice/org.eclipse.etrice.git/plain/plugins/org.eclipse.etrice.core.room/src/org/eclipse/etrice/core/Room.xtext>

Actors
------

### Description

The actor is the basic structural building block for building systems with ROOM. An actor can be refined hierarchically and thus can be of arbitrarily large scope. Ports define the interface of an actor. An actor can also have a behavior usually defined by a finite state machine.

### Motivation

-   Actors enable the construction of hierarchical structures by composition and layering

-   Actors have their own logical thread of execution

-   Actors can be freely deployed

-   Actors define potentially re-usable blocks
 
### Notation

<table style="vertical-align: middle;text-align: center;" class="table">
  <thead>
    <tr>
      <th><strong>Element</strong></th>
      <th><strong>Graphical Notation</strong></th>
      <th><strong>Textual Notation</strong></th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>ActorClass </td>
      <td><img src="images/040-ActorClassNotation.png" alt="image"></td>
      <td>
```room
ActorClass ActorClass2 {}
```</td>
    </tr>
	 <tr>
      <td>ActorRef</td>
      <td><img src="images/040-ActorReferenceNotation.png" alt="image"></td>
      <td>
```room
ActorClass ActorClass1 {
	Structure {
		ActorRef ActorReference: ActorClass2
	}
}
```
</td>
    </tr>
  </tbody>
</table>
 

### Details

#### Actor Classes, Actor References, Ports and Bindings

An ActorClass defines the type (or blueprint) of an actor. Hierarchies are built by ActorClasses that contain ActorReferences which have another ActorClass as type. The interface of an ActorClass is always defined by Ports. The ActorClass can also contain Attributes, Operations and a finite StateMachine. 

External Ports define the external interface of an actor and are defined in the Interface section of the ActorClass.

Internal Ports define the internal interface of an actor and are defined in the Structure section of the ActorClass.

Bindings connect Ports inside an ActorClass.

Let us have a look at example:

<table style="vertical-align: middle;text-align: center;" class="table">
  <thead>
    <tr>
      <th><strong>Graphical Notation</strong></th>
      <th><strong>Textual Notation</strong></th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>![image](images/040-ActorClass.png)</td>
      <td>
```room
ActorClass ActorClass1 {
	Interface {
		Port port1: ProtocolClass1
		Port port4: ProtocolClass1
	}
	Structure {
		external Port port1
		conjugated Port port2: ProtocolClass1
		conjugated Port port3: ProtocolClass1
		ActorRef ActorRef_A: ActorClass2
		ActorRef ActorRef_B: ActorClass3
		Binding port2 and ActorRef_A.port5
		Binding port3 and ActorRef_B.port6
		Binding ActorRef_B.port7 and port4
		Binding ActorRef_A.port8 and ActorRef_B.port9
	}
}
``` 
	  </td>
    </tr>
  </tbody>
</table>

- *ActorClass1* contains two ActorReferences (of ActorClass2 and ActorClass3) 
- *port1* is an *external end port*. Since it connects external actors with the behavior of the ActorClass, it is defined in the Interface section as well as in the Structure section of the ActorClass.
- *port2* and *port3* are *internal end ports* and can only be connected to the ports of contained ActorReferences. Internal end ports connect the behavior of an ActorClass with its contained ActorReferences.
- *port4* is a *relay port* and connects external Actors to contained ActorReferences. This port can not be accessed by the behavior of the ActorClass.
- *port5* through *port9* are ports of contained actor references. port8 and port9 can communicate without interference with the containing actor class.
- Bindings can connect ports of the actor class and its contained actor references. 

#### Attributes

Attributes are part of the Structure of an actor class.
They can be of a PrimitiveType or a DataClass.

Example:

```room
ActorClass ActorClass3 {
	Structure {
		Attribute attribute1: int32       // attribute of primitive type
		Attribute attribute2: DataClass1  // attribute of DataClass type
	}
}
```

#### Operations

Operations are part of the Behavior of an actor class. Arguments and return values can be of a PrimitiveType or a DataClass. Data classes can be passed by value (implicit) or by reference (<span class="keyword">ref</span>).

Example:

```room
ActorClass ActorClass4 {
	Behavior {
		// no arguments, no return value
		Operation operation1(): void '''
			user code
		'''
		// argument of primitive type, return value of primitive type
		Operation operation2(Param1: int32, Param2: float64): uint16 '''
			user code
		'''
		// arguments and return value by value
		Operation operation3(Param1: int32, Param2: DataClass1): DataClass1 '''
			user code
		'''
		// arguments and return value by reference except for primitive types
		Operation operation4(Param1: int32, Param2: DataClass1 ref): DataClass1 ref '''
			user code
		'''
	}
}
```

	
Protocols
---------

### Description

A ProtocolClass defines a set of incoming and outgoing Messages that can be exchanged between two ports. The exact semantics of a message is defined by the execution model.

### Motivation

-   Protocol classes provide a reusable interface specification for ports

-   Protocol classes can optionally specify valid message exchange sequences

### Notation

Protocol classes have only textual notation. The example defines a protocol class with 2 incoming and two outgoing messages. Messages can have data attached. The data can be of a primitive type (e.g. int32, float64, ...) or a data class.

```room
ProtocolClass ProtocolClass1 {
	incoming {
		Message m1(data: int32}
		Message m2()
	}
	outgoing {
		Message m3(data: DataClass1}
		Message m4()
	}
}
```
	
Ports
-----

### Description

Ports are the only interfaces of actors. A port has always a protocol assigned. Service Access Points (SAP) and Service Provision Points (SPP) are specialized ports that are used to define layering.

### Motivation

-   Ports decouple interface definition (protocols) from interface usage

-   Ports decouple the logical interface from the transport

### Notation

#### Class Ports

Ports that define an external interface of the actor class, are defined in the Interface. Ports that define an internal interface are defined in the Structure (e.g. internal ports).

-   *External end ports* are defined in the Interface and in the Structure

-   *Internal end ports* are only defined in the Structure

-   *Relay ports* are only defined in the Interface

-   *End ports* are always connected to the internal behavior of the ActorClass

-   *Replicated ports* can be defined with a fixed replication factor, e.g.
	<span>```Port port18 [5]: ProtocolClass1```</span>
    or a variable replication factor, e.g.
	<span>```Port port18[*]: ProtocolClass1```</span>

-   The graphical symbols of Interface ports are drawn on the border of the actor class. The graphical symbols of Structure ports are drawn inside the border of an actor class.

The table below shows all kinds of class ports with textual and graphical notation:

<table style="vertical-align: middle;text-align: center;" class="table">
  <thead>
    <tr>
      <th><strong>Element</strong></th>
      <th><strong>Graphical Notation</strong></th>
      <th><strong>Textual Notation</strong></th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>Class End Port </td>
      <td>![image](images/040-ClassEndPort.png) </td>
      <td>
*External Class End Port:*

```room
ActorClass ActorClass6 {
	Interface {
		Port port12: ProtocolClass1
	}
	Structure {
		external Port port12
	}
}
```
*Internal Class End Port:*

```room
ActorClass ActorClass6 {
	Interface { }
	Structure {
		Port port20
	}
}
```	  
</td>
    </tr>
	 <tr>
		<td>Conjugated Class End Port </td>
		<td>![image](images/040-ConjugatedClassEndPort.png) </td>
		<td>
*External Conjugated Class End Port:*

```room
ActorClass ActorClass6 {
	Interface {
		conjugated Port port13: ProtocolClass1
	}
	Structure {
		external Port port13
	}
}
```
*Internal Conjugated Class End Port:*

```room
ActorClass ActorClass6 {
	Interface {}
	Structure {
		conjugated Port port21: ProtocolClass1
	}
}
```
		</td>
    </tr>
	 <tr>
		<td>Class Relay Port </td>
		<td>![image](images/040-ClassRelayPort.png) </td>
		<td>
```room
ActorClass ActorClass6 {
	Interface {
		Port port10: ProtocolClass1
	}
	Structure { }
}
```
		</td>
    </tr>
	 <tr>
		<td>Conjugated Class Relay Port </td>
		<td>![image](images/040-ConjugatedClassRelayPort.png) </td>
		<td>
```room
ActorClass ActorClass6 {
	Interface {
		conjugated Port port10: ProtocolClass1
	}
	Structure {}
}
```
		</td>
    </tr>
	 <tr>
		<td>Replicated Class End Port </td>
		<td>![image](images/040-ReplicatedClassEndPort.png) </td>
		<td>
*External Replicated Class End Port:*

```room
ActorClass ActorClass6 {
	Interface {
		Port port16[3]: ProtocolClass1
	}
	Structure {
		external Port port16
	}
}
```
*Internal Replicated Class End Port:*

```room
ActorClass ActorClass6 {
	Interface {}
	Structure {
		Port port16[3]: ProtocolClass1
	}
}
```
		</td>
    </tr>
	 <tr>
		<td>Conjugated Replicated Class End Port </td>
		<td>![image](images/040-ConjugatedReplicatedClassEndPort.png) </td>
		<td>
*External Conjugated Replicated Class End Port:*

```room
ActorClass ActorClass6 {
	Interface {
		conjugated Port port17[3]: ProtocolClass1
	}
	Structure {
		external Port port17
	}
}
```
*Internal Conjugated Replicated Class End Port:*

```room
ActorClass ActorClass6 {
	Interface { }
	Structure {
		conjugated Port port23[3]: ProtocolClass1
	}
}
```
		</td>
    </tr>
	 <tr>
		<td>Replicated Class Relay Port </td>
		<td>![image](images/040-ReplicatedClassRelayPort.png) </td>
		<td>
```room
ActorClass ActorClass6 {
	Interface {
		Port port18[3]: ProtocolClass1
	}
	Structure { }
}
```
		</td>
    </tr>
	 <tr>
		<td>Conjugated Replicated Class Relay Port </td>
		<td>![image](images/040-ConjugatedReplicatedClassRelayPort.png) </td>
		<td>
```room
ActorClass ActorClass6 {
	Interface {
		conjugated Port port19[3]: ProtocolClass1
	}
	Structure { }
}
```
		</td>
    </tr>
  </tbody>
</table>


#### Reference Ports

These symbols can only appear on the border of an actor class reference. Since the type of port is defined in the respective actor class, no textual notation for the Reference Ports exists.

The table below shows all kinds of reference ports with textual and graphical notation:

|        **Element**        |                   **Graphical Notation**                   | **Textual Notation** |
|:-------------------------:|:----------------------------------------------------------:|:--------------------:|
|       Reference Port      |           ![image](images/040-ReferencePort.png)           |      *implicit*      |
| Conjugated Reference Port |      ![image](images/040-ConjugatedReferencePort.png)      |      *implicit*      |
| Replicated Reference Port |      ![image](images/040-ReplicatedReferencePort.png)      |      *implicit*      |
|   Conjugated Replicated Reference Port      | ![image](images/040-ConjugatedReplicatedReferencePort.png) |      *implicit*      |

DataClass
---------

### Description

The DataClass allows the modeling of hierarchical complex data types and operations on them. The data class is the equivalent to a class in languages like Java or C++, but has less features. The content of a data class can always be sent via message between actors (defined as message data in a ProtocolClass).

### Notation

Example: DataClass using PrimitiveTypes

```room
DataClass DataClass1 {
	Attribute attribute1: int32    // attribute of primitive type
	Attribute attribute2: float32  // attribute of another primitive type

	// no arguments, no return value
	Operation operation1(): void '''
		user code
	'''
	// argument of primitive type, no return value
	Operation operation2(Param1: int32): void '''
		user code
	'''
	// argument of primitive type, return value of primitive type
	Operation operation3(Param1: int32): float64 '''
		user code
	'''
}
```
Example: DataClass using other DataClasses:

```room
DataClass DataClass2 {
	Attribute attribute1: int32      // attribute of primitive type
	Attribute attribute2: DataClass1 // attribute of DataClass

	// arguments and return value by value
	Operation operation1(Param1: int32, Param2: DataClass1): DataClass1 '''
		user code
	'''
	// arguments and return value by reference except for primitive types
	Operation operation2(Param1: int32, Param2: DataClass1 ref): DataClass1 ref '''
		user code
	'''
}
```

Layering
--------

### Description

In addition to the actor containment hierarchies, layering provides another method to hierarchically structure a software system. Layering and actor hierarchies with port to port connections can be mixed on every level of granularity.

1.  an actor class can define a Service Provision Point (SPP) to publish a specific service, defined by a protocol class

2.  an actor class can define a Service Access Point (SAP) if it needs a service, defined by a protocol class

3.  for a given actor hierarchy, a LayerConnection defines which SAP will be satisfied by (connected to) which SPP

### Notation

For the graphical and textual notation refer to the following table:
		
<table style="vertical-align: middle;text-align: center;caption-side: bottom;" class="table">
  <thead>
    <tr>
      <th><strong>Graphical Notation</strong></th>
      <th><strong>Textual Notation</strong></th>
    </tr>
  </thead>
  <tbody>
    <tr>
		<td>![image](images/040-LayeringModel.png)</td>
		<td>
```room
ActorClass Mode1 {
	Structure {
		ActorRef Services: ServiceLayer
		ActorRef Application: ApplicationLayer
		
		LayerConnection ref Application satisfied_by Services.timer
		LayerConnection ref Application satisfied_by Services.digitalIO
	}
}
```
		</td>
	</tr>
	</tbody>
	<caption>The layer connections in this model define which services are provided by the <i>ServiceLayer</i> (<i>digitalIO</i> and <i>timer</i>)</caption>
</table>
	
<table style="vertical-align: middle;text-align: center;caption-side: bottom;" class="table">
	<tbody>
	<tr>
		<td>![image](images/040-LayeringServiceLayer.png)</td>
		<td>
```room
ActorClass ServiceLayer {
	Interface {
		SPP timer: TimerProtocol
		SPP digitalIO: DigitalIOProtocol
	}
	Structure {
		ActorRef Timer: TimerService
		ActorRef DigIO: DifitalIOService
		LayerConnection relay_sap timer satisfied_by Timer.timer
		LayerConnection relay_sap digitalIO satisfied_by DigIO.digitalIO
	}
}
```
		</td>
	</tr>
	</tbody>
	<caption>The implementation of the services (SPPs) can be delegated to sub actors. In this case the actor *ServiceLayer* relays (delegates) the implementation services <i>digitalIO<Ii> and <i>timer</i> to sub actors</caption>
</table>
<table style="vertical-align: middle;text-align: center;caption-side: bottom;" class="table">
	<tbody>
	<tr>
		<td>![image](images/040-LayeringApplicationLayer.png)</td>
		<td>
```room
ActorClass ApplicationLayer {
	Structure {
		ActorRef function1: A
		ActorRef function2: B
		ActorRef function3: C
		ActorRef function4: D
	}
}

ActorClass A {
	Structure {
		SAP timerSAP: TimerProtocol
	}
}

ActorClass B {
	Structure {
		SAP timerSAP: TimerProtocol
		SAP digitalSAP: DigitalIOProtocol
	}
}
```
		</td>
	</tr>
  </tbody>
  <caption>Every Actor inside the <i>ApplicationLayer</i> that contains an SAP with the same protocol as <i>timer</i> or <i>digitalIO</i> will be connected to the specified SPP</caption>
</table>







Finite State Machines
---------------------

### Description

Definition from [Wikipedia](http://en.wikipedia.org/wiki/Finite-state_machine "Finite-state machine"):

> A finite-state machine (FSM) or finite-state automaton (plural: automata), or simply a state machine, is a mathematical model used to design computer programs and digital logic circuits. It is conceived as an abstract machine that can be in one of a finite number of states. The machine is in only one state at a time; the state it is in at any given time is called the current state. It can change from one state to another when initiated by a triggering event or condition, this is called a transition. A particular FSM is defined by a list of the possible states it can transition to from each state, and the triggering condition for each transition.
>
> In ROOM each actor class can implement its behavior using a state machine. Events occurring at the end ports of an actor will be forwarded to and processed by the state machine. Events possibly trigger state transitions.

### Motivation

For event driven systems a finite state machine is ideal for processing the stream of events. Typically during processing new events are produced which are sent to peer actors.

We distinguish flat and hierarchical state machines.

### Notation

We distinguish flat finite state machines (with just one level of hierarchy) and hierarchical ones.
 
#### Flat Finite State Machine

The simpler flat finite state machines are composed of the elements shown following table:

<table style="vertical-align: middle;text-align: center;" class="table">
  <thead>
    <tr>
      <th><strong>Element</strong></th>
      <th><strong>Graphical Notation</strong></th>
      <th><strong>Textual Notation</strong></th>
    </tr>
  </thead>
	<tbody>
		<tr>
			<td>State</td>
			<td>![image](images/040-State.jpg)</td>
			<td>
```room
State SomeState
```
			</td>
		</tr>
		<tr>
			<td>InitialPoint</td>
			<td>![image](images/040-InitialPoint.jpg)</td>
			<td>
*implicit*
			</td>
		</tr>
		<tr>
			<td>TransitionPoint</td>
			<td>![image](images/040-TransitionPoint.jpg)</td>
			<td>
```room
TransitionPoint tp
```
			</td>
		</tr>
		<tr>
			<td>ChoicePoint</td>
			<td>![image](images/040-ChoicePoint.jpg)</td>
			<td>
```room
ChoicePoint cp
```
			</td>
		</tr>
		<tr>
			<td>Initial Transition</td>
			<td>![image](images/040-InitialTransition.jpg)</td>
			<td>

```room
Transition init: initial -> Initial { }
```
			</td>
		</tr>
		<tr>
			<td>Triggered Transition</td>
			<td>![image](images/040-TriggeredTransition.jpg)</td>
			<td>
```room
Transition tr0: initial -> DoingThis {
	triggers {
		<doThis: fct>
	}
}
```
			</td>
		</tr>
	</tbody>
</table>


#### Hierarchical Finite State Machine

The hierarchical finite state machine adds the notion of a sub state machine nested in a state. A few modeling elements listed in table below are added to the set listed above.

<table style="vertical-align: middle;text-align: center;" class="table">
  <thead>
    <tr>
      <th><strong>Element</strong></th>
      <th><strong>Graphical Notation</strong></th>
      <th><strong>Textual Notation</strong></th>
    </tr>
  </thead>
	<tbody>
		<tr>
			<td>State with sub state machine</td>
			<td>Parent State
			![image](images/040-StateWithSubFSM.jpg)</td>
			<td>
*Sub state machine*

```room
State Running {
	subgraph {
		Transition init: initial -> Process {}
		State Process
	}
}
```
			</td>
		</tr>
		<tr>
			<td>Entry Point</td>
			<td>In sub state machine
			![image](images/040-EntryPoint.jpg)</td>
			<td>
```room
EntryPoint reInit
```
			</td>
		</tr>
		<tr>
			<td>Exit Point</td>
			<td>![image](images/040-ExitPoint.jpg)</td>
			<td>
```room
ExitPoint tp0
```
			</td>
		</tr>
	</tbody>
</table>

### Examples

![Example of a flat finite state machine](images/040-FlatFSM.jpg)

![Example of a hierarchical finite state machine – top level](images/040-HierarchicalFSMTop.jpg)

![Hierarchical finite state machine – sub state machine of *Initializing*](images/040-HierarchicalFSMInitializing.jpg)

![Hierarchical finite state machine – sub state machine of *Running*](images/040-HierarchicalFSMRunning.jpg)


<!-- Abbreviations ---> 
*[SPP]: Service Provising Point
*[SAP]: Service Access Point
*[FSM]: finite-state machine

