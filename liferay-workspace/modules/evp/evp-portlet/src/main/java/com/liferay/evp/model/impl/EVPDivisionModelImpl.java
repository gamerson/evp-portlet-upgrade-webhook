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

import com.liferay.evp.model.EVPDivision;
import com.liferay.evp.model.EVPDivisionModel;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.PortalUtil;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the EVPDivision service. Represents a row in the &quot;EVPDivision&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.evp.model.EVPDivisionModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link EVPDivisionImpl}.
 * </p>
 *
 * @author Val Nagy
 * @see EVPDivisionImpl
 * @see com.liferay.evp.model.EVPDivision
 * @see com.liferay.evp.model.EVPDivisionModel
 * @generated
 */
public class EVPDivisionModelImpl extends BaseModelImpl<EVPDivision>
	implements EVPDivisionModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a e v p division model instance should use the {@link com.liferay.evp.model.EVPDivision} interface instead.
	 */
	public static final String TABLE_NAME = "EVPDivision";
	public static final Object[][] TABLE_COLUMNS = {
			{ "evpDivisionId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "organizationId", Types.BIGINT },
			{ "parentEVPDivisionId", Types.BIGINT },
			{ "abbreviation", Types.VARCHAR },
			{ "type_", Types.INTEGER }
		};
	public static final String TABLE_SQL_CREATE = "create table EVPDivision (evpDivisionId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,organizationId LONG,parentEVPDivisionId LONG,abbreviation VARCHAR(75) null,type_ INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table EVPDivision";
	public static final String ORDER_BY_JPQL = " ORDER BY evpDivision.evpDivisionId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY EVPDivision.evpDivisionId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.evp.model.EVPDivision"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.evp.model.EVPDivision"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.evp.model.EVPDivision"),
			true);
	public static long COMPANYID_COLUMN_BITMASK = 1L;
	public static long TYPE_COLUMN_BITMASK = 2L;
	public static long EVPDIVISIONID_COLUMN_BITMASK = 4L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.liferay.evp.model.EVPDivision"));

	public EVPDivisionModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _evpDivisionId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEvpDivisionId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _evpDivisionId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return EVPDivision.class;
	}

	@Override
	public String getModelClassName() {
		return EVPDivision.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("evpDivisionId", getEvpDivisionId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("organizationId", getOrganizationId());
		attributes.put("parentEVPDivisionId", getParentEVPDivisionId());
		attributes.put("abbreviation", getAbbreviation());
		attributes.put("type", getType());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long evpDivisionId = (Long)attributes.get("evpDivisionId");

		if (evpDivisionId != null) {
			setEvpDivisionId(evpDivisionId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long organizationId = (Long)attributes.get("organizationId");

		if (organizationId != null) {
			setOrganizationId(organizationId);
		}

		Long parentEVPDivisionId = (Long)attributes.get("parentEVPDivisionId");

		if (parentEVPDivisionId != null) {
			setParentEVPDivisionId(parentEVPDivisionId);
		}

		String abbreviation = (String)attributes.get("abbreviation");

		if (abbreviation != null) {
			setAbbreviation(abbreviation);
		}

		Integer type = (Integer)attributes.get("type");

		if (type != null) {
			setType(type);
		}
	}

	@Override
	public long getEvpDivisionId() {
		return _evpDivisionId;
	}

	@Override
	public void setEvpDivisionId(long evpDivisionId) {
		_evpDivisionId = evpDivisionId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid); // FIXME: @deprecated As of Wilberforce (7.0.x), with no direct replacement // FIXME: @deprecated As of Wilberforce (7.0.x), with no direct replacement
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@Override
	public long getOrganizationId() {
		return _organizationId;
	}

	@Override
	public void setOrganizationId(long organizationId) {
		_organizationId = organizationId;
	}

	@Override
	public long getParentEVPDivisionId() {
		return _parentEVPDivisionId;
	}

	@Override
	public void setParentEVPDivisionId(long parentEVPDivisionId) {
		_parentEVPDivisionId = parentEVPDivisionId;
	}

	@Override
	public String getAbbreviation() {
		if (_abbreviation == null) {
			return StringPool.BLANK;
		}
		else {
			return _abbreviation;
		}
	}

	@Override
	public void setAbbreviation(String abbreviation) {
		_abbreviation = abbreviation;
	}

	@Override
	public int getType() {
		return _type;
	}

	@Override
	public void setType(int type) {
		_columnBitmask |= TYPE_COLUMN_BITMASK;

		if (!_setOriginalType) {
			_setOriginalType = true;

			_originalType = _type;
		}

		_type = type;
	}

	public int getOriginalType() {
		return _originalType;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			EVPDivision.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public EVPDivision toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (EVPDivision)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		EVPDivisionImpl evpDivisionImpl = new EVPDivisionImpl();

		evpDivisionImpl.setEvpDivisionId(getEvpDivisionId());
		evpDivisionImpl.setCompanyId(getCompanyId());
		evpDivisionImpl.setUserId(getUserId());
		evpDivisionImpl.setUserName(getUserName());
		evpDivisionImpl.setCreateDate(getCreateDate());
		evpDivisionImpl.setModifiedDate(getModifiedDate());
		evpDivisionImpl.setOrganizationId(getOrganizationId());
		evpDivisionImpl.setParentEVPDivisionId(getParentEVPDivisionId());
		evpDivisionImpl.setAbbreviation(getAbbreviation());
		evpDivisionImpl.setType(getType());

		evpDivisionImpl.resetOriginalValues();

		return evpDivisionImpl;
	}

	@Override
	public int compareTo(EVPDivision evpDivision) {
		long primaryKey = evpDivision.getPrimaryKey();

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
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EVPDivision)) {
			return false;
		}

		EVPDivision evpDivision = (EVPDivision)obj;

		long primaryKey = evpDivision.getPrimaryKey();

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

	@Override
	public void resetOriginalValues() {
		EVPDivisionModelImpl evpDivisionModelImpl = this;

		evpDivisionModelImpl._originalCompanyId = evpDivisionModelImpl._companyId;

		evpDivisionModelImpl._setOriginalCompanyId = false;

		evpDivisionModelImpl._originalType = evpDivisionModelImpl._type;

		evpDivisionModelImpl._setOriginalType = false;

		evpDivisionModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<EVPDivision> toCacheModel() {
		EVPDivisionCacheModel evpDivisionCacheModel = new EVPDivisionCacheModel();

		evpDivisionCacheModel.evpDivisionId = getEvpDivisionId();

		evpDivisionCacheModel.companyId = getCompanyId();

		evpDivisionCacheModel.userId = getUserId();

		evpDivisionCacheModel.userName = getUserName();

		String userName = evpDivisionCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			evpDivisionCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			evpDivisionCacheModel.createDate = createDate.getTime();
		}
		else {
			evpDivisionCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			evpDivisionCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			evpDivisionCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		evpDivisionCacheModel.organizationId = getOrganizationId();

		evpDivisionCacheModel.parentEVPDivisionId = getParentEVPDivisionId();

		evpDivisionCacheModel.abbreviation = getAbbreviation();

		String abbreviation = evpDivisionCacheModel.abbreviation;

		if ((abbreviation != null) && (abbreviation.length() == 0)) {
			evpDivisionCacheModel.abbreviation = null;
		}

		evpDivisionCacheModel.type = getType();

		return evpDivisionCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{evpDivisionId=");
		sb.append(getEvpDivisionId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", organizationId=");
		sb.append(getOrganizationId());
		sb.append(", parentEVPDivisionId=");
		sb.append(getParentEVPDivisionId());
		sb.append(", abbreviation=");
		sb.append(getAbbreviation());
		sb.append(", type=");
		sb.append(getType());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.liferay.evp.model.EVPDivision");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>evpDivisionId</column-name><column-value><![CDATA[");
		sb.append(getEvpDivisionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>organizationId</column-name><column-value><![CDATA[");
		sb.append(getOrganizationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>parentEVPDivisionId</column-name><column-value><![CDATA[");
		sb.append(getParentEVPDivisionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>abbreviation</column-name><column-value><![CDATA[");
		sb.append(getAbbreviation());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>type</column-name><column-value><![CDATA[");
		sb.append(getType());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = EVPDivision.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			EVPDivision.class
		};
	private long _evpDivisionId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _organizationId;
	private long _parentEVPDivisionId;
	private String _abbreviation;
	private int _type;
	private int _originalType;
	private boolean _setOriginalType;
	private long _columnBitmask;
	private EVPDivision _escapedModel;
}