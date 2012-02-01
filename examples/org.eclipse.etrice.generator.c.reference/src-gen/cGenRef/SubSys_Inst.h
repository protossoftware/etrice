/**
 * @author generated by eTrice
 *
 * Instance File of SubSystemClass SubSys
 * - instantiation of all actor instances and port instances
 * - configuration of data and connection of ports
 */

#include "etMessageService.h"

/* instantiation of message services */
#define MESSAGE_POOL_MAX 10
#define MESSAGE_BLOCK_SIZE 32
/* MessageService for Thread1 */
uint8 msgBuffer_Thread1[MESSAGE_POOL_MAX*MESSAGE_BLOCK_SIZE];
etMessageService msgService_Thread1;


/* include all used ActorClasses */
/* TODO: only include used Actor Classes for current SubSystem */
#include "SenderManual.h"
#include "ReceiverManual.h"

/* include all used ProtcolClasses */
#include "CommunicationProtocol.h"


/* declarations of all ActorClass instances (const and variable structs) */

/* forward declaration of varible actor structs */
static ReceiverManual _SubSys_Receiver;
static SenderManual _SubSys_Sender;


/* instance _SubSys_Receiver */
static const ReceiverManual_const _SubSys_Receiver_const = {
	&_SubSys_Receiver,
	/* Ports: {myActor, etReceiveMessage, msgService, peerAddress, localId} */
	{&_SubSys_Receiver, ReceiverManual_ReceiveMessage, &msgService_Thread1, 1, 123} /* Port dataIn */
	
};
static ReceiverManual _SubSys_Receiver = {&_SubSys_Receiver_const};

/* instance _SubSys_Sender */
static const SenderManual_const _SubSys_Sender_const = {
	&_SubSys_Sender,
	/* Ports: {myActor, etReceiveMessage, msgService, peerAddress, localId} */
	{&_SubSys_Sender, SenderManual_ReceiveMessage, &msgService_Thread1, 1, 123} /* Port dataOut */
	
};
static SenderManual _SubSys_Sender = {&_SubSys_Sender_const};



