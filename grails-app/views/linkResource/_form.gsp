<%@ page import="com.tothenew.linksharing.LinkResource" %>



<div class="fieldcontain ${hasErrors(bean: linkResourceInstance, field: 'topic', 'error')} required">
	<label for="topic">
		<g:message code="linkResource.topic.label" default="Topic" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="topic" name="topic.id" from="${com.tothenew.linksharing.Topic.list()}" optionKey="id" required="" value="${linkResourceInstance?.topic?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: linkResourceInstance, field: 'createdBy', 'error')} required">
	<label for="createdBy">
		<g:message code="linkResource.createdBy.label" default="Created By" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="createdBy" name="createdBy.id" from="${com.tothenew.linksharing.User.list()}" optionKey="id" required="" value="${linkResourceInstance?.createdBy?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: linkResourceInstance, field: 'description', 'error')} required">
	<label for="description">
		<g:message code="linkResource.description.label" default="Description" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="description" required="" value="${linkResourceInstance?.description}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: linkResourceInstance, field: 'url', 'error')} required">
	<label for="url">
		<g:message code="linkResource.url.label" default="Url" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="url" name="url" required="" value="${linkResourceInstance?.url}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: linkResourceInstance, field: 'readingIntems', 'error')} ">
	<label for="readingIntems">
		<g:message code="linkResource.readingIntems.label" default="Reading Intems" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${linkResourceInstance?.readingIntems?}" var="r">
    <li><g:link controller="readingItem" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="readingItem" action="create" params="['linkResource.id': linkResourceInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'readingItem.label', default: 'ReadingItem')])}</g:link>
</li>
</ul>


</div>

<div class="fieldcontain ${hasErrors(bean: linkResourceInstance, field: 'resourceRatings', 'error')} ">
	<label for="resourceRatings">
		<g:message code="linkResource.resourceRatings.label" default="Resource Ratings" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${linkResourceInstance?.resourceRatings?}" var="r">
    <li><g:link controller="resourceRating" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="resourceRating" action="create" params="['linkResource.id': linkResourceInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'resourceRating.label', default: 'ResourceRating')])}</g:link>
</li>
</ul>


</div>

