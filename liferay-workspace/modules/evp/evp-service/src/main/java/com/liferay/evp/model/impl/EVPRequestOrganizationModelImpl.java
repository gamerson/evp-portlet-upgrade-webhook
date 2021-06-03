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

package com.liferay.evp.model.impl;

import com.liferay.evp.model.EVPRequestOrganization;
import com.liferay.evp.model.EVPRequestOrganizationModel;
import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the EVPRequestOrganization service. Represents a row in the &quot;EVPRequestOrganization&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>EVPRequestOrganizationModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link EVPRequestOrganizationImpl}.
 * </p>
 *
 * @author Val Nagy
 * @see EVPRequestOrganizationImpl
 * @generated
 */
public class EVPRequestOrganizationModelImpl
	extends BaseModelImpl<EVPRequestOrganization>
	implements EVPRequestOrganizationModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a evp request organization model instance should use the <code>EVPRequestOrganization</code> interface instead.
	 */
	public static final String TABLE_NAME = "EVPRequestOrganization";

	public static final Object[][] TABLE_COLUMNS = {
		{"evpRequestOrganizationId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"organizationId", Types.BIGINT}, {"subsidiaryGroupId", Types.BIGINT},
		{"description", Types.VARCHAR},
		{"taxIdentificationNumber", Types.VARCHAR},
		{"nonprofitType", Types.INTEGER}, {"verified", Types.BOOLEAN},
		{"shared", Types.BOOLEAN}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("evpRequestOrganizationId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("organizationId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("subsidiaryGroupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("description", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("taxIdentificationNumber", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("nonprofitType", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("verified", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("shared", Types.BOOLEAN);
	}

	public static final String TABLE_SQL_CREATE =
		"create table EVPRequestOrganization (evpRequestOrganizationId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,organizationId LONG,subsidiaryGroupId LONG,description VARCHAR(75) null,taxIdentificationNumber VARCHAR(75) null,nonprofitType INTEGER,verified BOOLEAN,shared BOOLEAN)";

	public static final String TABLE_SQL_DROP =
		"drop table EVPRequestOrganization";

	public static final String ORDER_BY_JPQL =
		" ORDER BY evpRequestOrganization.evpRequestOrganizationId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY EVPRequestOrganization.evpRequestOrganizationId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)
	 */
	@Deprecated
	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)
	 */
	@Deprecated
	public static final long EVPREQUESTORGANIZATIONID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
	}

	public EVPRequestOrganizationModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _evpRequestOrganizationId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEvpRequestOrganizationId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _evpRequestOrganizationId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return EVPRequestOrganization.class;
	}

	@Override
	public String getModelClassName() {
		return EVPRequestOrganization.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<EVPRequestOrganization, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<EVPRequestOrganization, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<EVPRequestOrganization, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((EVPRequestOrganization)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<EVPRequestOrganization, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<EVPRequestOrganization, Object>
				attributeSetterBiConsumer = attributeSetterBiConsumers.get(
					attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(EVPRequestOrganization)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<EVPRequestOrganization, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<EVPRequestOrganization, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, EVPRequestOrganization>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			EVPRequestOrganization.class.getClassLoader(),
			EVPRequestOrganization.class, ModelWrapper.class);

		try {
			Constructor<EVPRequestOrganization> constructor =
				(Constructor<EVPRequestOrganization>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException
							reflectiveOperationException) {

					throw new InternalError(reflectiveOperationException);
				}
			};
		}
		catch (NoSuchMethodException noSuchMethodException) {
			throw new InternalError(noSuchMethodException);
		}
	}

	private static final Map<String, Function<EVPRequestOrganization, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<EVPRequestOrganization, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<EVPRequestOrganization, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<EVPRequestOrganization, Object>>();
		Map<String, BiConsumer<EVPRequestOrganization, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap
					<String, BiConsumer<EVPRequestOrganization, ?>>();

		attributeGetterFunctions.put(
			"evpRequestOrganizationId",
			EVPRequestOrganization::getEvpRequestOrganizationId);
		attributeSetterBiConsumers.put(
			"evpRequestOrganizationId",
			(BiConsumer<EVPRequestOrganization, Long>)
				EVPRequestOrganization::setEvpRequestOrganizationId);
		attributeGetterFunctions.put(
			"companyId", EVPRequestOrganization::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<EVPRequestOrganization, Long>)
				EVPRequestOrganization::setCompanyId);
		attributeGetterFunctions.put(
			"userId", EVPRequestOrganization::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<EVPRequestOrganization, Long>)
				EVPRequestOrganization::setUserId);
		attributeGetterFunctions.put(
			"userName", EVPRequestOrganization::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<EVPRequestOrganization, String>)
				EVPRequestOrganization::setUserName);
		attributeGetterFunctions.put(
			"createDate", EVPRequestOrganization::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<EVPRequestOrganization, Date>)
				EVPRequestOrganization::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", EVPRequestOrganization::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<EVPRequestOrganization, Date>)
				EVPRequestOrganization::setModifiedDate);
		attributeGetterFunctions.put(
			"organizationId", EVPRequestOrganization::getOrganizationId);
		attributeSetterBiConsumers.put(
			"organizationId",
			(BiConsumer<EVPRequestOrganization, Long>)
				EVPRequestOrganization::setOrganizationId);
		attributeGetterFunctions.put(
			"subsidiaryGroupId", EVPRequestOrganization::getSubsidiaryGroupId);
		attributeSetterBiConsumers.put(
			"subsidiaryGroupId",
			(BiConsumer<EVPRequestOrganization, Long>)
				EVPRequestOrganization::setSubsidiaryGroupId);
		attributeGetterFunctions.put(
			"description", EVPRequestOrganization::getDescription);
		attributeSetterBiConsumers.put(
			"description",
			(BiConsumer<EVPRequestOrganization, String>)
				EVPRequestOrganization::setDescription);
		attributeGetterFunctions.put(
			"taxIdentificationNumber",
			EVPRequestOrganization::getTaxIdentificationNumber);
		attributeSetterBiConsumers.put(
			"taxIdentificationNumber",
			(BiConsumer<EVPRequestOrganization, String>)
				EVPRequestOrganization::setTaxIdentificationNumber);
		attributeGetterFunctions.put(
			"nonprofitType", EVPRequestOrganization::getNonprofitType);
		attributeSetterBiConsumers.put(
			"nonprofitType",
			(BiConsumer<EVPRequestOrganization, Integer>)
				EVPRequestOrganization::setNonprofitType);
		attributeGetterFunctions.put(
			"verified", EVPRequestOrganization::getVerified);
		attributeSetterBiConsumers.put(
			"verified",
			(BiConsumer<EVPRequestOrganization, Boolean>)
				EVPRequestOrganization::setVerified);
		attributeGetterFunctions.put(
			"shared", EVPRequestOrganization::getShared);
		attributeSetterBiConsumers.put(
			"shared",
			(BiConsumer<EVPRequestOrganization, Boolean>)
				EVPRequestOrganization::setShared);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public long getEvpRequestOrganizationId() {
		return _evpRequestOrganizationId;
	}

	@Override
	public void setEvpRequestOrganizationId(long evpRequestOrganizationId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_evpRequestOrganizationId = evpRequestOrganizationId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_companyId = companyId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalCompanyId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("companyId"));
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userName = userName;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_createDate = createDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_modifiedDate = modifiedDate;
	}

	@Override
	public long getOrganizationId() {
		return _organizationId;
	}

	@Override
	public void setOrganizationId(long organizationId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_organizationId = organizationId;
	}

	@Override
	public long getSubsidiaryGroupId() {
		return _subsidiaryGroupId;
	}

	@Override
	public void setSubsidiaryGroupId(long subsidiaryGroupId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_subsidiaryGroupId = subsidiaryGroupId;
	}

	@Override
	public String getDescription() {
		if (_description == null) {
			return "";
		}
		else {
			return _description;
		}
	}

	@Override
	public void setDescription(String description) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_description = description;
	}

	@Override
	public String getTaxIdentificationNumber() {
		if (_taxIdentificationNumber == null) {
			return "";
		}
		else {
			return _taxIdentificationNumber;
		}
	}

	@Override
	public void setTaxIdentificationNumber(String taxIdentificationNumber) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_taxIdentificationNumber = taxIdentificationNumber;
	}

	@Override
	public int getNonprofitType() {
		return _nonprofitType;
	}

	@Override
	public void setNonprofitType(int nonprofitType) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_nonprofitType = nonprofitType;
	}

	@Override
	public boolean getVerified() {
		return _verified;
	}

	@Override
	public boolean isVerified() {
		return _verified;
	}

	@Override
	public void setVerified(boolean verified) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_verified = verified;
	}

	@Override
	public boolean getShared() {
		return _shared;
	}

	@Override
	public boolean isShared() {
		return _shared;
	}

	@Override
	public void setShared(boolean shared) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_shared = shared;
	}

	public long getColumnBitmask() {
		if (_columnBitmask > 0) {
			return _columnBitmask;
		}

		if ((_columnOriginalValues == null) ||
			(_columnOriginalValues == Collections.EMPTY_MAP)) {

			return 0;
		}

		for (Map.Entry<String, Object> entry :
				_columnOriginalValues.entrySet()) {

			if (entry.getValue() != getColumnValue(entry.getKey())) {
				_columnBitmask |= _columnBitmasks.get(entry.getKey());
			}
		}

		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), EVPRequestOrganization.class.getName(),
			getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public EVPRequestOrganization toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, EVPRequestOrganization>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		EVPRequestOrganizationImpl evpRequestOrganizationImpl =
			new EVPRequestOrganizationImpl();

		evpRequestOrganizationImpl.setEvpRequestOrganizationId(
			getEvpRequestOrganizationId());
		evpRequestOrganizationImpl.setCompanyId(getCompanyId());
		evpRequestOrganizationImpl.setUserId(getUserId());
		evpRequestOrganizationImpl.setUserName(getUserName());
		evpRequestOrganizationImpl.setCreateDate(getCreateDate());
		evpRequestOrganizationImpl.setModifiedDate(getModifiedDate());
		evpRequestOrganizationImpl.setOrganizationId(getOrganizationId());
		evpRequestOrganizationImpl.setSubsidiaryGroupId(getSubsidiaryGroupId());
		evpRequestOrganizationImpl.setDescription(getDescription());
		evpRequestOrganizationImpl.setTaxIdentificationNumber(
			getTaxIdentificationNumber());
		evpRequestOrganizationImpl.setNonprofitType(getNonprofitType());
		evpRequestOrganizationImpl.setVerified(isVerified());
		evpRequestOrganizationImpl.setShared(isShared());

		evpRequestOrganizationImpl.resetOriginalValues();

		return evpRequestOrganizationImpl;
	}

	@Override
	public int compareTo(EVPRequestOrganization evpRequestOrganization) {
		long primaryKey = evpRequestOrganization.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EVPRequestOrganization)) {
			return false;
		}

		EVPRequestOrganization evpRequestOrganization =
			(EVPRequestOrganization)object;

		long primaryKey = evpRequestOrganization.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return true;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return true;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_setModifiedDate = false;

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<EVPRequestOrganization> toCacheModel() {
		EVPRequestOrganizationCacheModel evpRequestOrganizationCacheModel =
			new EVPRequestOrganizationCacheModel();

		evpRequestOrganizationCacheModel.evpRequestOrganizationId =
			getEvpRequestOrganizationId();

		evpRequestOrganizationCacheModel.companyId = getCompanyId();

		evpRequestOrganizationCacheModel.userId = getUserId();

		evpRequestOrganizationCacheModel.userName = getUserName();

		String userName = evpRequestOrganizationCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			evpRequestOrganizationCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			evpRequestOrganizationCacheModel.createDate = createDate.getTime();
		}
		else {
			evpRequestOrganizationCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			evpRequestOrganizationCacheModel.modifiedDate =
				modifiedDate.getTime();
		}
		else {
			evpRequestOrganizationCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		evpRequestOrganizationCacheModel.organizationId = getOrganizationId();

		evpRequestOrganizationCacheModel.subsidiaryGroupId =
			getSubsidiaryGroupId();

		evpRequestOrganizationCacheModel.description = getDescription();

		String description = evpRequestOrganizationCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			evpRequestOrganizationCacheModel.description = null;
		}

		evpRequestOrganizationCacheModel.taxIdentificationNumber =
			getTaxIdentificationNumber();

		String taxIdentificationNumber =
			evpRequestOrganizationCacheModel.taxIdentificationNumber;

		if ((taxIdentificationNumber != null) &&
			(taxIdentificationNumber.length() == 0)) {

			evpRequestOrganizationCacheModel.taxIdentificationNumber = null;
		}

		evpRequestOrganizationCacheModel.nonprofitType = getNonprofitType();

		evpRequestOrganizationCacheModel.verified = isVerified();

		evpRequestOrganizationCacheModel.shared = isShared();

		return evpRequestOrganizationCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<EVPRequestOrganization, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(4 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<EVPRequestOrganization, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<EVPRequestOrganization, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(
				attributeGetterFunction.apply((EVPRequestOrganization)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<EVPRequestOrganization, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<EVPRequestOrganization, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<EVPRequestOrganization, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(
				attributeGetterFunction.apply((EVPRequestOrganization)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, EVPRequestOrganization>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private long _evpRequestOrganizationId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _organizationId;
	private long _subsidiaryGroupId;
	private String _description;
	private String _taxIdentificationNumber;
	private int _nonprofitType;
	private boolean _verified;
	private boolean _shared;

	public <T> T getColumnValue(String columnName) {
		Function<EVPRequestOrganization, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((EVPRequestOrganization)this);
	}

	public <T> T getColumnOriginalValue(String columnName) {
		if (_columnOriginalValues == null) {
			return null;
		}

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		return (T)_columnOriginalValues.get(columnName);
	}

	private void _setColumnOriginalValues() {
		_columnOriginalValues = new HashMap<String, Object>();

		_columnOriginalValues.put(
			"evpRequestOrganizationId", _evpRequestOrganizationId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("organizationId", _organizationId);
		_columnOriginalValues.put("subsidiaryGroupId", _subsidiaryGroupId);
		_columnOriginalValues.put("description", _description);
		_columnOriginalValues.put(
			"taxIdentificationNumber", _taxIdentificationNumber);
		_columnOriginalValues.put("nonprofitType", _nonprofitType);
		_columnOriginalValues.put("verified", _verified);
		_columnOriginalValues.put("shared", _shared);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("evpRequestOrganizationId", 1L);

		columnBitmasks.put("companyId", 2L);

		columnBitmasks.put("userId", 4L);

		columnBitmasks.put("userName", 8L);

		columnBitmasks.put("createDate", 16L);

		columnBitmasks.put("modifiedDate", 32L);

		columnBitmasks.put("organizationId", 64L);

		columnBitmasks.put("subsidiaryGroupId", 128L);

		columnBitmasks.put("description", 256L);

		columnBitmasks.put("taxIdentificationNumber", 512L);

		columnBitmasks.put("nonprofitType", 1024L);

		columnBitmasks.put("verified", 2048L);

		columnBitmasks.put("shared", 4096L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private EVPRequestOrganization _escapedModel;

}