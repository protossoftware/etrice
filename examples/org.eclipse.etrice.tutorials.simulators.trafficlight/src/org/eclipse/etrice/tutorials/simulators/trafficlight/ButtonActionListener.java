package org.eclipse.etrice.tutorials.simulators.trafficlight;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.OutputStream;
import java.io.IOException;

public class ButtonActionListener 
implements ActionListener {

	private OutputStream out;
	private String cmd1 = "requestGreen";
	
	public ButtonActionListener(OutputStream out){
		this.out = out;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String s = arg0.getActionCommand();
		
		if (s.equals("REQUEST")) {
			System.out.println("Taste gedrückt");
			try {
				out.write(cmd1.getBytes());
				out.flush();
			}
			catch (IOException e){
				System.out.println(e.toString());
			}
		//	out.write(cmd1.getBytes());
		}
	}
}
