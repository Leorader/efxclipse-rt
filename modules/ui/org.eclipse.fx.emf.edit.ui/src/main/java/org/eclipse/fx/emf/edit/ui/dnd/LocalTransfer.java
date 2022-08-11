/******************************************************************************* 
 * Copyright (c) 2012 TESIS DYNAware GmbH and others. 
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0 
 * 
 * Contributors: 
 *     Torsten Sommer <torsten.sommer@tesis.de> - initial API and implementation 
 *******************************************************************************/
package org.eclipse.fx.emf.edit.ui.dnd;

import javafx.scene.input.Dragboard;

/**
 * Replacement for the {@link Dragboard} that transfers the content without serializing it.
 */
public class LocalTransfer {

	/**
	 * the one and only instance
	 */
	public static LocalTransfer INSTANCE = new LocalTransfer();

	/**
	 * The object being transfered
	 */
	private Object object;

	/**
	 * @param object the object to transfer
	 */
	public void setObject(Object object) {
		this.object = object;
	}

	/**
	 * @return the transfered object
	 */
	public Object getObject() {
		return this.object;
	}

}
