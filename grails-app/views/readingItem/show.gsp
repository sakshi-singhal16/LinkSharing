
<%@ page import="com.tothenew.linksharing.ReadingItem" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'readingItem.label', default: 'ReadingItem')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-readingItem" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-readingItem" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list readingItem">
			
				<g:if test="${readingItemInstance?.resource}">
				<li class="fieldcontain">
					<span id="resource-label" class="property-label"><g:message code="readingItem.resource.label" default="Resource" /></span>
					
						<span class="property-value" aria-labelledby="resource-label"><g:link controller="resource" action="show" id="${readingItemInstance?.resource?.id}">${readingItemInstance?.resource?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${readingItemInstance?.reader}">
				<li class="fieldcontain">
					<span id="reader-label" class="property-label"><g:message code="readingItem.reader.label" default="Reader" /></span>
					
						<span class="property-value" aria-labelledby="reader-label"><g:link controller="user" action="show" id="${readingItemInstance?.reader?.id}">${readingItemInstance?.reader?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${readingItemInstance?.isRead}">
				<li class="fieldcontain">
					<span id="isRead-label" class="property-label"><g:message code="readingItem.isRead.label" default="Is Read" /></span>
					
						<span class="property-value" aria-labelledby="isRead-label"><g:formatBoolean boolean="${readingItemInstance?.isRead}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${readingItemInstance?.dateCreated}">
				<li class="fieldcontain">
					<span id="dateCreated-label" class="property-label"><g:message code="readingItem.dateCreated.label" default="Date Created" /></span>
					
						<span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate date="${readingItemInstance?.dateCreated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${readingItemInstance?.lastUpdated}">
				<li class="fieldcontain">
					<span id="lastUpdated-label" class="property-label"><g:message code="readingItem.lastUpdated.label" default="Last Updated" /></span>
					
						<span class="property-value" aria-labelledby="lastUpdated-label"><g:formatDate date="${readingItemInstance?.lastUpdated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${readingItemInstance?.user}">
				<li class="fieldcontain">
					<span id="user-label" class="property-label"><g:message code="readingItem.user.label" default="User" /></span>
					
						<span class="property-value" aria-labelledby="user-label"><g:link controller="user" action="show" id="${readingItemInstance?.user?.id}">${readingItemInstance?.user?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:readingItemInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${readingItemInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
