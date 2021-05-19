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

package com.liferay.evp.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link EVPEmployeeLocalService}.
 *
 * @author Val Nagy
 * @see EVPEmployeeLocalService
 * @generated
 */
public class EVPEmployeeLocalServiceWrapper
	implements EVPEmployeeLocalService,
			   ServiceWrapper<EVPEmployeeLocalService> {

	public EVPEmployeeLocalServiceWrapper(
		EVPEmployeeLocalService evpEmployeeLocalService) {

		_evpEmployeeLocalService = evpEmployeeLocalService;
	}

	/**
	 * Adds the evp employee to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EVPEmployeeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param evpEmployee the evp employee
	 * @return the evp employee that was added
	 */
	@Override
	public com.liferay.evp.model.EVPEmployee addEVPEmployee(
		com.liferay.evp.model.EVPEmployee evpEmployee) {

		return _evpEmployeeLocalService.addEVPEmployee(evpEmployee);
	}

	@Override
	public com.liferay.evp.model.EVPEmployee addEVPEmployee(
			long userId, long employeeUserId, long managerUserId,
			long subsidiaryEVPDivisionId, int employmentType,
			java.util.Date hireDate)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _evpEmployeeLocalService.addEVPEmployee(
			userId, employeeUserId, managerUserId, subsidiaryEVPDivisionId,
			employmentType, hireDate);
	}

	/**
	 * Creates a new evp employee with the primary key. Does not add the evp employee to the database.
	 *
	 * @param evpEmployeeId the primary key for the new evp employee
	 * @return the new evp employee
	 */
	@Override
	public com.liferay.evp.model.EVPEmployee createEVPEmployee(
		long evpEmployeeId) {

		return _evpEmployeeLocalService.createEVPEmployee(evpEmployeeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _evpEmployeeLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the evp employee from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EVPEmployeeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param evpEmployee the evp employee
	 * @return the evp employee that was removed
	 */
	@Override
	public com.liferay.evp.model.EVPEmployee deleteEVPEmployee(
		com.liferay.evp.model.EVPEmployee evpEmployee) {

		return _evpEmployeeLocalService.deleteEVPEmployee(evpEmployee);
	}

	/**
	 * Deletes the evp employee with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EVPEmployeeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param evpEmployeeId the primary key of the evp employee
	 * @return the evp employee that was removed
	 * @throws PortalException if a evp employee with the primary key could not be found
	 */
	@Override
	public com.liferay.evp.model.EVPEmployee deleteEVPEmployee(
			long evpEmployeeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _evpEmployeeLocalService.deleteEVPEmployee(evpEmployeeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _evpEmployeeLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _evpEmployeeLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _evpEmployeeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.evp.model.impl.EVPEmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _evpEmployeeLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.evp.model.impl.EVPEmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _evpEmployeeLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _evpEmployeeLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _evpEmployeeLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.liferay.evp.model.EVPEmployee fetchEVPEmployee(
		long evpEmployeeId) {

		return _evpEmployeeLocalService.fetchEVPEmployee(evpEmployeeId);
	}

	@Override
	public com.liferay.evp.model.EVPEmployee fetchEVPEmployeeByEmployeeUserId(
			long employeeUserId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _evpEmployeeLocalService.fetchEVPEmployeeByEmployeeUserId(
			employeeUserId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _evpEmployeeLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the evp employee with the primary key.
	 *
	 * @param evpEmployeeId the primary key of the evp employee
	 * @return the evp employee
	 * @throws PortalException if a evp employee with the primary key could not be found
	 */
	@Override
	public com.liferay.evp.model.EVPEmployee getEVPEmployee(long evpEmployeeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _evpEmployeeLocalService.getEVPEmployee(evpEmployeeId);
	}

	@Override
	public com.liferay.evp.model.EVPEmployee getEVPEmployeeByEmployeeUserId(
			long employeeUserId)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _evpEmployeeLocalService.getEVPEmployeeByEmployeeUserId(
			employeeUserId);
	}

	/**
	 * Returns a range of all the evp employees.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.evp.model.impl.EVPEmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of evp employees
	 * @param end the upper bound of the range of evp employees (not inclusive)
	 * @return the range of evp employees
	 */
	@Override
	public java.util.List<com.liferay.evp.model.EVPEmployee> getEVPEmployees(
		int start, int end) {

		return _evpEmployeeLocalService.getEVPEmployees(start, end);
	}

	/**
	 * Returns the number of evp employees.
	 *
	 * @return the number of evp employees
	 */
	@Override
	public int getEVPEmployeesCount() {
		return _evpEmployeeLocalService.getEVPEmployeesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _evpEmployeeLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _evpEmployeeLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _evpEmployeeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the evp employee in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EVPEmployeeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param evpEmployee the evp employee
	 * @return the evp employee that was updated
	 */
	@Override
	public com.liferay.evp.model.EVPEmployee updateEVPEmployee(
		com.liferay.evp.model.EVPEmployee evpEmployee) {

		return _evpEmployeeLocalService.updateEVPEmployee(evpEmployee);
	}

	@Override
	public EVPEmployeeLocalService getWrappedService() {
		return _evpEmployeeLocalService;
	}

	@Override
	public void setWrappedService(
		EVPEmployeeLocalService evpEmployeeLocalService) {

		_evpEmployeeLocalService = evpEmployeeLocalService;
	}

	private EVPEmployeeLocalService _evpEmployeeLocalService;

}