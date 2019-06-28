/*******************************************************************************
 * Copyright (c) 2017 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * CONTRIBUTORS:
 * 		Jan Belle (initial contribution)
 *
 *******************************************************************************/

#ifndef _ETSOCKET_H_
#define _ETSOCKET_H_

#include "etDatatypes.h"

ET_EXTERN_C_BEGIN

/*
 * Data structure representing an etSocket
 * etSocket is used to establish a tcp connection
 * Must be initialized with etSocket_construct and cleaned up with etSocket_destruct
 */
typedef struct {
	etOSSocketData socket;
}
etSocket;

/*
 * Data structure representing an etServerSocket
 * etServerSocket can open a port that clients can connect to via tcp
 * Must be initialized with etServerSocket_construct and cleaned up with etServerSocket_destruct
 */
typedef struct {
	etOSSocketData serverSocket;
}
etServerSocket;

/*
 * Constructs a new etSocket and connects to the specified host.
 *
 * \param self pointer to etSocket
 * \param address address of the host to connect to
 * \param port port of the host
 * \return 0 on success
 */
int etSocket_construct(etSocket* self, const char* address, short port);

/*
 * Destructs the etSocket.
 *
 * \param self pointer to etSocket
 * \return 0 on success
 */
int etSocket_destruct(etSocket* self);

/*
 * Receives data from an etSocket.
 *
 * \param self pointer to etSocket
 * \param buffer buffer for received data
 * \param length max length of received data
 * \return length of received data, -1 when failed
 */
int etSocket_recv(etSocket* self, uint8* buffer, size_t length);

/*
 * Sends data over the etSocket.
 *
 * \param self pointer to etSocket
 * \param buffer buffer that holds the data to be sent
 * \param length length of the data
 * \return length of sent data, -1 when failed
 */
int etSocket_send(etSocket* self, uint8* buffer, size_t length);


/*
 * Constructs a new etServerSocket and starts to listen on the specified port.
 *
 * \param self pointer to etServerSocket
 * \param port port number
 * \return: 0 on success
 */
int etServerSocket_construct(etServerSocket* self, short port);

/*
 * Destructs an etServerSocket.
 *
 * \param self pointer to etServerSocket
 * \return 0 on success
 */
int etServerSocket_destruct(etServerSocket* self);

/*
 * Accepts a new connection.
 *
 * \param self pointer to etServerSocket
 * \param socket pointer to the etSocket for the new connection
 */
int etServerSocket_accept(etServerSocket* self, etSocket* socket);

ET_EXTERN_C_END

#endif /* _ETSOCKET_H_ */
