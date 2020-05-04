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
package org.eclipse.fx.tool.preference.spy.internal.service;

import java.util.Map;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.IPreferenceNodeVisitor;
import org.eclipse.fx.tool.preference.spy.internal.model.PreferenceEntry;
import org.eclipse.fx.tool.preference.spy.internal.model.PreferenceNodeEntry;
import org.osgi.service.prefs.BackingStoreException;

class PreferenceGatherer implements IPreferenceNodeVisitor {

	private Map<String, PreferenceNodeEntry> preferenceEntries;

	PreferenceGatherer(Map<String, PreferenceNodeEntry> preferenceEntries) {
		this.preferenceEntries = preferenceEntries;
	}

	@Override
	public boolean visit(IEclipsePreferences node) throws BackingStoreException {
		// only show nodes, which have changed keys
		String[] keys = node.keys();
		if (keys.length <= 0) {
			return true;
		}
		PreferenceNodeEntry preferenceNodeEntry = preferenceEntries.get(node.absolutePath());
		if (null == preferenceNodeEntry) {
			preferenceNodeEntry = new PreferenceNodeEntry(node.absolutePath());
			preferenceEntries.put(node.absolutePath(), preferenceNodeEntry);
		}
		for (String key : keys) {
			String value = node.get(key, "*default*");
			PreferenceEntry preferenceEntry = new PreferenceEntry(node.absolutePath(), key, value, value);
			preferenceEntry.setParentPreferences( node );
			preferenceNodeEntry.addChildren(preferenceEntry);
		}
		return true;
	}
}
