/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug
 * 
 *******************************************************************************/

package org.eclipse.etrice.runtime.java.config;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class VariableService {

	private final static String POLLING_KEY = "polling_time";
	private final static int defaultPolling = 5000;
	private final boolean logging = true;

	private volatile int polling;
	private PollingThread thread;

	protected ConcurrentHashMap<String, Object> writeTasks = new ConcurrentHashMap<String, Object>();

	// ----------- generated -----------
	protected IConfigSource source;

	protected abstract void getInstances();

	protected abstract void setAttributeValues(Map<String, Object> values);

	public abstract void write(String id, Object object);

	/**
	 * called on init
	 */
	protected abstract Map<String, Object> getAttributeValues();

	public void init() {
		getInstances();
		Map<String, Object> initalValues = source.readValues();
		if (setPolling(initalValues.get(POLLING_KEY))) {
		} else if (source.getPolling() > 0)
			this.polling = source.getPolling();
		else
			this.polling = defaultPolling;
		setAttributeValues(initalValues);
		Map<String, Object> initValues = getAttributeValues();
		initValues.put(POLLING_KEY, polling);
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
					sleep(polling - ((diff > polling) ? 0 : diff));
				} catch (InterruptedException e) {
				}
			}
			write();
			source.close();
		}

		private void apply(Map<String, Object> values) {
			Object pollingValue = values.remove(POLLING_KEY);
			setPolling(pollingValue);
			if (values.isEmpty())
				return;
			setAttributeValues(values);
		}

		private void write() {
			Map<String, Object> writeMap = new HashMap<String, Object>();
			synchronized (writeTasks) {
				for (String key : writeTasks.keySet())
					writeMap.put(key, writeTasks.remove(key));
			}
			source.writeValues(writeMap);
		}
	}

	private boolean setPolling(Object value) {
		if (value != null) {
			try {
				int result = ensureInt(value);
				if (result > 0) {
					polling = result;
					return true;
				}
			} catch (IllegalArgumentException e) {
				error("polling rate", e);
			}
		}

		return false;
	}

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

	protected double[] ensuredoubleArray(Object value, int length)
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

}
