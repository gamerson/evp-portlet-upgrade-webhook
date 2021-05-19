<%--
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
--%>

<%@ page import="com.liferay.alloy.mvc.AlloyController" %><%@
page import="com.liferay.alloy.mvc.AlloyException" %><%@
page import="com.liferay.alloy.mvc.AlloyPermission" %><%@
page import="com.liferay.alloy.mvc.AlloySearchResult" %><%@
page import="com.liferay.alloy.mvc.AlloyServiceInvoker" %><%@
page import="com.liferay.alloy.mvc.BaseAlloyIndexer" %><%@
page import="com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil" %><%@
page import="com.liferay.compat.portal.kernel.bean.BeanPropertiesUtil" %><%@
page import="com.liferay.compat.portal.kernel.dao.orm.ProjectionFactoryUtil" %><%@
page import="com.liferay.compat.portal.kernel.search.Field" %><%@
page import="com.liferay.compat.portal.kernel.util.ArrayUtil" %><%@
page import="com.liferay.compat.portal.kernel.util.HttpUtil" %><%@
page import="com.liferay.compat.portal.kernel.util.ListUtil" %><%@
page import="com.liferay.compat.portal.kernel.util.StringUtil" %><%@
page import="com.liferay.compat.portal.util.PortalUtil" %><%@
page import="com.liferay.document.library.kernel.model.DLFolderConstants" %><%@
page import="com.liferay.document.library.kernel.service.DLAppLocalServiceUtil" %><%@
page import="com.liferay.document.library.kernel.util.DLUtil" %><%@
page import="com.liferay.evp.model.EVPDivision" %><%@
page import="com.liferay.evp.model.EVPEmployee" %><%@
page import="com.liferay.evp.model.EVPGrantRequest" %><%@
page import="com.liferay.evp.model.EVPGrantTransaction" %><%@
page import="com.liferay.evp.model.EVPKaleoForkInstance" %><%@
page import="com.liferay.evp.model.EVPRequestOrganization" %><%@
page import="com.liferay.evp.model.EVPServiceRequest" %><%@
page import="com.liferay.evp.model.impl.EVPGrantTransactionModelImpl" %><%@
page import="com.liferay.evp.service.EVPDivisionLocalServiceUtil" %><%@
page import="com.liferay.evp.service.EVPEmployeeLocalServiceUtil" %><%@
page import="com.liferay.evp.service.EVPGrantRequestLocalServiceUtil" %><%@
page import="com.liferay.evp.service.EVPGrantTransactionLocalServiceUtil" %><%@
page import="com.liferay.evp.service.EVPRequestOrganizationLocalServiceUtil" %><%@
page import="com.liferay.evp.service.EVPServiceRequestLocalServiceUtil" %><%@
page import="com.liferay.evp.util.PortletKeys" %><%@
page import="com.liferay.expando.kernel.model.ExpandoTableConstants" %><%@
page import="com.liferay.expando.kernel.model.ExpandoValue" %><%@
page import="com.liferay.expando.kernel.service.ExpandoValueLocalServiceUtil" %><%@
page import="com.liferay.message.boards.constants.MBThreadConstants" %><%@
page import="com.liferay.message.boards.model.MBMessage" %><%@
page import="com.liferay.message.boards.model.MBMessageDisplay" %><%@
page import="com.liferay.message.boards.model.MBThread" %><%@
page import="com.liferay.message.boards.model.MBTreeWalker" %><%@
page import="com.liferay.message.boards.service.MBMessageLocalServiceUtil" %><%@
page import="com.liferay.message.boards.service.MBMessageServiceUtil" %><%@
page import="com.liferay.message.boards.util.comparator.MessageCreateDateComparator" %><%@
page import="com.liferay.petra.string.CharPool" %><%@
page import="com.liferay.portal.kernel.dao.orm.Criterion" %><%@
page import="com.liferay.portal.kernel.dao.orm.DynamicQuery" %><%@
page import="com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil" %><%@
page import="com.liferay.portal.kernel.dao.orm.Projection" %><%@
page import="com.liferay.portal.kernel.dao.orm.Property" %><%@
page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil" %><%@
page import="com.liferay.portal.kernel.dao.orm.QueryUtil" %><%@
page import="com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil" %><%@
page import="com.liferay.portal.kernel.dao.search.SearchContainer" %><%@
page import="com.liferay.portal.kernel.language.LanguageUtil" %><%@
page import="com.liferay.portal.kernel.language.UnicodeLanguageUtil" %><%@
page import="com.liferay.portal.kernel.log.Log" %><%@
page import="com.liferay.portal.kernel.log.LogFactoryUtil" %><%@
page import="com.liferay.portal.kernel.messaging.BaseMessageListener" %><%@
page import="com.liferay.portal.kernel.messaging.Message" %><%@
page import="com.liferay.portal.kernel.messaging.MessageListener" %><%@
page import="com.liferay.portal.kernel.model.Address" %><%@
page import="com.liferay.portal.kernel.model.AuditedModel" %><%@
page import="com.liferay.portal.kernel.model.BaseModel" %><%@
page import="com.liferay.portal.kernel.model.Contact" %><%@
page import="com.liferay.portal.kernel.model.Country" %><%@
page import="com.liferay.portal.kernel.model.EmailAddress" %><%@
page import="com.liferay.portal.kernel.model.Layout" %><%@
page import="com.liferay.portal.kernel.model.ListTypeConstants" %><%@
page import="com.liferay.portal.kernel.model.Organization" %><%@
page import="com.liferay.portal.kernel.model.Phone" %><%@
page import="com.liferay.portal.kernel.model.Portlet" %><%@
page import="com.liferay.portal.kernel.model.Region" %><%@
page import="com.liferay.portal.kernel.model.ResourceConstants" %><%@
page import="com.liferay.portal.kernel.model.Role" %><%@
page import="com.liferay.portal.kernel.model.RoleConstants" %><%@
page import="com.liferay.portal.kernel.model.User" %><%@
page import="com.liferay.portal.kernel.model.UserGroupRole" %><%@
page import="com.liferay.portal.kernel.model.Website" %><%@
page import="com.liferay.portal.kernel.model.WorkflowInstanceLink" %><%@
page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %><%@
page import="com.liferay.portal.kernel.portlet.PortletURLFactoryUtil" %><%@
page import="com.liferay.portal.kernel.repository.model.FileEntry" %><%@
page import="com.liferay.portal.kernel.repository.model.Folder" %><%@
page import="com.liferay.portal.kernel.scheduler.CronTrigger" %><%@
page import="com.liferay.portal.kernel.scheduler.Trigger" %><%@
page import="com.liferay.portal.kernel.search.BooleanClauseOccur" %><%@
page import="com.liferay.portal.kernel.search.BooleanQuery" %><%@
page import="com.liferay.portal.kernel.search.BooleanQueryFactoryUtil" %><%@
page import="com.liferay.portal.kernel.search.Document" %><%@
page import="com.liferay.portal.kernel.search.Indexer" %><%@
page import="com.liferay.portal.kernel.search.IndexerRegistryUtil" %><%@
page import="com.liferay.portal.kernel.search.SearchContext" %><%@
page import="com.liferay.portal.kernel.search.Sort" %><%@
page import="com.liferay.portal.kernel.search.Summary" %><%@
page import="com.liferay.portal.kernel.security.permission.PermissionChecker" %><%@
page import="com.liferay.portal.kernel.security.permission.PermissionCheckerFactoryUtil" %><%@
page import="com.liferay.portal.kernel.security.permission.PermissionThreadLocal" %><%@
page import="com.liferay.portal.kernel.service.AddressLocalServiceUtil" %><%@
page import="com.liferay.portal.kernel.service.CountryServiceUtil" %><%@
page import="com.liferay.portal.kernel.service.EmailAddressLocalServiceUtil" %><%@
page import="com.liferay.portal.kernel.service.OrganizationLocalServiceUtil" %><%@
page import="com.liferay.portal.kernel.service.PhoneLocalServiceUtil" %><%@
page import="com.liferay.portal.kernel.service.PortletPreferencesLocalServiceUtil" %><%@
page import="com.liferay.portal.kernel.service.RegionServiceUtil" %><%@
page import="com.liferay.portal.kernel.service.ResourceLocalServiceUtil" %><%@
page import="com.liferay.portal.kernel.service.RoleLocalServiceUtil" %><%@
page import="com.liferay.portal.kernel.service.ServiceContext" %><%@
page import="com.liferay.portal.kernel.service.ServiceContextFactory" %><%@
page import="com.liferay.portal.kernel.service.UserGroupRoleLocalServiceUtil" %><%@
page import="com.liferay.portal.kernel.service.UserLocalServiceUtil" %><%@
page import="com.liferay.portal.kernel.service.WebsiteLocalServiceUtil" %><%@
page import="com.liferay.portal.kernel.service.WorkflowInstanceLinkLocalServiceUtil" %><%@
page import="com.liferay.portal.kernel.servlet.SessionMessages" %><%@
page import="com.liferay.portal.kernel.theme.ThemeDisplay" %><%@
page import="com.liferay.portal.kernel.transaction.TransactionCommitCallbackRegistryUtil" %><%@
page import="com.liferay.portal.kernel.upload.UploadPortletRequest" %><%@
page import="com.liferay.portal.kernel.util.BigDecimalUtil" %><%@
page import="com.liferay.portal.kernel.util.CalendarFactoryUtil" %><%@
page import="com.liferay.portal.kernel.util.CalendarUtil" %><%@
page import="com.liferay.portal.kernel.util.ContentTypes" %><%@
page import="com.liferay.portal.kernel.util.DateFormatFactoryUtil" %><%@
page import="com.liferay.portal.kernel.util.DateUtil" %><%@
page import="com.liferay.portal.kernel.util.DigesterUtil" %><%@
page import="com.liferay.portal.kernel.util.FastDateFormatFactoryUtil" %><%@
page import="com.liferay.portal.kernel.util.GetterUtil" %><%@
page import="com.liferay.portal.kernel.util.Http" %><%@
page import="com.liferay.portal.kernel.util.JavaConstants" %><%@
page import="com.liferay.portal.kernel.util.MimeTypesUtil" %><%@
page import="com.liferay.portal.kernel.util.OrderByComparator" %><%@
page import="com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil" %><%@
page import="com.liferay.portal.kernel.util.ParamUtil" %><%@
page import="com.liferay.portal.kernel.util.Portal" %><%@
page import="com.liferay.portal.kernel.util.PortalClassLoaderUtil" %><%@
page import="com.liferay.portal.kernel.util.StringBundler" %><%@
page import="com.liferay.portal.kernel.util.StringPool" %><%@
page import="com.liferay.portal.kernel.util.SubscriptionSender" %><%@
page import="com.liferay.portal.kernel.util.Validator" %><%@
page import="com.liferay.portal.kernel.util.WebKeys" %><%@
page import="com.liferay.portal.kernel.workflow.WorkflowConstants" %><%@
page import="com.liferay.portal.kernel.workflow.WorkflowException" %><%@
page import="com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil" %><%@
page import="com.liferay.portal.kernel.workflow.WorkflowInstance" %><%@
page import="com.liferay.portal.kernel.workflow.WorkflowInstanceManagerUtil" %><%@
page import="com.liferay.portal.kernel.workflow.WorkflowTask" %><%@
page import="com.liferay.portal.kernel.workflow.WorkflowTaskAssignee" %><%@
page import="com.liferay.portal.kernel.workflow.WorkflowTaskManagerUtil" %><%@
page import="com.liferay.util.ContentUtil" %><%@
page import="com.liferay.util.portlet.PortletProps" %>

