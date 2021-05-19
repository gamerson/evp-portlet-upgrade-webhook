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

package com.liferay.evp.service.base;

import com.liferay.evp.model.EVPGrantRequest;
import com.liferay.evp.service.EVPGrantRequestLocalService;
import com.liferay.evp.service.persistence.EVPDivisionPersistence;
import com.liferay.evp.service.persistence.EVPEmployeePersistence;
import com.liferay.evp.service.persistence.EVPGrantRequestPersistence;
import com.liferay.evp.service.persistence.EVPGrantTransactionPersistence;
import com.liferay.evp.service.persistence.EVPKaleoForkInstancePersistence;
import com.liferay.evp.service.persistence.EVPRequestOrganizationPersistence;
import com.liferay.evp.service.persistence.EVPServiceRequestPersistence;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the evp grant request local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.evp.service.impl.EVPGrantRequestLocalServiceImpl}.
 * </p>
 *
 * @author Val Nagy
 * @see com.liferay.evp.service.impl.EVPGrantRequestLocalServiceImpl
 * @generated
 */
public abstract class EVPGrantRequestLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, EVPGrantRequestLocalService,
			   IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>EVPGrantRequestLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.liferay.evp.service.EVPGrantRequestLocalServiceUtil</code>.
	 */

	/**
	 * Adds the evp grant request to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EVPGrantRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param evpGrantRequest the evp grant request
	 * @return the evp grant request that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public EVPGrantRequest addEVPGrantRequest(EVPGrantRequest evpGrantRequest) {
		evpGrantRequest.setNew(true);

		return evpGrantRequestPersistence.update(evpGrantRequest);
	}

	/**
	 * Creates a new evp grant request with the primary key. Does not add the evp grant request to the database.
	 *
	 * @param evpGrantRequestId the primary key for the new evp grant request
	 * @return the new evp grant request
	 */
	@Override
	@Transactional(enabled = false)
	public EVPGrantRequest createEVPGrantRequest(long evpGrantRequestId) {
		return evpGrantRequestPersistence.create(evpGrantRequestId);
	}

	/**
	 * Deletes the evp grant request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EVPGrantRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param evpGrantRequestId the primary key of the evp grant request
	 * @return the evp grant request that was removed
	 * @throws PortalException if a evp grant request with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public EVPGrantRequest deleteEVPGrantRequest(long evpGrantRequestId)
		throws PortalException {

		return evpGrantRequestPersistence.remove(evpGrantRequestId);
	}

	/**
	 * Deletes the evp grant request from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EVPGrantRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param evpGrantRequest the evp grant request
	 * @return the evp grant request that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public EVPGrantRequest deleteEVPGrantRequest(
		EVPGrantRequest evpGrantRequest) {

		return evpGrantRequestPersistence.remove(evpGrantRequest);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			EVPGrantRequest.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return evpGrantRequestPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.evp.model.impl.EVPGrantRequestModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return evpGrantRequestPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.evp.model.impl.EVPGrantRequestModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return evpGrantRequestPersistence.findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return evpGrantRequestPersistence.countWithDynamicQuery(dynamicQuery);
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
		DynamicQuery dynamicQuery, Projection projection) {

		return evpGrantRequestPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public EVPGrantRequest fetchEVPGrantRequest(long evpGrantRequestId) {
		return evpGrantRequestPersistence.fetchByPrimaryKey(evpGrantRequestId);
	}

	/**
	 * Returns the evp grant request with the primary key.
	 *
	 * @param evpGrantRequestId the primary key of the evp grant request
	 * @return the evp grant request
	 * @throws PortalException if a evp grant request with the primary key could not be found
	 */
	@Override
	public EVPGrantRequest getEVPGrantRequest(long evpGrantRequestId)
		throws PortalException {

		return evpGrantRequestPersistence.findByPrimaryKey(evpGrantRequestId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(evpGrantRequestLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(EVPGrantRequest.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("evpGrantRequestId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			evpGrantRequestLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(EVPGrantRequest.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"evpGrantRequestId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(evpGrantRequestLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(EVPGrantRequest.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("evpGrantRequestId");
	}

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return evpGrantRequestPersistence.create(
			((Long)primaryKeyObj).longValue());
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return evpGrantRequestLocalService.deleteEVPGrantRequest(
			(EVPGrantRequest)persistedModel);
	}

	public BasePersistence<EVPGrantRequest> getBasePersistence() {
		return evpGrantRequestPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return evpGrantRequestPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the evp grant requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.evp.model.impl.EVPGrantRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of evp grant requests
	 * @param end the upper bound of the range of evp grant requests (not inclusive)
	 * @return the range of evp grant requests
	 */
	@Override
	public List<EVPGrantRequest> getEVPGrantRequests(int start, int end) {
		return evpGrantRequestPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of evp grant requests.
	 *
	 * @return the number of evp grant requests
	 */
	@Override
	public int getEVPGrantRequestsCount() {
		return evpGrantRequestPersistence.countAll();
	}

	/**
	 * Updates the evp grant request in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EVPGrantRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param evpGrantRequest the evp grant request
	 * @return the evp grant request that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public EVPGrantRequest updateEVPGrantRequest(
		EVPGrantRequest evpGrantRequest) {

		return evpGrantRequestPersistence.update(evpGrantRequest);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			EVPGrantRequestLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		evpGrantRequestLocalService = (EVPGrantRequestLocalService)aopProxy;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return EVPGrantRequestLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return EVPGrantRequest.class;
	}

	protected String getModelClassName() {
		return EVPGrantRequest.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = evpGrantRequestPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	@Reference
	protected EVPDivisionPersistence evpDivisionPersistence;

	@Reference
	protected EVPEmployeePersistence evpEmployeePersistence;

	protected EVPGrantRequestLocalService evpGrantRequestLocalService;

	@Reference
	protected EVPGrantRequestPersistence evpGrantRequestPersistence;

	@Reference
	protected EVPGrantTransactionPersistence evpGrantTransactionPersistence;

	@Reference
	protected EVPKaleoForkInstancePersistence evpKaleoForkInstancePersistence;

	@Reference
	protected EVPRequestOrganizationPersistence
		evpRequestOrganizationPersistence;

	@Reference
	protected EVPServiceRequestPersistence evpServiceRequestPersistence;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

}