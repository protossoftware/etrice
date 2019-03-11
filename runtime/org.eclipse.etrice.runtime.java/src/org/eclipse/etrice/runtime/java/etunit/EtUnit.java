/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.runtime.java.etunit;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

import org.eclipse.etrice.runtime.java.messaging.RTServices;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class EtUnit {
	
	private static class OrderInfo {
		short[] list;
		int current = 0;
		
		public OrderInfo(short[] list) {
			this.list = list;
		}
	}
	
	private static BufferedWriter out = null;
	private static long etUnit_startTime;
	private static long etUnit_lastTestCaseTime;
	private static int etUnit_nextCaseId = 1;
	private static HashSet<Integer> failed = new HashSet<Integer>();
	private static HashMap<Integer, OrderInfo> orderInfo = new HashMap<Integer, OrderInfo>();
	
	/* open / close */
	public static void etUnit_open(String testResultPath, String testFileName) {
		System.out.println("************* TEST START ("+testFileName+") **************");
		
		String path = testResultPath!=null? testResultPath+"/"+testFileName : testFileName;
		path += ".etu";
		
		try {
			FileWriter fstream = new FileWriter(path);
			
			if (out!=null)
				out.close();
			
			out = new BufferedWriter(fstream);
			out.write("etUnit report\n");
			out.flush();
		}
		catch (IOException e) {
			System.err.println("unable to open "+path);
			e.printStackTrace();
		}
		
		etUnit_startTime = System.currentTimeMillis();
		
		System.out.println("Start time: "+etUnit_startTime);
	}
	
	public static void etUnit_close() {
	    try {
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
	    out = null;
	    
		System.out.println("End time: "+System.currentTimeMillis());
		System.out.println("************* TEST END **************");
	}
	
	public static void etUnit_openTestSuite(String testSuiteName) {
		if (out!=null) {
			try {
				out.write("ts start: "+testSuiteName+"\n");
				out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void etUnit_closeTestSuite() {
	}
	
	public static int etUnit_openTestCase(String testCaseName) {
		int caseId = etUnit_nextCaseId++;

		if (out!=null) {
			try {
				out.write("tc start "+caseId+": "+testCaseName+"\n");
				out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
			etUnit_lastTestCaseTime = System.currentTimeMillis();
		}

		return caseId;
	}
	
	public static void etUnit_closeTestCase(int id) {
		OrderInfo info = orderInfo.get(id);
		if (info!=null) {
			if (info.current != info.list.length) {
				etUnit_handleExpect(id, false, "EXPECT_ORDER was not completed", null, null);
			}
		}
		
		if (out!=null) {
			long time = System.currentTimeMillis() - etUnit_lastTestCaseTime;
			try {
				out.write("tc end "+id+": "+time+"\n");
				out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void etUnit_skipTestCase(int id, String msg) {
		if (out!=null) {
			try {
				out.write("tc skip "+id+": "+msg+"\n");
				out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static int etUnit_openAll(String testResultPath, String testFileName, String testSuiteName, String testCaseName){
		etUnit_open(testResultPath, testFileName);
		etUnit_openTestSuite(testSuiteName);
		return etUnit_openTestCase(testCaseName);
	}
	
	public static void etUnit_closeAll(int id){
		etUnit_closeTestCase(id);
		etUnit_closeTestSuite();
		etUnit_close();
	}
	
	/* boolean values */
	public static void EXPECT_TRUE(int id, String msg, boolean condition) {
		if (condition == false) {
			String testresult = String.format("%s: *** EXPECT_TRUE == FALSE", msg);
			etUnit_handleExpect(id, false, testresult, "TRUE", "FALSE");
		} else {
			etUnit_handleExpect(id, true, "", null, null);
		}
	}
	
	public static void EXPECT_FALSE(int id, String msg, boolean condition) {
		if (condition == true) {
			String testresult = String.format("%s: *** EXPECT_TRUE == FALSE", msg);
			etUnit_handleExpect(id, false, testresult, "TRUE", "FALSE");
		} else {
			etUnit_handleExpect(id, true, "", null, null);
		}
	}

	/* signed integer values */
	public static void EXPECT_EQUAL_INT8(int id, String msg, byte expected, byte actual) {
		if (expected != actual) {
			int exp = expected;
			int act = actual;
			String testresult = String.format("%s: expected=%d, actual=%d", msg, exp, act);
			etUnit_handleExpect(id, false, testresult, new Integer(expected).toString(), new Integer(actual).toString());
		} else {
			etUnit_handleExpect(id, true, "", null, null);
		}
	}
	
	public static void EXPECT_EQUAL_INT16(int id, String msg, short expected, short actual) {
		if (expected != actual) {
			int exp = expected;
			int act = actual;
			String testresult = String.format("%s: expected=%d, actual=%d", msg, exp, act);
			etUnit_handleExpect(id, false, testresult, new Integer(expected).toString(), new Integer(actual).toString());
		} else {
			etUnit_handleExpect(id, true, "", null, null);
		}
	}
	
	public static void EXPECT_EQUAL_INT32(int id, String msg, int expected, int actual) {
		if (expected != actual) {
			int exp = expected;
			int act = actual;
			String testresult = String.format("%s: expected=%d, actual=%d", msg, exp, act);
			etUnit_handleExpect(id, false, testresult, new Integer(expected).toString(), new Integer(actual).toString());
		} else {
			etUnit_handleExpect(id, true, "", null, null);
		}
	}

	/* unsigned integer values */
	public static void EXPECT_EQUAL_UINT8(int id, String msg, char expected, char actual) {
		if (expected != actual) {
			int exp = expected;
			int act = actual;
			String testresult = String.format("%s: expected=%d, actual=%d", msg, exp, act);
			etUnit_handleExpect(id, false, testresult, new Integer(expected).toString(), new Integer(actual).toString());
		} else {
			etUnit_handleExpect(id, true, "", null, null);
		}
	}
	public static void EXPECT_EQUAL_UINT16(int id, String msg, short expected, short actual) {
		if (expected != actual) {
			int exp = expected;
			int act = actual;
			String testresult = String.format("%s: expected=%d, actual=%d", msg, exp, act);
			etUnit_handleExpect(id, false, testresult, new Integer(expected).toString(), new Integer(actual).toString());
		} else {
			etUnit_handleExpect(id, true, "", null, null);
		}
	}
	public static void EXPECT_EQUAL_UINT32(int id, String msg, int expected, int actual) {
		if (expected != actual) {
			int exp = expected;
			int act = actual;
			String testresult = String.format("%s: expected=%d, actual=%d", msg, exp, act);
			etUnit_handleExpect(id, false, testresult, new Integer(expected).toString(), new Integer(actual).toString());
		} else {
			etUnit_handleExpect(id, true, "", null, null);
		}
	}

	/* float values */
	public static void EXPECT_EQUAL_FLOAT32(int id, String msg, float expected, float actual, float precision) {
		if (expected - actual < -precision || expected - actual > precision) {
			String testresult = String.format("%s: expected=%f, actual=%f", msg, expected, actual);
			etUnit_handleExpect(id, false, testresult, new Float(expected).toString(), new Float(actual).toString());
		} else {
			etUnit_handleExpect(id, true, "", null, null);
		}
	}

	/* Pointers */
	public static void EXPECT_EQUAL_PTR(int id, String msg, Object expected, Object actual) {
		if (expected != actual) {
			String testresult = msg+": expected="+expected+", actual="+actual;
			etUnit_handleExpect(id, false, testresult, expected.toString(), actual.toString());
		} else {
			etUnit_handleExpect(id, true, "", null, null);
		}
	}

	/* more specialized functions */
	public static void EXPECT_ORDER_START(int id, short[] list, int size) {
		OrderInfo info = new OrderInfo(list);
		orderInfo.put(id, info);
	}
	public static void EXPECT_ORDER(int id, String msg, int val) {
		OrderInfo info = orderInfo.get(id);
		if (info!=null) {
			if (info.current < info.list.length) {
				if (info.list[info.current] != val){
					String testresult = String.format("EXPECT_ORDER %s: index=%d, expected=%d, actual=%d", msg, info.current, val, info.list[info.current]);
					Integer exp = val;
					Integer act = (int) info.list[info.current];
					etUnit_handleExpect(id, false, testresult, exp.toString(), act.toString());
				}
				else {
					etUnit_handleExpect(id, true, "", null, null);
					info.current++;
				}
			}
			else {
				String testresult = String.format("EXPECT_ORDER: index(%d) is too big in %s", info.current, msg);
				etUnit_handleExpect(id, false, testresult, null, null);
				System.out.println("EXPECT_ORDER: index too big in "+msg);
			}
		}
	}
	public static void EXPECT_ORDER_END(int id, String msg, int val) {
		EXPECT_ORDER(id, msg, val);

		OrderInfo info = orderInfo.get(id);
		if (info!=null) {
			if (info.current != info.list.length) {
				String testresult = String.format("EXPECT_ORDER %s: wrong index at end: expected=%d, actual=%d", msg, info.list.length, info.current);
				Integer exp = info.list.length;
				Integer act = info.current;
				etUnit_handleExpect(id, false, testresult, exp.toString(), act.toString());
			}
		}
	}

	public static boolean etUnit_isSuccess(int id) {
		return !failed.contains(id);
	}
	
	public static void etUnit_testFinished(int id) {
		RTServices.getInstance().getSubSystem().terminate(etUnit_isSuccess(id)?0:1);
	}
	
	private static void etUnit_handleExpect(int id, boolean result, String resulttext, String exp, String act) {
		if (result) {
			/* nothing to do because no failure */
		}
		else {
			if (!failed.contains(id)) {
				/* first failure will be remembered */
				failed.add(id);
				
	            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
				String fullClassName = stackTraceElement.getClassName();            
	            //String className = fullClassName.substring(fullClassName.lastIndexOf(".") + 1);
	            //String methodName = stackTraceElement.getMethodName();
	            int line = stackTraceElement.getLineNumber();
	
				try {
					if (act!=null && exp!=null){
						out.write("tc fail "+id+": #"+exp+"#"+act+"#"+fullClassName+":"+line+"#"+resulttext+"\n");
						out.flush();}
					else{
						out.write("tc fail "+id+": ###"+fullClassName+":"+line+"#"+resulttext+"\n");
						out.flush();}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			else{
				/* more than one error will be ignored */
			}
		}
	}

}
