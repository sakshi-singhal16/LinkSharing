<%@ page import="com.tothenew.linksharing.Resource" %>



<div class="fieldcontain ${hasErrors(bean: resourceInstance, field: 'topic', 'error')} required">
	<label for="topic">
		<g:message code="resource.topic.label" default="Topic" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="topic" name="topic.id" from="${com.tothenew.linksharing.Topic.list()}" optionKey="id" required="" value="${resourceInstance?.topic?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: resourceInstance, field: 'createdBy', 'error')} required">
	<label for="createdBy">
		<g:message code="resource.createdBy.label" default="Created By" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="createdBy" name="createdBy.id" from="${com.tothenew.linksharing.User.list()}" optionKey="id" required="" value="${resourceInstance?.createdBy?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: resourceInstance, field: 'description', 'error')} required">
	<label for="description">
		<g:message code="resource.description.label" default="Description" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="description" required="" value="${resourceInstance?.description}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: resourceInstance, field: 'readingIntems', 'error')} ">
	<label for="readingIntems">
		<g:message code="resource.readingIntems.label" default="Reading Intems" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${resourceInstance?.readingIntems?}" var="r">
    <li><g:link controller="readingItem" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="readingItem" action="create" params="['resource.id': resourceInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'readingItem.label', default: 'ReadingItem')])}</g:link>
</li>
</ul>


</div>

<div class="fieldcontain ${hasErrors(bean: resourceInstance, field: 'resourceRatings', 'error')} ">
	<label for="resourceRatings">
		<g:message code="resource.resourceRatings.label" default="Resource Ratings" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${resourceInstance?.resourceRatings?}" var="r">
    <li><g:link controller="resourceRating" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="resourceRating" action="create" params="['resource.id': resourceInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'resourceRating.label', default: 'ResourceRating')])}</g:link>
</li>
</ul>


</div>

