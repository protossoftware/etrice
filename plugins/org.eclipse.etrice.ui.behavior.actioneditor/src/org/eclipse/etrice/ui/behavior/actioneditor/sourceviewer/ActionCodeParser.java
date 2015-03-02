/*******************************************************************************
 * Copyright (c) 2014 Jayant Gupta
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * CONTRIBUTORS:
 * 		Jayant Gupta (initial contribution)
 *
 *
 *******************************************************************************/

package org.eclipse.etrice.ui.behavior.actioneditor.sourceviewer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.CommunicationType;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.core.room.Operation;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.core.room.PortClass;
import org.eclipse.etrice.core.room.PortOperation;
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.eclipse.etrice.ui.behavior.support.SupportUtil;

/**
 * A parser for action code of an actor class. Internally constructs a
 * collection of all member objects and a collection for all available and
 * {@code InterfaceItems} mapped to the possible messages or operations.
 * 
 * @author jayant
 */
public class ActionCodeParser {

	/** the actor class */
	private ActorClass ac;
	/** use receive only messages */
	private boolean recvOnly;
	/** map for interface items and associated messages or operations */
	private HashMap<InterfaceItem, List<MethodItemPair>> item2pairs;
	public ActionCodeParser(ActorClass ac, boolean recvOnly) {
		this.ac = ac;
		this.recvOnly = recvOnly;
	}

	/**
	 * Class for representing a pair of Interface Item and an associated method.
	 * 
	 * @author jayant
	 */
	public static class MethodItemPair {
		InterfaceItem item;

		public MethodItemPair(InterfaceItem item) {
			super();
			this.item = item;
		}
	}

	/**
	 * Class for representing a pair of Interface Item and an associated
	 * message.
	 * 
	 * @author jayant
	 */
	public static class MsgItemPair extends MethodItemPair {
		Message msg;
		boolean out;

		public MsgItemPair(InterfaceItem item, Message msg, boolean out) {
			super(item);
			this.msg = msg;
			this.out = out;
		}
	}

	/**
	 * Class for representing a pair of Interface Item and an associated
	 * operation.
	 * 
	 * @author jayant
	 */
	public static class OperationItemPair extends MethodItemPair {
		PortOperation op;

		public OperationItemPair(InterfaceItem item, PortOperation op) {
			super(item);
			this.op = op;
		}
	}

	/**
	 * Constructs the map of Interface Items and the list of associated methods
	 * in the associated actor class.
	 * 
	 * @return a HashMap of {@link InterfaceItem}s mapped to an List of
	 *         {@link MethodItemPair}
	 */
	public HashMap<InterfaceItem, List<MethodItemPair>> getInterfaceItemMethodMap() {

		if (item2pairs == null) {
			item2pairs = new HashMap<InterfaceItem, List<MethodItemPair>>();

			RoomHelpers roomHelpers = SupportUtil.getInstance()
					.getRoomHelpers();
			List<InterfaceItem> items = roomHelpers.getAllInterfaceItems(ac);
			for (InterfaceItem item : items) {
				ArrayList<MethodItemPair> pairs = new ArrayList<MethodItemPair>();
				List<Message> out = roomHelpers.getMessageListDeep(item, true);
				if (!recvOnly) {
					for (Message msg : out) {
						if (!msg.isPriv())
							pairs.add(new MsgItemPair(item, msg, true));
					}
				}
				if (roomHelpers.getProtocol(item).getCommType() == CommunicationType.DATA_DRIVEN) {
					List<Message> in = roomHelpers.getMessageListDeep(item,
							false);
					for (Message msg : in) {
						if (!msg.isPriv())
							pairs.add(new MsgItemPair(item, msg, false));
					}
				}
				PortClass pcls = roomHelpers.getPortClass(item);
				if (pcls != null) {
					for (PortOperation op : pcls.getOperations()) {
						if (op.getSendsMsg() != null)
							pairs.add(new OperationItemPair(item, op));
					}
					for (PortOperation op : pcls.getOperations()) {
						if (op.getSendsMsg() == null)
							pairs.add(new OperationItemPair(item, op));
					}
				}
				item2pairs.put(item, pairs);
			}
		}
		return item2pairs;
	}

