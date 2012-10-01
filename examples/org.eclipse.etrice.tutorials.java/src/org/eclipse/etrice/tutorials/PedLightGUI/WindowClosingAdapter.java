/*******************************************************************************
 * Copyright (c) 2011 tieto deutschland gmbh (http://www.tieto.com)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Thomas Jung
 *******************************************************************************/ 
package org.eclipse.etrice.tutorials.PedLightGUI;

import org.eclipse.etrice.tutorials.PedLightGUI.*;

/* WindowClosingAdapter.java */

import java.awt.*;
import java.awt.event.*;

/**
 * A little simple Trafficlight GUI for the etrice tutorials
 * 
 * @author Thomas Jung
 * 
**/
public class WindowClosingAdapter
extends WindowAdapter
{
  private boolean exitSystem;

  public WindowClosingAdapter(boolean exitSystem)
  {
    this.exitSystem = exitSystem;
  }

  public WindowClosingAdapter()
  {
    this(false);
  }

  public void windowClosing(WindowEvent event)
  {
    event.getWindow().setVisible(false);
    event.getWindow().dispose();
    if (exitSystem) {
      System.exit(0);
    }
  }
}
