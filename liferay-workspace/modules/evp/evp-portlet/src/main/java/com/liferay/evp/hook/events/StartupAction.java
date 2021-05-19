/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.evp.hook.events;

import com.liferay.compat.portal.util.PortalUtil;
import com.liferay.evp.util.EVPConstants;
import com.liferay.expando.kernel.exception.NoSuchTableException;
import com.liferay.expando.kernel.model.ExpandoColumn;
import com.liferay.expando.kernel.model.ExpandoColumnConstants;
import com.liferay.expando.kernel.model.ExpandoTable;
import com.liferay.expando.kernel.service.ExpandoColumnLocalServiceUtil;
import com.liferay.expando.kernel.service.ExpandoTableLocalServiceUtil;
import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.events.SimpleAction;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.UnicodeProperties;

/**
 * @author Ethan Bustad
 */
public class StartupAction extends SimpleAction {

	@Override
	public void run(String[] ids) throws ActionException {
		try {
			initEVPOverrideStatusExpando();

			initLDAPExpando();
		}
		catch (Exception e) {
			throw new ActionException(e);
		}
	}

	protected ExpandoTable getUserExpandoTable() throws Exception {
		ExpandoTable userExpandoTable;

		long companyId = PortalUtil.getDefaultCompanyId();

		try {
			userExpandoTable = ExpandoTableLocalServiceUtil.getDefaultTable(
				companyId, User.class.getName());
		}
		catch (NoSuchTableException nste) {
			userExpandoTable = ExpandoTableLocalServiceUtil.addDefaultTable(
				companyId, User.class.getName());
		}

		return userExpandoTable;
	}

	protected void initEVPOverrideStatusExpando() throws Exception {
		ExpandoTable userExpandoTable = getUserExpandoTable();

		ExpandoColumn expandoColumn = ExpandoColumnLocalServiceUtil.getColumn(
			userExpandoTable.getTableId(),
			EVPConstants.EVP_OVERRIDE_STATUS_EXPANDO_COLUMN);

		if (expandoColumn == null) {
			expandoColumn = ExpandoColumnLocalServiceUtil.addColumn(
				userExpandoTable.getTableId(),
				EVPConstants.EVP_OVERRIDE_STATUS_EXPANDO_COLUMN,
				ExpandoColumnConstants.STRING_ARRAY,
				EVPConstants.OVERRIDE_TYPES);
		}

		UnicodeProperties properties = new UnicodeProperties();

		properties.setProperty(
			ExpandoColumnConstants.PROPERTY_DISPLAY_TYPE,
			ExpandoColumnConstants.PROPERTY_DISPLAY_TYPE_SELECTION_LIST);

		ExpandoColumnLocalServiceUtil.updateTypeSettings(
			expandoColumn.getColumnId(), properties.toString());
	}

	protected void initLDAPExpando() throws Exception {
		ExpandoTable userExpandoTable = getUserExpandoTable();

		ExpandoColumn expandoColumn = ExpandoColumnLocalServiceUtil.getColumn(
			userExpandoTable.getTableId(), "ldapCreateTimestamp");

		if (expandoColumn == null) {
			ExpandoColumnLocalServiceUtil.addColumn(
				userExpandoTable.getTableId(), "ldapCreateTimestamp",
				ExpandoColumnConstants.STRING);
		}
	}

}