	/**
	 * Gets the list of the names of all {@link InterfaceItem} in the associated
	 * actor class.
	 * 
	 * @return list of names of all Interface Items.
	 */
	public List<String> getAllInterfaceItemNames() {
		List<String> interfaceItemList = new ArrayList<String>();
		for (InterfaceItem interfaceItem : getInterfaceItemMethodMap().keySet()) {
			interfaceItemList.add(interfaceItem.getName());
		}
		return interfaceItemList;
	}

	/**
	 * Gets the list of the names of all {@link InterfaceItem} in the associated
	 * actor class with index, i.e. the name includes an [index] bracket if an
	 * interface item is a {@link Port} and has a multiplicity greater than 1.
	 * 
	 * @return list of names of all Interface Items along with index, if
	 *         required
	 */
	public List<String> getAllInterfaceItemNamesWithIndex() {
		List<String> interfaceItemList = new ArrayList<String>();
		for (InterfaceItem interfaceItem : getInterfaceItemMethodMap().keySet()) {
			String index = "";
			if (interfaceItem instanceof Port
					&& ((Port) interfaceItem).getMultiplicity() != 1)
				index = "[idx]";
			interfaceItemList.add(interfaceItem.getName() + index);
		}
		return interfaceItemList;
	}

	/**
	 * Gets a list of the name of all attributes in the associated actor class.
	 * 
	 * @return list of attribute names
	 */
	public List<String> getAllAttributeNames() {
		RoomHelpers roomHelpers = SupportUtil.getInstance().getRoomHelpers();
		List<String> result = new ArrayList<String>();
		for (Attribute att : roomHelpers.getAllAttributes(ac)) {
			result.add(att.getName());
		}
		return result;
	}
	
	/**
	 * returns a list of all (including inherited) operation names including signature
	 * 
	 * @return list of all operation names (including signature)
	 */
	public List<String> getAllOperationNames() {
		RoomHelpers roomHelpers = SupportUtil.getInstance().getRoomHelpers();
		List<String> result = new ArrayList<String>();
		for (Operation op : roomHelpers.getAllOperations(ac)) {
			result.add(op.getName()
					+ SupportUtil.getInstance().getRoomNameProvider()
					.getTypedArgumentList(op));
		}
		
		return result;
	}

	/**
	 * Find the interface item with the given name.
	 * 
	 * @param itemName
	 *            the name of the interface item
	 * @return the {@link InterfaceItem} object with the given name. Returns
	 *         {@code null} if no such Interface Item.
	 */
	public InterfaceItem getInterfaceItemfromName(String itemName) {
		for (InterfaceItem interfaceItem : item2pairs.keySet()) {
			if (interfaceItem.getName().equals(itemName))
				return interfaceItem;
		}
		return null;
	}

	/**
	 * Gets the list of method names(messages & operations) along with the
	 * arguments(data) for the given {@link InterfaceItem}.
	 * 
	 * @param interfaceItem
	 *            the interface item
	 * @return the list of methods
	 */
	public List<String> getInterfaceItemMethods(InterfaceItem interfaceItem) {
		List<String> methodList = new ArrayList<String>();
		for (MethodItemPair method : item2pairs.get(interfaceItem)) {
			if (method != null) {
				String methodString = null;
				if (method instanceof MsgItemPair) {
					MsgItemPair pair = (MsgItemPair) method;
					if (pair.out) {
						String data = pair.msg.getData() != null ? pair.msg
								.getData().getName() : "";
						methodString = pair.msg.getName() + "(" + data + ")";
					} else
						methodString = pair.msg.getName();
				} else if (method instanceof OperationItemPair) {
					OperationItemPair pair = (OperationItemPair) method;
					String arglist = SupportUtil.getInstance()
							.getRoomNameProvider().getArguments(pair.op);
					methodString = pair.op.getName() + arglist;
				}
				if (methodString != null)
					methodList.add(methodString);
			}
		}
		return methodList;
	}

	/**
	 * Gets the list of method names(messages & operations) along with the
	 * arguments(data) for the given {@link InterfaceItem} name. Returns an
	 * empty list if no interface item with given name.
	 * 
	 * @param interfaceItem
	 *            the interface item name
	 * @return the list of methods
	 */
	public List<String> getInterfaceItemMethods(String interfaceItemName) {
		return getInterfaceItemMethods(getInterfaceItemfromName(interfaceItemName));
	}
}