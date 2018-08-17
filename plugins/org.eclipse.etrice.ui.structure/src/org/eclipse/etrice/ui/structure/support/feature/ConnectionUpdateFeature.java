/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
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

package org.eclipse.etrice.ui.structure.support.feature;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.ui.structure.support.context.ConnectionUpdateContext;
import org.eclipse.etrice.ui.structure.support.context.PositionUpdateContext;
import org.eclipse.etrice.ui.structure.support.provider.IPositionProvider;
import org.eclipse.etrice.ui.structure.support.provider.IPositionProvider.Pos;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.algorithms.styles.Point;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.FreeFormConnection;
import org.eclipse.graphiti.services.Graphiti;

public abstract class ConnectionUpdateFeature extends CommonUpdateFeature {

	public ConnectionUpdateFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	protected final IReason updateNeeded(EObject bo, IUpdateContext context) {
		if(context instanceof PositionUpdateContext || context instanceof ConnectionUpdateContext)
			return new Reason(true);
		
		return new Reason(false);
	}

	@Override
	protected boolean update(EObject bo, IUpdateContext context) {
		Connection conn = (Connection)context.getPictogramElement();
		
		if(context instanceof PositionUpdateContext){
			PositionUpdateContext pc = (PositionUpdateContext)context;
			IPositionProvider pp = pc.getPositionProvider();
			
			updateBendpoints(bo, conn, pp);
			updateText(bo, conn, pp);
		}
		
		return true;
	}

	private void updateText(EObject bo, Connection conn, IPositionProvider pp) {
		// TODO Auto-generated method stub	
	}

	private void updateBendpoints(EObject bo, Connection conn, IPositionProvider pp) {
		if(conn instanceof FreeFormConnection){
			FreeFormConnection ffc = (FreeFormConnection) conn;
			List<Pos> positions = pp.getConnectionBendpoints(bo);
			if(!positions.isEmpty()){
				Iterator<Pos> iter = positions.iterator();
				ffc.getBendpoints().clear();
				while(iter.hasNext()){
					Pos pos = iter.next();
					Point pt = Graphiti.getGaService().createPoint(pos.getX(), pos.getY());
					ffc.getBendpoints().add(pt);
				}
			}
		}
	}
}
