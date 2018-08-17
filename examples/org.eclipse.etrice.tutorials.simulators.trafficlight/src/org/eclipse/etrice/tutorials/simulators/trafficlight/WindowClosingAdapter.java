/*******************************************************************************
 * Copyright (c) 2012 tieto deutschland gmbh (http://www.tieto.com)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *    Thomas Jung (initial contribution)
 *******************************************************************************/ 


package org.eclipse.etrice.tutorials.simulators.trafficlight;


/* WindowClosingAdapter.java */

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WindowClosingAdapter
extends WindowAdapter
{
  private boolean exitSystem;

  /**
   * Erzeugt einen WindowClosingAdapter zum Schliessen
   * des Fensters. Ist exitSystem true, wird das komplette
   * Programm beendet.
   */
  public WindowClosingAdapter(boolean exitSystem)
  {
    this.exitSystem = exitSystem;
  }

  /**
   * Erzeugt einen WindowClosingAdapter zum Schliessen
   * des Fensters. Das Programm wird nicht beendet.
   */
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
