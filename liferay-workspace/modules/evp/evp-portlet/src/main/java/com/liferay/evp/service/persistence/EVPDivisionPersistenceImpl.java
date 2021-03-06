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

package com.liferay.evp.service.persistence;

import com.liferay.evp.NoSuchDivisionException;
import com.liferay.evp.model.EVPDivision;
import com.liferay.evp.model.impl.EVPDivisionImpl;
import com.liferay.evp.model.impl.EVPDivisionModelImpl;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.kernel.security.permission.InlineSQLHelperUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the e v p division service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Val Nagy
 * @see EVPDivisionPersistence
 * @see EVPDivisionUtil
 * @generated
 */
public class EVPDivisionPersistenceImpl extends BasePersistenceImpl<EVPDivision>
	implements EVPDivisionPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EVPDivisionUtil} to access the e v p division persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EVPDivisionImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EVPDivisionModelImpl.ENTITY_CACHE_ENABLED,
			EVPDivisionModelImpl.FINDER_CACHE_ENABLED, EVPDivisionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EVPDivisionModelImpl.ENTITY_CACHE_ENABLED,
			EVPDivisionModelImpl.FINDER_CACHE_ENABLED, EVPDivisionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EVPDivisionModelImpl.ENTITY_CACHE_ENABLED,
			EVPDivisionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_T = new FinderPath(EVPDivisionModelImpl.ENTITY_CACHE_ENABLED,
			EVPDivisionModelImpl.FINDER_CACHE_ENABLED, EVPDivisionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_T",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_T = new FinderPath(EVPDivisionModelImpl.ENTITY_CACHE_ENABLED,
			EVPDivisionModelImpl.FINDER_CACHE_ENABLED, EVPDivisionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_T",
			new String[] { Long.class.getName(), Integer.class.getName() },
			EVPDivisionModelImpl.COMPANYID_COLUMN_BITMASK |
			EVPDivisionModelImpl.TYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_T = new FinderPath(EVPDivisionModelImpl.ENTITY_CACHE_ENABLED,
			EVPDivisionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_T",
			new String[] { Long.class.getName(), Integer.class.getName() });

	/**
	 * Returns all the e v p divisions where companyId = &#63; and type = &#63;.
	 *
	 * @param companyId the company ID
	 * @param type the type
	 * @return the matching e v p divisions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EVPDivision> findByC_T(long companyId, int type)
		throws SystemException {
		return findByC_T(companyId, type, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the e v p divisions where companyId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.evp.model.impl.EVPDivisionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param type the type
	 * @param start the lower bound of the range of e v p divisions
	 * @param end the upper bound of the range of e v p divisions (not inclusive)
	 * @return the range of matching e v p divisions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EVPDivision> findByC_T(long companyId, int type, int start,
		int end) throws SystemException {
		return findByC_T(companyId, type, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e v p divisions where companyId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.evp.model.impl.EVPDivisionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param type the type
	 * @param start the lower bound of the range of e v p divisions
	 * @param end the upper bound of the range of e v p divisions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e v p divisions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EVPDivision> findByC_T(long companyId, int type, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_T;
			finderArgs = new Object[] { companyId, type };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_T;
			finderArgs = new Object[] {
					companyId, type,
					
					start, end, orderByComparator
				};
		}

		List<EVPDivision> list = (List<EVPDivision>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EVPDivision evpDivision : list) {
				if ((companyId != evpDivision.getCompanyId()) ||
						(type != evpDivision.getType())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_EVPDIVISION_WHERE);

			query.append(_FINDER_COLUMN_C_T_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_T_TYPE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EVPDivisionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(type);

				if (!pagination) {
					list = (List<EVPDivision>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EVPDivision>(list);
				}
				else {
					list = (List<EVPDivision>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first e v p division in the ordered set where companyId = &#63; and type = &#63;.
	 *
	 * @param companyId the company ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e v p division
	 * @throws com.liferay.evp.NoSuchDivisionException if a matching e v p division could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EVPDivision findByC_T_First(long companyId, int type,
		OrderByComparator orderByComparator)
		throws NoSuchDivisionException, SystemException {
		EVPDivision evpDivision = fetchByC_T_First(companyId, type,
				orderByComparator);

		if (evpDivision != null) {
			return evpDivision;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", type=");
		msg.append(type);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDivisionException(msg.toString());
	}

	/**
	 * Returns the first e v p division in the ordered set where companyId = &#63; and type = &#63;.
	 *
	 * @param companyId the company ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e v p division, or <code>null</code> if a matching e v p division could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EVPDivision fetchByC_T_First(long companyId, int type,
		OrderByComparator orderByComparator) throws SystemException {
		List<EVPDivision> list = findByC_T(companyId, type, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e v p division in the ordered set where companyId = &#63; and type = &#63;.
	 *
	 * @param companyId the company ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e v p division
	 * @throws com.liferay.evp.NoSuchDivisionException if a matching e v p division could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EVPDivision findByC_T_Last(long companyId, int type,
		OrderByComparator orderByComparator)
		throws NoSuchDivisionException, SystemException {
		EVPDivision evpDivision = fetchByC_T_Last(companyId, type,
				orderByComparator);

		if (evpDivision != null) {
			return evpDivision;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", type=");
		msg.append(type);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDivisionException(msg.toString());
	}

	/**
	 * Returns the last e v p division in the ordered set where companyId = &#63; and type = &#63;.
	 *
	 * @param companyId the company ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e v p division, or <code>null</code> if a matching e v p division could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EVPDivision fetchByC_T_Last(long companyId, int type,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByC_T(companyId, type);

		if (count == 0) {
			return null;
		}

		List<EVPDivision> list = findByC_T(companyId, type, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e v p divisions before and after the current e v p division in the ordered set where companyId = &#63; and type = &#63;.
	 *
	 * @param evpDivisionId the primary key of the current e v p division
	 * @param companyId the company ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e v p division
	 * @throws com.liferay.evp.NoSuchDivisionException if a e v p division with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EVPDivision[] findByC_T_PrevAndNext(long evpDivisionId,
		long companyId, int type, OrderByComparator orderByComparator)
		throws NoSuchDivisionException, SystemException {
		EVPDivision evpDivision = findByPrimaryKey(evpDivisionId);

		Session session = null;

		try {
			session = openSession();

			EVPDivision[] array = new EVPDivisionImpl[3];

			array[0] = getByC_T_PrevAndNext(session, evpDivision, companyId,
					type, orderByComparator, true);

			array[1] = evpDivision;

			array[2] = getByC_T_PrevAndNext(session, evpDivision, companyId,
					type, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected EVPDivision getByC_T_PrevAndNext(Session session,
		EVPDivision evpDivision, long companyId, int type,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EVPDIVISION_WHERE);

		query.append(_FINDER_COLUMN_C_T_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_T_TYPE_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(EVPDivisionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(type);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(evpDivision);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EVPDivision> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the e v p divisions that the user has permission to view where companyId = &#63; and type = &#63;.
	 *
	 * @param companyId the company ID
	 * @param type the type
	 * @return the matching e v p divisions that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EVPDivision> filterFindByC_T(long companyId, int type)
		throws SystemException {
		return filterFindByC_T(companyId, type, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e v p divisions that the user has permission to view where companyId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.evp.model.impl.EVPDivisionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param type the type
	 * @param start the lower bound of the range of e v p divisions
	 * @param end the upper bound of the range of e v p divisions (not inclusive)
	 * @return the range of matching e v p divisions that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EVPDivision> filterFindByC_T(long companyId, int type,
		int start, int end) throws SystemException {
		return filterFindByC_T(companyId, type, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e v p divisions that the user has permissions to view where companyId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.evp.model.impl.EVPDivisionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param type the type
	 * @param start the lower bound of the range of e v p divisions
	 * @param end the upper bound of the range of e v p divisions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e v p divisions that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EVPDivision> filterFindByC_T(long companyId, int type,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled()) {
			return findByC_T(companyId, type, start, end, orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_EVPDIVISION_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_EVPDIVISION_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_C_T_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_T_TYPE_2_SQL);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_EVPDIVISION_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator, true);
			}
			else {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
					orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(EVPDivisionModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(EVPDivisionModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				EVPDivision.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, EVPDivisionImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, EVPDivisionImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(companyId);

			qPos.add(type);

			return (List<EVPDivision>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the e v p divisions before and after the current e v p division in the ordered set of e v p divisions that the user has permission to view where companyId = &#63; and type = &#63;.
	 *
	 * @param evpDivisionId the primary key of the current e v p division
	 * @param companyId the company ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e v p division
	 * @throws com.liferay.evp.NoSuchDivisionException if a e v p division with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EVPDivision[] filterFindByC_T_PrevAndNext(long evpDivisionId,
		long companyId, int type, OrderByComparator orderByComparator)
		throws NoSuchDivisionException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled()) {
			return findByC_T_PrevAndNext(evpDivisionId, companyId, type,
				orderByComparator);
		}

		EVPDivision evpDivision = findByPrimaryKey(evpDivisionId);

		Session session = null;

		try {
			session = openSession();

			EVPDivision[] array = new EVPDivisionImpl[3];

			array[0] = filterGetByC_T_PrevAndNext(session, evpDivision,
					companyId, type, orderByComparator, true);

			array[1] = evpDivision;

			array[2] = filterGetByC_T_PrevAndNext(session, evpDivision,
					companyId, type, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected EVPDivision filterGetByC_T_PrevAndNext(Session session,
		EVPDivision evpDivision, long companyId, int type,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_EVPDIVISION_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_EVPDIVISION_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_C_T_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_T_TYPE_2_SQL);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_EVPDIVISION_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(EVPDivisionModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(EVPDivisionModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				EVPDivision.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, EVPDivisionImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, EVPDivisionImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(type);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(evpDivision);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EVPDivision> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e v p divisions where companyId = &#63; and type = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param type the type
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByC_T(long companyId, int type) throws SystemException {
		for (EVPDivision evpDivision : findByC_T(companyId, type,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(evpDivision);
		}
	}

	/**
	 * Returns the number of e v p divisions where companyId = &#63; and type = &#63;.
	 *
	 * @param companyId the company ID
	 * @param type the type
	 * @return the number of matching e v p divisions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByC_T(long companyId, int type) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_T;

		Object[] finderArgs = new Object[] { companyId, type };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_EVPDIVISION_WHERE);

			query.append(_FINDER_COLUMN_C_T_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_T_TYPE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(type);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of e v p divisions that the user has permission to view where companyId = &#63; and type = &#63;.
	 *
	 * @param companyId the company ID
	 * @param type the type
	 * @return the number of matching e v p divisions that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByC_T(long companyId, int type)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled()) {
			return countByC_T(companyId, type);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_EVPDIVISION_WHERE);

		query.append(_FINDER_COLUMN_C_T_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_T_TYPE_2_SQL);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				EVPDivision.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(companyId);

			qPos.add(type);

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_C_T_COMPANYID_2 = "evpDivision.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_T_TYPE_2 = "evpDivision.type = ?";
	private static final String _FINDER_COLUMN_C_T_TYPE_2_SQL = "evpDivision.type_ = ?";

	public EVPDivisionPersistenceImpl() {
		setModelClass(EVPDivision.class);
	}

	/**
	 * Caches the e v p division in the entity cache if it is enabled.
	 *
	 * @param evpDivision the e v p division
	 */
	@Override
	public void cacheResult(EVPDivision evpDivision) {
		EntityCacheUtil.putResult(EVPDivisionModelImpl.ENTITY_CACHE_ENABLED,
			EVPDivisionImpl.class, evpDivision.getPrimaryKey(), evpDivision);

		evpDivision.resetOriginalValues();
	}

	/**
	 * Caches the e v p divisions in the entity cache if it is enabled.
	 *
	 * @param evpDivisions the e v p divisions
	 */
	@Override
	public void cacheResult(List<EVPDivision> evpDivisions) {
		for (EVPDivision evpDivision : evpDivisions) {
			if (EntityCacheUtil.getResult(
						EVPDivisionModelImpl.ENTITY_CACHE_ENABLED,
						EVPDivisionImpl.class, evpDivision.getPrimaryKey()) == null) {
				cacheResult(evpDivision);
			}
			else {
				evpDivision.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e v p divisions.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(EVPDivisionImpl.class.getName());
		}

		EntityCacheUtil.clearCache(EVPDivisionImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e v p division.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EVPDivision evpDivision) {
		EntityCacheUtil.removeResult(EVPDivisionModelImpl.ENTITY_CACHE_ENABLED,
			EVPDivisionImpl.class, evpDivision.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<EVPDivision> evpDivisions) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (EVPDivision evpDivision : evpDivisions) {
			EntityCacheUtil.removeResult(EVPDivisionModelImpl.ENTITY_CACHE_ENABLED,
				EVPDivisionImpl.class, evpDivision.getPrimaryKey());
		}
	}

	/**
	 * Creates a new e v p division with the primary key. Does not add the e v p division to the database.
	 *
	 * @param evpDivisionId the primary key for the new e v p division
	 * @return the new e v p division
	 */
	@Override
	public EVPDivision create(long evpDivisionId) {
		EVPDivision evpDivision = new EVPDivisionImpl();

		evpDivision.setNew(true);
		evpDivision.setPrimaryKey(evpDivisionId);

		return evpDivision;
	}

	/**
	 * Removes the e v p division with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param evpDivisionId the primary key of the e v p division
	 * @return the e v p division that was removed
	 * @throws com.liferay.evp.NoSuchDivisionException if a e v p division with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EVPDivision remove(long evpDivisionId)
		throws NoSuchDivisionException, SystemException {
		return remove((Serializable)evpDivisionId);
	}

	/**
	 * Removes the e v p division with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e v p division
	 * @return the e v p division that was removed
	 * @throws com.liferay.evp.NoSuchDivisionException if a e v p division with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EVPDivision remove(Serializable primaryKey)
		throws NoSuchDivisionException, SystemException {
		Session session = null;

		try {
			session = openSession();

			EVPDivision evpDivision = (EVPDivision)session.get(EVPDivisionImpl.class,
					primaryKey);

			if (evpDivision == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDivisionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(evpDivision);
		}
		catch (NoSuchDivisionException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected EVPDivision removeImpl(EVPDivision evpDivision)
		throws SystemException {
		evpDivision = toUnwrappedModel(evpDivision);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(evpDivision)) {
				evpDivision = (EVPDivision)session.get(EVPDivisionImpl.class,
						evpDivision.getPrimaryKeyObj());
			}

			if (evpDivision != null) {
				session.delete(evpDivision);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (evpDivision != null) {
			clearCache(evpDivision);
		}

		return evpDivision;
	}

	@Override
	public EVPDivision updateImpl(com.liferay.evp.model.EVPDivision evpDivision)
		throws SystemException {
		evpDivision = toUnwrappedModel(evpDivision);

		boolean isNew = evpDivision.isNew();

		EVPDivisionModelImpl evpDivisionModelImpl = (EVPDivisionModelImpl)evpDivision;

		Session session = null;

		try {
			session = openSession();

			if (evpDivision.isNew()) {
				session.save(evpDivision);

				evpDivision.setNew(false);
			}
			else {
				session.merge(evpDivision);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !EVPDivisionModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((evpDivisionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_T.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						evpDivisionModelImpl.getOriginalCompanyId(),
						evpDivisionModelImpl.getOriginalType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_T, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_T,
					args);

				args = new Object[] {
						evpDivisionModelImpl.getCompanyId(),
						evpDivisionModelImpl.getType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_T, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_T,
					args);
			}
		}

		EntityCacheUtil.putResult(EVPDivisionModelImpl.ENTITY_CACHE_ENABLED,
			EVPDivisionImpl.class, evpDivision.getPrimaryKey(), evpDivision);

		return evpDivision;
	}

	protected EVPDivision toUnwrappedModel(EVPDivision evpDivision) {
		if (evpDivision instanceof EVPDivisionImpl) {
			return evpDivision;
		}

		EVPDivisionImpl evpDivisionImpl = new EVPDivisionImpl();

		evpDivisionImpl.setNew(evpDivision.isNew());
		evpDivisionImpl.setPrimaryKey(evpDivision.getPrimaryKey());

		evpDivisionImpl.setEvpDivisionId(evpDivision.getEvpDivisionId());
		evpDivisionImpl.setCompanyId(evpDivision.getCompanyId());
		evpDivisionImpl.setUserId(evpDivision.getUserId());
		evpDivisionImpl.setUserName(evpDivision.getUserName());
		evpDivisionImpl.setCreateDate(evpDivision.getCreateDate());
		evpDivisionImpl.setModifiedDate(evpDivision.getModifiedDate());
		evpDivisionImpl.setOrganizationId(evpDivision.getOrganizationId());
		evpDivisionImpl.setParentEVPDivisionId(evpDivision.getParentEVPDivisionId());
		evpDivisionImpl.setAbbreviation(evpDivision.getAbbreviation());
		evpDivisionImpl.setType(evpDivision.getType());

		return evpDivisionImpl;
	}

	/**
	 * Returns the e v p division with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e v p division
	 * @return the e v p division
	 * @throws com.liferay.evp.NoSuchDivisionException if a e v p division with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EVPDivision findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDivisionException, SystemException {
		EVPDivision evpDivision = fetchByPrimaryKey(primaryKey);

		if (evpDivision == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDivisionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return evpDivision;
	}

	/**
	 * Returns the e v p division with the primary key or throws a {@link com.liferay.evp.NoSuchDivisionException} if it could not be found.
	 *
	 * @param evpDivisionId the primary key of the e v p division
	 * @return the e v p division
	 * @throws com.liferay.evp.NoSuchDivisionException if a e v p division with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EVPDivision findByPrimaryKey(long evpDivisionId)
		throws NoSuchDivisionException, SystemException {
		return findByPrimaryKey((Serializable)evpDivisionId);
	}

	/**
	 * Returns the e v p division with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e v p division
	 * @return the e v p division, or <code>null</code> if a e v p division with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EVPDivision fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		EVPDivision evpDivision = (EVPDivision)EntityCacheUtil.getResult(EVPDivisionModelImpl.ENTITY_CACHE_ENABLED,
				EVPDivisionImpl.class, primaryKey);

		if (evpDivision == _nullEVPDivision) {
			return null;
		}

		if (evpDivision == null) {
			Session session = null;

			try {
				session = openSession();

				evpDivision = (EVPDivision)session.get(EVPDivisionImpl.class,
						primaryKey);

				if (evpDivision != null) {
					cacheResult(evpDivision);
				}
				else {
					EntityCacheUtil.putResult(EVPDivisionModelImpl.ENTITY_CACHE_ENABLED,
						EVPDivisionImpl.class, primaryKey, _nullEVPDivision);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(EVPDivisionModelImpl.ENTITY_CACHE_ENABLED,
					EVPDivisionImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return evpDivision;
	}

	/**
	 * Returns the e v p division with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param evpDivisionId the primary key of the e v p division
	 * @return the e v p division, or <code>null</code> if a e v p division with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EVPDivision fetchByPrimaryKey(long evpDivisionId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)evpDivisionId);
	}

	/**
	 * Returns all the e v p divisions.
	 *
	 * @return the e v p divisions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EVPDivision> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e v p divisions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.evp.model.impl.EVPDivisionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e v p divisions
	 * @param end the upper bound of the range of e v p divisions (not inclusive)
	 * @return the range of e v p divisions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EVPDivision> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e v p divisions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.evp.model.impl.EVPDivisionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e v p divisions
	 * @param end the upper bound of the range of e v p divisions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e v p divisions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EVPDivision> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<EVPDivision> list = (List<EVPDivision>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_EVPDIVISION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EVPDIVISION;

				if (pagination) {
					sql = sql.concat(EVPDivisionModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<EVPDivision>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EVPDivision>(list);
				}
				else {
					list = (List<EVPDivision>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the e v p divisions from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (EVPDivision evpDivision : findAll()) {
			remove(evpDivision);
		}
	}

	/**
	 * Returns the number of e v p divisions.
	 *
	 * @return the number of e v p divisions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_EVPDIVISION);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the e v p division persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.evp.model.EVPDivision")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<EVPDivision>> listenersList = new ArrayList<ModelListener<EVPDivision>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<EVPDivision>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(EVPDivisionImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_EVPDIVISION = "SELECT evpDivision FROM EVPDivision evpDivision";
	private static final String _SQL_SELECT_EVPDIVISION_WHERE = "SELECT evpDivision FROM EVPDivision evpDivision WHERE ";
	private static final String _SQL_COUNT_EVPDIVISION = "SELECT COUNT(evpDivision) FROM EVPDivision evpDivision";
	private static final String _SQL_COUNT_EVPDIVISION_WHERE = "SELECT COUNT(evpDivision) FROM EVPDivision evpDivision WHERE ";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "evpDivision.evpDivisionId";
	private static final String _FILTER_SQL_SELECT_EVPDIVISION_WHERE = "SELECT DISTINCT {evpDivision.*} FROM EVPDivision evpDivision WHERE ";
	private static final String _FILTER_SQL_SELECT_EVPDIVISION_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {EVPDivision.*} FROM (SELECT DISTINCT evpDivision.evpDivisionId FROM EVPDivision evpDivision WHERE ";
	private static final String _FILTER_SQL_SELECT_EVPDIVISION_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN EVPDivision ON TEMP_TABLE.evpDivisionId = EVPDivision.evpDivisionId";
	private static final String _FILTER_SQL_COUNT_EVPDIVISION_WHERE = "SELECT COUNT(DISTINCT evpDivision.evpDivisionId) AS COUNT_VALUE FROM EVPDivision evpDivision WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "evpDivision";
	private static final String _FILTER_ENTITY_TABLE = "EVPDivision";
	private static final String _ORDER_BY_ENTITY_ALIAS = "evpDivision.";
	private static final String _ORDER_BY_ENTITY_TABLE = "EVPDivision.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No EVPDivision exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No EVPDivision exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(EVPDivisionPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"type"
			});
	private static EVPDivision _nullEVPDivision = new EVPDivisionImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<EVPDivision> toCacheModel() {
				return _nullEVPDivisionCacheModel;
			}
		};

	private static CacheModel<EVPDivision> _nullEVPDivisionCacheModel = new CacheModel<EVPDivision>() {
			@Override
			public EVPDivision toEntityModel() {
				return _nullEVPDivision;
			}
		};
}
