#include "osal/etSocket.h"

#include <winsock2.h>

int initializeWinsock(void);
int cleanupWinsock(void);
void printLastError(void);

int etSocket_construct(etSocket* self, const char* address, short port) {
	int result = initializeWinsock();
	if (result != 0) {
		return result;
	}

	self->socket = socket(AF_INET, SOCK_STREAM, 0);
	if(self->socket == INVALID_SOCKET)
	{
		printf("Error: could not create socket\n");
		return WSAGetLastError();
	}
	// printf("Socket created\n");

	// TODO JB: Improve address resolution
	SOCKADDR_IN addr;
	memset(&addr, 0, sizeof(SOCKADDR_IN));
	addr.sin_family = AF_INET;
	addr.sin_port = htons(port);
	addr.sin_addr.s_addr = inet_addr(address);

	if(connect(self->socket, (SOCKADDR*) &addr, sizeof(SOCKADDR)) == SOCKET_ERROR)
	{
		printf("Error: socket could not connect\n");
		printLastError();
		return WSAGetLastError();
	}
	printf("Socket connected\n");

	return 0;
}

int etSocket_destruct(etSocket* self) {
	if(closesocket(self->socket) == SOCKET_ERROR) {
		printf("Error: could not close socket\n");
		printLastError();
		return WSAGetLastError();
	}

	return cleanupWinsock();
}

int etSocket_recv(etSocket* self, uint8* buffer, size_t length) {
	int result = recv(self->socket, (char*) buffer, length, 0);
	if(result < 0) {
		printf("Error: socket could not receive data\n");
		printLastError();
	}
	return result;
}

int etSocket_send(etSocket* self, uint8* buffer, size_t length) {
	int result = send(self->socket, (const char*) buffer, length, 0);
	if(result < 0) {
		printf("Error: socket could not send data\n");
		printLastError();
	}
	return result;
}


int etServerSocket_construct(etServerSocket* self, short port) {
	int result = initializeWinsock();
	if (result != 0) {
		return result;
	}

	self->serverSocket = socket(AF_INET, SOCK_STREAM, 0);
	if(self->serverSocket == INVALID_SOCKET)
	{
		printf("Error: could not create server socket\n");
		printLastError();
		return WSAGetLastError();
	}
	// printf("Server socket created\n");

	SOCKADDR_IN addr;
	memset(&addr, 0, sizeof(SOCKADDR_IN));
	addr.sin_family = AF_INET;
	addr.sin_port = htons(port);
	addr.sin_addr.s_addr = ADDR_ANY;
	if(bind(self->serverSocket, (SOCKADDR*) &addr, sizeof(SOCKADDR_IN)) == SOCKET_ERROR)
	{
		printf("Error: Could not bind server socket\n");
		printLastError();
		return WSAGetLastError();
	}
	// printf("Server socket bound\n");

	if(listen(self->serverSocket, 10) == SOCKET_ERROR)
	{
		printf("Error: server socket could not listen\n");
		printLastError();
		return WSAGetLastError();
	}
	// printf("Server socket listening\n");

	return 0;
}

int etServerSocket_destruct(etServerSocket* self) {
	if(closesocket(self->serverSocket) == SOCKET_ERROR) {
		printf("Error: could not close server socket\n");
		printLastError();
		return WSAGetLastError();
	}

	return cleanupWinsock();
}

int etServerSocket_accept(etServerSocket* self, etSocket* socket) {
	int result = initializeWinsock();	// Initialize Winsock for new accepted socket
	if (result != 0) {
		return result;
	}

	socket->socket = accept(self->serverSocket, NULL, NULL);
	if(socket->socket == INVALID_SOCKET)
	{
		printf("Error: server socket accept failed\n");
		printLastError();
		return WSAGetLastError();
	}
	printf("Server socket accepted new connection\n");

	return 0;
}

int initializeWinsock() {
	WSADATA wsaData;
	int result = WSAStartup(MAKEWORD(2, 2), &wsaData);
	if (result != 0) {
		printf("Error: WSAStartup failed\n");
		printLastError();
		return result;
	}
	// printf("Initialized Winsock\n");
	return result;
}

int cleanupWinsock() {
	if(WSACleanup() == SOCKET_ERROR) {
		printf("Error: clean up winsock failed\n");
		printLastError();
		return WSAGetLastError();
	}
	// printf("Cleaned up winsock\n");
	return 0;
}

void printLastError() {
	wchar_t *s = NULL;
	FormatMessageW(FORMAT_MESSAGE_ALLOCATE_BUFFER | FORMAT_MESSAGE_FROM_SYSTEM | FORMAT_MESSAGE_IGNORE_INSERTS,
	               NULL, WSAGetLastError(),
	               MAKELANGID(LANG_NEUTRAL, SUBLANG_DEFAULT),
	               (LPWSTR)&s, 0, NULL);
	wprintf(L"%S\n", s);
	LocalFree(s);
}
