/*******************************************************************************
 * Copyright (c) Carl Zeiss Meditec AG
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Thomas Fahrmeyer (lauritziu_ii@yahoo.de) - initial API and implementation
*/
package org.eclipse.fx.tool.context.spy.internal.element;

/**
 * This is a refinement of the node types. Every entry type has its own identifying image icon.
 */
enum EntryTypes {

	PUBLIC_METHOD("/icons/methpub_obj.png"),

	PUBLIC_FIELD("/icons/field_public_obj.png"),

	VALUE_IN_CONTEXT("/icons/valueincontext.png"),

	INHERITED_VARIABLE("/icons/inher_co.png"),

	LOCAL_VARIABLE("/icons/letter-l-icon.png"),

	CONTEXT_FUNCTION("/icons/contextfunction.png"),

	INJECT("/icons/annotation_obj.png");

	private final String imageURL;

	private EntryTypes(String imageURL) {
		this.imageURL = imageURL;
	}

	String getImageURL() {
		return imageURL;
	}
}
