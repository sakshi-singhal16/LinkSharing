<%@ page import="com.tothenew.linksharing.ReadingItem" %>



<div class="fieldcontain ${hasErrors(bean: readingItemInstance, field: 'resource', 'error')} required">
	<label for="resource">
		<g:message code="readingItem.resource.label" default="Resource" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="resource" name="resource.id" from="${com.tothenew.linksharing.Resource.list()}" optionKey="id" required="" value="${readingItemInstance?.resource?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: readingItemInstance, field: 'reader', 'error')} ">
	<label for="reader">
		<g:message code="readingItem.reader.label" default="Reader" />
		
	</label>
	<g:select id="reader" name="reader.id" from="${com.tothenew.linksharing.User.list()}" optionKey="id" value="${readingItemInstance?.reader?.id}" class="many-to-one" noSelection="['null': '']"/>

</div>

<div class="fieldcontain ${hasErrors(bean: readingItemInstance, field: 'isRead', 'error')} ">
	<label for="isRead">
		<g:message code="readingItem.isRead.label" default="Is Read" />
		
	</label>
	<g:checkBox name="isRead" value="${readingItemInstance?.isRead}" />

</div>

<div class="fieldcontain ${hasErrors(bean: readingItemInstance, field: 'user', 'error')} required">
	<label for="user">
		<g:message code="readingItem.user.label" default="User" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="user" name="user.id" from="${com.tothenew.linksharing.User.list()}" optionKey="id" required="" value="${readingItemInstance?.user?.id}" class="many-to-one"/>

</div>

