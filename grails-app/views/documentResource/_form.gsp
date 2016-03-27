<%@ page import="com.tothenew.linksharing.DocumentResource" %>



<div class="fieldcontain ${hasErrors(bean: documentResourceInstance, field: 'topic', 'error')} required">
	<label for="topic">
		<g:message code="documentResource.topic.label" default="Topic" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="topic" name="topic.id" from="${com.tothenew.linksharing.Topic.list()}" optionKey="id" required="" value="${documentResourceInstance?.topic?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: documentResourceInstance, field: 'createdBy', 'error')} required">
	<label for="createdBy">
		<g:message code="documentResource.createdBy.label" default="Created By" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="createdBy" name="createdBy.id" from="${com.tothenew.linksharing.User.list()}" optionKey="id" required="" value="${documentResourceInstance?.createdBy?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: documentResourceInstance, field: 'description', 'error')} required">
	<label for="description">
		<g:message code="documentResource.description.label" default="Description" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="description" required="" value="${documentResourceInstance?.description}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: documentResourceInstance, field: 'filePath', 'error')} required">
	<label for="filePath">
		<g:message code="documentResource.filePath.label" default="File Path" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="filePath" required="" value="${documentResourceInstance?.filePath}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: documentResourceInstance, field: 'readingIntems', 'error')} ">
	<label for="readingIntems">
		<g:message code="documentResource.readingIntems.label" default="Reading Intems" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${documentResourceInstance?.readingIntems?}" var="r">
    <li><g:link controller="readingItem" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="readingItem" action="create" params="['documentResource.id': documentResourceInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'readingItem.label', default: 'ReadingItem')])}</g:link>
</li>
</ul>


</div>

<div class="fieldcontain ${hasErrors(bean: documentResourceInstance, field: 'resourceRatings', 'error')} ">
	<label for="resourceRatings">
		<g:message code="documentResource.resourceRatings.label" default="Resource Ratings" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${documentResourceInstance?.resourceRatings?}" var="r">
    <li><g:link controller="resourceRating" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="resourceRating" action="create" params="['documentResource.id': documentResourceInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'resourceRating.label', default: 'ResourceRating')])}</g:link>
</li>
</ul>


</div>