<%@ page import="java.io.File" %><%@
page import="java.io.Serializable" %>

<%@ page import="java.lang.reflect.Constructor" %><%@
page import="java.lang.reflect.Method" %>

<%@ page import="java.math.RoundingMode" %>

<%@ page import="java.net.URL" %>

<%@ page import="java.text.DateFormat" %><%@
page import="java.text.Format" %><%@
page import="java.text.NumberFormat" %>

<%@ page import="java.util.ArrayList" %><%@
page import="java.util.Calendar" %><%@
page import="java.util.Collections" %><%@
page import="java.util.Date" %><%@
page import="java.util.HashMap" %><%@
page import="java.util.HashSet" %><%@
page import="java.util.LinkedHashMap" %><%@
page import="java.util.List" %><%@
page import="java.util.Locale" %><%@
page import="java.util.Map" %><%@
page import="java.util.Set" %><%@
page import="java.util.concurrent.Callable" %><%@
page import="java.util.regex.Matcher" %><%@
page import="java.util.regex.Pattern" %>

<%@ page import="javax.portlet.ActionRequest" %><%@
page import="javax.portlet.PortletConfig" %><%@
page import="javax.portlet.PortletMode" %><%@
page import="javax.portlet.PortletPreferences" %><%@
page import="javax.portlet.PortletRequest" %><%@
page import="javax.portlet.PortletURL" %><%@
page import="javax.portlet.WindowState" %>

