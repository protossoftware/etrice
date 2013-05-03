/*******************************************************************************
 * Copyright (c) 2013 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 *
 *******************************************************************************/

#ifndef _ETTCPSOCKETS_H_
#define _ETTCPSOCKETS_H_

#include "etDatatypes.h"

/** the maximum number of connections per server */
#define MAX_CONNECTIONS		32

/** function prototype for receiving data from a socket */
typedef int (*etSocketReceiver)(void* self, int channel, int size, const int8* data);
/** function prototype for a function returning a writable buffer */
typedef int8* (*etBufferProvider)(void* self, int* size);

/**
 * The public part of the server data.
 * Data passed to the API methods <b>must</b> be created using
 * {@link etCreateSocketServerData()}
 */
typedef struct etSocketServerData {
	etSocketReceiver receiver;
	etBufferProvider bufferProvider;
	void* userData;
	int maxConnections;
}
etSocketServerData;

/**
 * The public part of the connection data.
 * Data passed to the API methods <b>must</b> be created using
 * {@link etCreateSocketConnectionData()}
 */
typedef struct etSocketConnectionData {
	etSocketReceiver receiver;
	etBufferProvider bufferProvider;
	void* userData;
}
etSocketConnectionData;

/** error codes for API functions */
typedef enum {
	ETSOCKET_OK,
	ETSOCKET_ERROR
}
etSocketError;


/*
 * general
 */

/**
 * to be called once before working with sockets
 */
etSocketError etInitSockets();

/**
 * to be called once after working with sockets
 */
etSocketError etCleanupSockets();

/*
 * server side
 */

/**
 * @return a struct with the server data allocated from the heap
 */
etSocketServerData* etCreateSocketServerData();

/**
 * @param data the previously allocated data to be freed
 */
void etFreeSocketServerData(etSocketServerData* data);

/**
 * starts a thread listening to a port
 * @param self the server data
 * @param port which is listened to
 * @return an error code of type {@link etSocketError}
 */
etSocketError etStartListening(etSocketServerData* self, short port);

/**
 * stops listening on the socket but leaves connections untouched
 * @param self the server data
 * @return an error code of type {@link etSocketError}
 */
etSocketError etStopSocketServer(etSocketServerData* self);

/**
 * write to an established connection of the server side
 * @param self the server data
 * @param connection the connection to which the data should be sent
 * @param size the size of the data in bytes
 * @param data the data to be sent
 * @return an error code of type {@link etSocketError}
 */
etSocketError etWriteServerSocket(etSocketServerData* self, int connection, int size, const int8* data);

/**
 * close a server connection (closes the socket and stops its thread)
 * @param self the server data
 * @param connection the connection to be stopped
 * @return an error code of type {@link etSocketError}
 */
etSocketError etCloseServerSocket(etSocketServerData* self, int connection);

/**
 * close all server connections (closes the sockets and stops their threads)
 * @param self the server data
 * @return an error code of type {@link etSocketError}
 */
etSocketError etCloseAllServerSockets(etSocketServerData* self);

/*
 * client side
 */

/**
 * @return a struct with the client data allocated from the heap
 */
etSocketConnectionData* etCreateSocketConnectionData();

/**
 * @param data the previously allocated data to be freed
 */
void etFreeSocketConnectionData(etSocketConnectionData* data);

/**
 * connect a socket server
 * @param addr the internet address given as quadrupel, if {@code NULL} then local host is assumed
 * @param port the port to which the connection should be established
 * @param self the client data
 * @return an error code of type {@link etSocketError}
 */
etSocketError etConnectServer(etSocketConnectionData* self, const char* addr, short port);

/**
 * write to an established client connection
 * @param self the client data
 * @param size the size of the data in bytes
 * @param data the data to be sent
 * @return an error code of type {@link etSocketError}
 */
etSocketError etWriteSocket(etSocketConnectionData* self, int size, const int8* data);

/**
 * close a client connection (closes the socket and stops the thread)
 * @param self the client data
 * @return an error code of type {@link etSocketError}
 */
etSocketError etCloseSocket(etSocketConnectionData* self);

#endif /* _ETTCPSOCKETS_H_ */
