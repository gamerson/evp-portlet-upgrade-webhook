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

package com.liferay.evp.service.impl;

import com.liferay.evp.model.EVPDivision;
import com.liferay.evp.model.EVPEmployee;
import com.liferay.evp.model.EVPRequestOrganization;
import com.liferay.evp.service.base.EVPRequestOrganizationLocalServiceBaseImpl;
import com.liferay.evp.util.EVPPortalUtil;
import com.liferay.portal.kernel.model.ListTypeConstants;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.AddressLocalServiceUtil;
import com.liferay.portal.kernel.service.OrganizationLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.WebsiteLocalServiceUtil;
import com.liferay.portal.kernel.util.StringPool;

import java.util.Date;

/**
 * @author Val Nagy
 * @author Ethan Bustad
 */
public class EVPRequestOrganizationLocalServiceImpl
	extends EVPRequestOrganizationLocalServiceBaseImpl {

	public EVPRequestOrganization addEVPRequestOrganization(
			long companyId, long userId, Date createDate,
			String organizationName, String taxIdentificationNumber,
			String street1, String city, String zip, long regionId,
			long countryId, String url)
		throws Exception {

		EVPRequestOrganization evpRequestOrganization =
			createEVPRequestOrganization(counterLocalService.increment());

		evpRequestOrganization.setCompanyId(companyId);

		User user = userPersistence.findByPrimaryKey(userId);

		evpRequestOrganization.setUserId(user.getUserId());
		evpRequestOrganization.setUserName(user.getFullName());

		evpRequestOrganization.setCreateDate(createDate);
		evpRequestOrganization.setModifiedDate(new Date());

		Organization organization =
			OrganizationLocalServiceUtil.addOrganization(
				user.getUserId(), 0, organizationName, false);

		evpRequestOrganization.setOrganizationId(
			organization.getOrganizationId());

		EVPEmployee evpEmployee = evpEmployeePersistence.findByEmployeeUserId(
			user.getUserId());

		EVPDivision subsidiaryEVPDivision =
			evpDivisionPersistence.findByPrimaryKey(
				evpEmployee.getSubsidiaryEVPDivisionId());

		Organization divisionOrganization =
			OrganizationLocalServiceUtil.getOrganization(
				subsidiaryEVPDivision.getOrganizationId());

		evpRequestOrganization.setSubsidiaryGroupId(
			divisionOrganization.getGroupId());

		evpRequestOrganization.setTaxIdentificationNumber(
			taxIdentificationNumber);

		evpRequestOrganizationPersistence.update(evpRequestOrganization);

		AddressLocalServiceUtil.addAddress(
			user.getUserId(), Organization.class.getName(),
			organization.getOrganizationId(), street1, StringPool.BLANK,
			StringPool.BLANK, city, zip, regionId, countryId,
			EVPPortalUtil.fetchAddressListTypeId(Organization.class.getName()),
			true, true, new ServiceContext());

		WebsiteLocalServiceUtil.addWebsite(
			user.getUserId(), Organization.class.getName(),
			organization.getOrganizationId(), url,
			EVPPortalUtil.getListTypeId(
				ListTypeConstants.ORGANIZATION_WEBSITE, "public"),
			true, new ServiceContext());

		return evpRequestOrganization;
	}

}