<%@ page import="javax.servlet.http.HttpServletRequest" %>

<%@ include file="/WEB-INF/jsp/util/address_composite.jspf" %>
<%@ include file="/WEB-INF/jsp/util/email_util.jspf" %>
<%@ include file="/WEB-INF/jsp/util/evp_composite_util.jspf" %>
<%@ include file="/WEB-INF/jsp/util/evp_constants.jspf" %>
<%@ include file="/WEB-INF/jsp/util/evp_division_composite.jspf" %>
<%@ include file="/WEB-INF/jsp/util/evp_division_constants.jspf" %>
<%@ include file="/WEB-INF/jsp/util/evp_division_util.jspf" %>
<%@ include file="/WEB-INF/jsp/util/evp_employee_composite.jspf" %>
<%@ include file="/WEB-INF/jsp/util/evp_grant_request_composite.jspf" %>
<%@ include file="/WEB-INF/jsp/util/evp_grant_request_util.jspf" %>
<%@ include file="/WEB-INF/jsp/util/evp_grant_transaction_composite.jspf" %>
<%@ include file="/WEB-INF/jsp/util/evp_grant_transaction_constants.jspf" %>
<%@ include file="/WEB-INF/jsp/util/evp_kaleo_fork_instance_util.jspf" %>
<%@ include file="/WEB-INF/jsp/util/evp_nightly_job_util.jspf" %>
<%@ include file="/WEB-INF/jsp/util/evp_permission.jspf" %>
<%@ include file="/WEB-INF/jsp/util/evp_portal_util.jspf" %>
<%@ include file="/WEB-INF/jsp/util/evp_request_organization_composite.jspf" %>
<%@ include file="/WEB-INF/jsp/util/evp_request_organization_constants.jspf" %>
<%@ include file="/WEB-INF/jsp/util/evp_request_organization_util.jspf" %>
<%@ include file="/WEB-INF/jsp/util/evp_role_constants.jspf" %>
<%@ include file="/WEB-INF/jsp/util/evp_service_request_composite.jspf" %>
<%@ include file="/WEB-INF/jsp/util/evp_util.jspf" %>
<%@ include file="/WEB-INF/jsp/util/evp_validator.jspf" %>
<%@ include file="/WEB-INF/jsp/util/evp_workflow_constants.jspf" %>
<%@ include file="/WEB-INF/jsp/util/evp_workflow_context_constants.jspf" %>
<%@ include file="/WEB-INF/jsp/util/evp_workflow_context_variables_util.jspf" %>
<%@ include file="/WEB-INF/jsp/util/evp_workflow_task_composite.jspf" %>
<%@ include file="/WEB-INF/jsp/util/evp_workflow_transition_composite.jspf" %>
<%@ include file="/WEB-INF/jsp/util/evp_workflow_util.jspf" %>
<%@ include file="/WEB-INF/jsp/util/portlet_props_keys.jspf" %>
<%@ include file="/WEB-INF/jsp/util/portlet_props_values.jspf" %>
<%@ include file="/WEB-INF/jsp/util/user_composite.jspf" %>
<%@ include file="/WEB-INF/jsp/util/website_composite.jspf" %>