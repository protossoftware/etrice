/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/


package org.eclipse.etrice.runtime.java.messaging;

/**
 * A simple message queue implementing a linked list.
 * This queue is not thread safe.
 * 
 * @author Thomas Schuetz
 *
 */
public class MessageSeQueue extends RTObject{

	private Message first = null;
	private Message last = null;
	private long highWaterMark = 0;
	private long size = 0;
	
	public MessageSeQueue(IRTObject parent, String name) {
		super(parent, name);
	}

	public void push(Message msg){
		// TODO: optimize queue for concurrent push / pop
		if (first == null) {
			first = last = msg;
		}
		else {
			last.setNext(msg);
			last = msg;
		}
		if (++size > highWaterMark)
			highWaterMark++;
		
	}
	
	public Message pop(){
		// TODO: optimize queue for concurrent push / pop
		Message pop_msg = first;
		if(first == null){
			return first; 
		}
		if (first.getNext()==null){
			first = last = null;
		}
		else {
			first = first.getNext();
		}
		
		pop_msg.setNext(null);
		size--;

		return pop_msg;
	}
	
	public long getSize() {
		return size;
	}

	public Message getFirst(){
		return first;
	}

	public Message getLast(){
		return last;
	}
	
	public boolean isNotEmpty(){
		return last != null;
	}

	public long getHightWaterMark() {
		return highWaterMark;
	}
	
}
