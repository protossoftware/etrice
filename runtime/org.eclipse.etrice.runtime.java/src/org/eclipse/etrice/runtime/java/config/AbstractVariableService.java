/*******************************************************************************
 * Copyright (c) 2012 Juergen Haug
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug
 * 
 *******************************************************************************/

package org.eclipse.etrice.runtime.java.config;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class AbstractVariableService implements IVariableService {

	private final static String POLLINGTIMER_KEY = "polling_timer[ms]";
	private final static int defaultPollingTimer = 5000;
	private final boolean logging = true;

	private volatile int pollingTimer;
	private PollingThread thread;
	protected Map<String, Object> writeTasks;
	private Map<String, Object> diffMap;

	private IConfigSource source;

	public AbstractVariableService(IConfigSource source) {
		this.source = source;
		diffMap = new HashMap<String, Object>();
		writeTasks = new HashMap<String, Object>();
	}

	public void init() {
		initInstances();
		Map<String, Object> initalValues = source.readValues();
		if (setPolling(initalValues.get(POLLINGTIMER_KEY))) {
		} else if (getPollingTimerUser() > 0)
			this.pollingTimer = getPollingTimerUser();
		else if (source.getPollingTimer() > 0)
			this.pollingTimer = source.getPollingTimer();
		else
			this.pollingTimer = defaultPollingTimer;
		setAttributeValues(initalValues);
		Map<String, Object> initValues = getAttributeValues();
		initValues.put(POLLINGTIMER_KEY, pollingTimer);
		source.createConfig(initValues);

		start();
	}

	public synchronized void start() {
		if (thread != null)
			return;

		thread = new PollingThread();
		thread.start();
	}

	public synchronized void stop() {
		if (thread == null)
			return;

		thread.stop = true;
		thread.interrupt();
	}

	public void write(String id, Object object) {
		if (PRIMITIVE_TYPES.contains(object.getClass()))
			addWriteTask(id, object);
		else if (object.getClass().isArray()) {
			if (object instanceof boolean[])
				addWriteTask(id, toObjectArray((boolean[]) object));
			else if (object instanceof byte[])
				addWriteTask(id, toObjectArray((byte[]) object));
			else if (object instanceof short[])
				addWriteTask(id, toObjectArray((short[]) object));
			else if (object instanceof int[])
				addWriteTask(id, toObjectArray((int[]) object));
			else if (object instanceof long[])
				addWriteTask(id, toObjectArray((long[]) object));
			else if (object instanceof float[])
				addWriteTask(id, toObjectArray((float[]) object));
			else if (object instanceof double[])
				addWriteTask(id, toObjectArray((double[]) object));
			else if (object instanceof char[])
				addWriteTask(id, toObjectArray((char[]) object));
			else if (object instanceof String[])
				addWriteTask(id, object);
		} else {
			Map<String, Object> writeTasks = new HashMap<String, Object>();
			writeDataClass(id, object, writeTasks);
			addWriteTasks(writeTasks);
		}
	}

	private class PollingThread extends Thread {

		private boolean stop = false;

		@Override
		public void run() {

			int diff;
			long time;
			while (!stop) {
				Map<String, Object> values = source.readValues();
				time = System.currentTimeMillis();
				if (values != null) {
					apply(values);
				}
				write();
				diff = (int) (System.currentTimeMillis() - time);

				try {
					sleep(pollingTimer - ((diff > pollingTimer) ? 0 : diff));
				} catch (InterruptedException e) {
				}
			}
			write();
			source.close();
		}

		private void apply(Map<String, Object> values) {
			Object pollingValue = values.remove(POLLINGTIMER_KEY);
			setPolling(pollingValue);
			if (values.isEmpty())
				return;
			setAttributeValues(values);
		}

		private void write() {
			HashMap<String, Object> writeMap = new HashMap<String, Object>();
			synchronized (writeTasks) {
				writeMap.putAll(writeTasks);
				writeTasks.clear();
			}
			if (!writeMap.isEmpty())
				source.writeValues(writeMap);
		}
	}

	private boolean setPolling(Object value) {
		if (value != null) {
			try {
				int result = ensureInt(value);
				if (result > 0) {
					pollingTimer = result;
					return true;
				}
			} catch (IllegalArgumentException e) {
				error("polling rate", e);
			}
		}

		return false;
	}

	protected Map<String, Object> getDiffMap() {
		return diffMap;
	}

	protected void addWriteTask(String id, Object value) {
		synchronized (writeTasks) {
			writeTasks.put(id, value);
		}
	}

	protected void addWriteTasks(Map<String, Object> values) {
		synchronized (writeTasks) {
			writeTasks.putAll(values);
		}
	}

	protected abstract void initInstances();

	protected abstract void setAttributeValues(Map<String, Object> values);

	protected abstract int getPollingTimerUser();

	/**
	 * called on init
	 */
	protected abstract Map<String, Object> getAttributeValues();

	protected abstract void writeDataClass(String id, Object dcObject,
			Map<String, Object> writeMap);

	protected void checkMinMax(int value, Integer min, Integer max)
			throws IllegalArgumentException {
		if (min != null && value < min)
			throw new NumberFormatException("Value out of range. Value="
					+ value + " < " + min);
		if (max != null && value > max)
			throw new NumberFormatException("Value out of range. Value="
					+ value + " > " + max);
	}

	protected void checkMinMax(long value, Long min, Long max)
			throws IllegalArgumentException {
		if (min != null && value < min)
			throw new NumberFormatException("Value out of range. Value="
					+ value + " < " + min);
		if (max != null && value > max)
			throw new NumberFormatException("Value out of range. Value="
					+ value + " > " + max);
	}

	protected void checkMinMax(double value, Double min, Double max)
			throws IllegalArgumentException {
		if (min != null && value < min)
			throw new NumberFormatException("Value out of range. Value="
					+ value + " < " + min);
		if (max != null && value > max)
			throw new NumberFormatException("Value out of range. Value="
					+ value + " > " + max);
	}

	protected boolean ensureBoolean(Object value) {
		if (value instanceof Boolean)
			return (Boolean) value;

		return Boolean.parseBoolean(value.toString());
	}

	protected boolean[] ensureBooleanArray(Object value, int length)
			throws IllegalArgumentException {
		boolean[] result = null;
		if (value instanceof boolean[])
			result = (boolean[]) value;
		else if (value instanceof Boolean[]) {
			Boolean[] values = (Boolean[]) value;
			result = new boolean[values.length];
			for (int i = 0; i < values.length; i++)
				result[i] = values[i];
		} else if (value instanceof String[]) {
			String[] values = (String[]) value;
			result = new boolean[values.length];
			for (int i = 0; i < values.length; i++)
				result[i] = ensureBoolean(values[i]);
		} else
			throw new IllegalArgumentException("value of unknown type: "
					+ value.getClass());

		if (result.length == length)
			return result;
		throw new IllegalArgumentException("array length must be " + length
				+ ", but was " + result.length);
	}

	protected Boolean[] toObjectArray(boolean[] array) {
		Boolean[] objects = new Boolean[array.length];
		for (int i = 0; i < array.length; i++)
			objects[i] = array[i];

		return objects;
	}

	protected byte ensureByte(Object value) throws IllegalArgumentException {
		if (value instanceof Byte)
			return (Byte) value;

		return Byte.parseByte(value.toString());
	}

	protected byte[] ensureByteArray(Object value, int length)
			throws IllegalArgumentException {
		byte[] result = null;
		if (value instanceof byte[])
			result = (byte[]) value;
		else if (value instanceof Byte[]) {
			Byte[] values = (Byte[]) value;
			result = new byte[values.length];
			for (int i = 0; i < values.length; i++)
				result[i] = values[i];
		} else if (value instanceof String[]) {
			String[] values = (String[]) value;
			result = new byte[values.length];
			for (int i = 0; i < values.length; i++)
				result[i] = ensureByte(values[i]);
		} else
			throw new IllegalArgumentException("value of unknown type: "
					+ value.getClass());

		if (result.length == length)
			return result;
		throw new IllegalArgumentException("array length must be " + length
				+ ", but was " + result.length);
	}

	protected Byte[] toObjectArray(byte[] array) {
		Byte[] objects = new Byte[array.length];
		for (int i = 0; i < array.length; i++)
			objects[i] = array[i];

		return objects;
	}

	protected short ensureShort(Object value) throws IllegalArgumentException {
		if (value instanceof Short)
			return (Short) value;

		return Short.parseShort(value.toString());
	}

	protected short[] ensureShortArray(Object value, int length)
			throws IllegalArgumentException {
		short[] result = null;
		if (value instanceof short[])
			result = (short[]) value;
		else if (value instanceof Short[]) {
			Short[] values = (Short[]) value;
			result = new short[values.length];
			for (int i = 0; i < values.length; i++)
				result[i] = values[i];
		} else if (value instanceof String[]) {
			String[] values = (String[]) value;
			result = new short[values.length];
			for (int i = 0; i < values.length; i++)
				result[i] = ensureShort(values[i]);
		} else
			throw new IllegalArgumentException("value of unknown type: "
					+ value.getClass());

		if (result.length == length)
			return result;
		throw new IllegalArgumentException("array length must be " + length
				+ ", but was " + result.length);
	}

	protected Short[] toObjectArray(short[] array) {
		Short[] objects = new Short[array.length];
		for (int i = 0; i < array.length; i++)
			objects[i] = array[i];

		return objects;
	}

	protected int ensureInt(Object value) throws IllegalArgumentException {
		if (value instanceof Integer)
			return (Integer) value;

		return Integer.parseInt(value.toString());
	}

	protected int[] ensureIntArray(Object value, int length)
			throws IllegalArgumentException {
		int[] result = null;
		if (value instanceof int[])
			result = (int[]) value;
		else if (value instanceof Integer[]) {
			Integer[] values = (Integer[]) value;
			result = new int[values.length];
			for (int i = 0; i < values.length; i++)
				result[i] = values[i];
		} else if (value instanceof String[]) {
			String[] values = (String[]) value;
			result = new int[values.length];
			for (int i = 0; i < values.length; i++)
				result[i] = ensureInt(values[i]);
		} else
			throw new IllegalArgumentException("value of unknown type: "
					+ value.getClass());

		if (result.length == length)
			return result;
		throw new IllegalArgumentException("array length must be " + length
				+ ", but was " + result.length);
	}

	protected Integer[] toObjectArray(int[] array) {
		Integer[] objects = new Integer[array.length];
		for (int i = 0; i < array.length; i++)
			objects[i] = array[i];

		return objects;
	}

	protected long ensureLong(Object value) throws IllegalArgumentException {
		if (value instanceof Long)
			return (Long) value;

		return Long.parseLong(value.toString());
	}

	protected long[] ensureLongArray(Object value, int length)
			throws IllegalArgumentException {
		long[] result = null;
		if (value instanceof long[])
			result = (long[]) value;
		else if (value instanceof Long[]) {
			Long[] values = (Long[]) value;
			result = new long[values.length];
			for (int i = 0; i < values.length; i++)
				result[i] = values[i];
		} else if (value instanceof String[]) {
			String[] values = (String[]) value;
			result = new long[values.length];
			for (int i = 0; i < values.length; i++)
				result[i] = ensureLong(values[i]);
		} else
			throw new IllegalArgumentException("value of unknown type: "
					+ value.getClass());

		if (result.length == length)
			return result;
		throw new IllegalArgumentException("array length must be " + length
				+ ", but was " + result.length);
	}

	protected Long[] toObjectArray(long[] array) {
		Long[] objects = new Long[array.length];
		for (int i = 0; i < array.length; i++)
			objects[i] = array[i];

		return objects;
	}

	protected float ensureFloat(Object value) throws IllegalArgumentException {
		if (value instanceof Float)
			return (Float) value;

		return Float.parseFloat(value.toString());
	}

	protected float[] ensureFloatArray(Object value, int length)
			throws IllegalArgumentException {
		float[] result = null;
		if (value instanceof float[])
			result = (float[]) value;
		else if (value instanceof Float[]) {
			Float[] values = (Float[]) value;
			result = new float[values.length];
			for (int i = 0; i < values.length; i++)
				result[i] = values[i];
		} else if (value instanceof String[]) {
			String[] values = (String[]) value;
			result = new float[values.length];
			for (int i = 0; i < values.length; i++)
				result[i] = ensureFloat(values[i]);
		} else
			throw new IllegalArgumentException("value of unknown type: "
					+ value.getClass());

		if (result.length == length)
			return result;
		throw new IllegalArgumentException("array length must be " + length
				+ ", but was " + result.length);
	}

	protected Float[] toObjectArray(float[] array) {
		Float[] objects = new Float[array.length];
		for (int i = 0; i < array.length; i++)
			objects[i] = array[i];

		return objects;
	}

	protected double ensureDouble(Object value) throws IllegalArgumentException {
		if (value instanceof Double)
			return (Double) value;

		return Double.parseDouble(value.toString());
	}

	protected double[] ensureDoubleArray(Object value, int length)
			throws IllegalArgumentException {
		double[] result = null;
		if (value instanceof double[])
			result = (double[]) value;
		else if (value instanceof Double[]) {
			Double[] values = (Double[]) value;
			result = new double[values.length];
			for (int i = 0; i < values.length; i++)
				result[i] = values[i];
		} else if (value instanceof String[]) {
			String[] values = (String[]) value;
			result = new double[values.length];
			for (int i = 0; i < values.length; i++)
				result[i] = ensureDouble(values[i]);
		} else
			throw new IllegalArgumentException("value of unknown type: "
					+ value.getClass());

		if (result.length == length)
			return result;
		throw new IllegalArgumentException("array length must be " + length
				+ ", but was " + result.length);
	}

	protected Double[] toObjectArray(double[] array) {
		Double[] objects = new Double[array.length];
		for (int i = 0; i < array.length; i++)
			objects[i] = array[i];

		return objects;
	}

	protected char ensureChar(Object value) throws IllegalArgumentException {
		if (value instanceof Character)
			return (Character) value;

		if (value instanceof String) {
			String s = value.toString();
			if (s.length() == 1)
				return s.charAt(0);
		}

		throw new IllegalArgumentException();
	}

	protected char[] ensureCharArray(Object value, int length)
			throws IllegalArgumentException {
		char[] result = null;
		if (value instanceof char[])
			result = (char[]) value;
		else if (value instanceof String)
			result = ((String) value).toCharArray();
		else
			throw new IllegalArgumentException("value of unknown type: "
					+ value.getClass());

		if (result.length <= length)
			return result;
		throw new IllegalArgumentException("array length must be <=" + length
				+ ", but was " + result.length);
	}

	protected String toObjectArray(char[] array) {
		return String.valueOf(array);
	}

	protected String ensureString(Object value) throws IllegalArgumentException {
		if (value instanceof String)
			return (String) value;

		throw new IllegalArgumentException("value of unknown type: "
				+ value.getClass());
	}

	protected void error(String id, Exception e) {
		if (logging)
			System.out.println("[" + this.getClass().getSimpleName()
					+ "] ERROR: " + e.getMessage()
					+ ((id != null) ? "   (" + id + ")" : ""));
	}

	protected void warning(String id, String message) {
		if (logging)
			System.out.println("[" + this.getClass().getSimpleName()
					+ "] Warning: " + message
					+ ((id != null) ? "   (" + id + ")" : ""));
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static final Set<Class> PRIMITIVE_TYPES = new HashSet<Class>(
			Arrays.asList(Boolean.class, Character.class, String.class,
					Byte.class, Short.class, Integer.class, Long.class,
					Float.class, Double.class));

}
