package org.eclipse.etrice.runtime.java.modelbase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * The base class for running components.
 * 
 * @author Henrik Rentz-Reichert
 *
 */
public class SubSystemRunnerBase {

	private static final String OPTION_RUN_AS_TEST = "-run_as_test";
	private static final String OPTION_HEADLESS = "-headless";
	
	private static boolean headless = false;
	protected static TestSemaphore terminateSem = new TestSemaphore(0);

	protected static void run(SubSystemClassBase main_component, String[] args) {
		
		System.out.println("***   T H E   B E G I N   ***");

		for (String arg : args) {
			if (arg.equals(OPTION_RUN_AS_TEST)) {
				System.out.println("*** running as test");
				headless = true;
			}
			else if (arg.equals(OPTION_HEADLESS)) {
				System.out.println("*** running headless");
				headless = true;
			}
		}

		if (headless)
			main_component.setTerminateSemaphore(terminateSem);
		
		main_component.init(); // lifecycle init
		main_component.start(); // lifecycle start

		// application runs until quit
		if (headless)
			waitForTerminate();
		else
			waitForQuit();
		
		// end the lifecycle
		main_component.stop(); // lifecycle stop
		main_component.destroy(); // lifecycle destroy

		System.out.println("***   T H E   E N D   ***");
	}
	
	/**
	 * blocks until the String "quit" is entered on the console
	 */
	protected static void waitForQuit() {
		// waiting for command line input
		BufferedReader bk = new BufferedReader(new InputStreamReader(System.in));
		String token = new String("");
		System.out.println("type 'quit' to exit");
		while (!token.equals("quit")) {
			try {
				token = bk.readLine();
				System.out.println("echo: " + token);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void waitForTerminate() {
		try{
			System.out.println("=== waitForTestcase: before acq. semaphore, thread "+Thread.currentThread().getName());
			terminateSem.acquire(1);
			System.out.println("=== waitForTestcase: after acq. semaphore, thread "+Thread.currentThread().getName());
		}catch(InterruptedException e){
			System.out.println("Semaphore fault !");
		}
	}

}
