/*******************************************************************************
 * Copyright (c) 2017 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 *
 *******************************************************************************/

#include "common/containers/String.h"

namespace etRuntime {

size_t String::nallocs = 0;
size_t String::ndeallocs = 0;
size_t String::ncreated = 0;
size_t String::ndestroyed = 0;

String::String()
: _size(0)
, _data(new char[1])
{
	++nallocs;
	++ncreated;
	_data[0] = '\0';
}

String::~String(void) {
	++ndestroyed;
	if (_data) {
		delete[] _data;
		++ndeallocs;
	}
}

/*
 * added this according to
 * http://stackoverflow.com/questions/1634359/is-there-a-reverse-function-for-strstr
 */
static const char *rstrstr(const char * s1, const char * s2) {
	size_t s1len = strlen(s1);
	size_t s2len = strlen(s2);
	const char *s;

	if (s2len > s1len) {
		return NULL;
	}
	for (s = s1 + s1len - s2len; s >= s1; --s) {
		if (strncmp(s, s2, s2len) == 0) {
			return s;
		}
	}
	return NULL;
}

String& String::operator=(const char *rhs) {
	if (rhs && rhs!=this->_data) {
		size_t new_size = std::strlen(rhs) + 1;
		if (new_size > _size) {
			_size = new_size;
			if (_data) {
				delete[] _data;
				++ndeallocs;
			}
			_data = new char[new_size];
			++nallocs;
		}
		std::strcpy(this->_data, rhs);
	}
	return *this;
}

const String String::operator+=(const char* rhs) {
	if (rhs) {
		size_t new_size = this->length() + std::strlen(rhs) + 1;
		if (new_size > _size) {
			_size = new_size;
			char* new_data = new char[new_size];
			++nallocs;
			if (_data) {
				std::strcpy(new_data, _data);
				delete[] _data;
				++ndeallocs;
			}
			else {
				new_data[0] = '\0';
			}
			_data = new_data;
		}
		std::strcat(this->_data, rhs);
	}

	// Note: this function returns a const, not a const&!
	// this prohibits things like (a + b) = c
	return *this;
}

const String String::operator+=(char c) {
	size_t new_size = this->length() + 2;
	if (new_size > _size) {
		_size = new_size;
		char* new_data = new char[new_size];
		++nallocs;
		if (_data) {
			std::strcpy(new_data, _data);
			delete[] _data;
			++ndeallocs;
		}
		_data = new_data;
	}
	_data[new_size-2] = c;
	_data[new_size-1] = '\0';

	// Note: this function returns a const, not a const&!
	// this prohibits things like (a + b) = c
	return *this;
}

size_t String::find(const String& str, size_t pos) const {
	if (pos>length()) {
		return npos;
	}
	return std::strstr(_data + pos, str._data) - _data;
}

size_t String::find(const char* str, size_t pos) const {
	if (pos>length()) {
		return npos;
	}
	return std::strstr(_data + pos, str) - _data;
}

size_t String::find(char c, size_t pos) const {
	if (pos>length()) {
		return npos;
	}
	return std::strchr(_data + pos, c) - _data;
}

size_t String::rfind(const String& str) const {
	return rstrstr(_data, str._data) - _data;
}

size_t String::rfind(const char* str) const {
	return rstrstr(_data, str) - _data;
}

size_t String::rfind(char c) const {
	return std::strrchr(_data, c) - _data;
}


String String::substr(size_t pos, size_t len) const {
	if (pos > length()) {
		return String("");
	}

	String result(_data+pos);
	if (len < result.length()) {
		result._data[len] = '\0';
	}

	return result;
}

} /* namespace etRuntime */
