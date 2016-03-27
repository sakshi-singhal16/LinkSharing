
<%@ page import="com.tothenew.linksharing.LinkResource" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'linkResource.label', default: 'LinkResource')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-linkResource" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-linkResource" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list linkResource">
			
				<g:if test="${linkResourceInstance?.topic}">
				<li class="fieldcontain">
					<span id="topic-label" class="property-label"><g:message code="linkResource.topic.label" default="Topic" /></span>
					
						<span class="property-value" aria-labelledby="topic-label"><g:link controller="topic" action="show" id="${linkResourceInstance?.topic?.id}">${linkResourceInstance?.topic?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${linkResourceInstance?.createdBy}">
				<li class="fieldcontain">
					<span id="createdBy-label" class="property-label"><g:message code="linkResource.createdBy.label" default="Created By" /></span>
					
						<span class="property-value" aria-labelledby="createdBy-label"><g:link controller="user" action="show" id="${linkResourceInstance?.createdBy?.id}">${linkResourceInstance?.createdBy?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${linkResourceInstance?.description}">
				<li class="fieldcontain">
					<span id="description-label" class="property-label"><g:message code="linkResource.description.label" default="Description" /></span>
					
						<span class="property-value" aria-labelledby="description-label"><g:fieldValue bean="${linkResourceInstance}" field="description"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${linkResourceInstance?.url}">
				<li class="fieldcontain">
					<span id="url-label" class="property-label"><g:message code="linkResource.url.label" default="Url" /></span>
					
						<span class="property-value" aria-labelledby="url-label"><g:fieldValue bean="${linkResourceInstance}" field="url"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${linkResourceInstance?.dateCreated}">
				<li class="fieldcontain">
					<span id="dateCreated-label" class="property-label"><g:message code="linkResource.dateCreated.label" default="Date Created" /></span>
					
						<span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate date="${linkResourceInstance?.dateCreated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${linkResourceInstance?.lastUpdated}">
				<li class="fieldcontain">
					<span id="lastUpdated-label" class="property-label"><g:message code="linkResource.lastUpdated.label" default="Last Updated" /></span>
					
						<span class="property-value" aria-labelledby="lastUpdated-label"><g:formatDate date="${linkResourceInstance?.lastUpdated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${linkResourceInstance?.readingIntems}">
				<li class="fieldcontain">
					<span id="readingIntems-label" class="property-label"><g:message code="linkResource.readingIntems.label" default="Reading Intems" /></span>
					
						<g:each in="${linkResourceInstance.readingIntems}" var="r">
						<span class="property-value" aria-labelledby="readingIntems-label"><g:link controller="readingItem" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${linkResourceInstance?.resourceRatings}">
				<li class="fieldcontain">
					<span id="resourceRatings-label" class="property-label"><g:message code="linkResource.resourceRatings.label" default="Resource Ratings" /></span>
					
						<g:each in="${linkResourceInstance.resourceRatings}" var="r">
						<span class="property-value" aria-labelledby="resourceRatings-label"><g:link controller="resourceRating" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:linkResourceInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${linkResourceInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
