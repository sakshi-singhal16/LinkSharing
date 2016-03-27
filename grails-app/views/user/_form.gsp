<%@ page import="com.tothenew.linksharing.User" %>



<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'password', 'error')} required">
	<label for="password">
		<g:message code="user.password.label" default="Password" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="password" required="" value="${userInstance?.password}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'firstName', 'error')} required">
	<label for="firstName">
		<g:message code="user.firstName.label" default="First Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="firstName" required="" value="${userInstance?.firstName}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'lastName', 'error')} required">
	<label for="lastName">
		<g:message code="user.lastName.label" default="Last Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="lastName" required="" value="${userInstance?.lastName}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'email', 'error')} required">
	<label for="email">
		<g:message code="user.email.label" default="Email" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="email" name="email" required="" value="${userInstance?.email}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'photo', 'error')} ">
	<label for="photo">
		<g:message code="user.photo.label" default="Photo" />
		
	</label>
	<input type="file" id="photo" name="photo" />

</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'isActive', 'error')} ">
	<label for="isActive">
		<g:message code="user.isActive.label" default="Is Active" />
		
	</label>
	<g:checkBox name="isActive" value="${userInstance?.isActive}" />

</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'isAdmin', 'error')} ">
	<label for="isAdmin">
		<g:message code="user.isAdmin.label" default="Is Admin" />
		
	</label>
	<g:checkBox name="isAdmin" value="${userInstance?.isAdmin}" />

</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'resourceRatings', 'error')} ">
	<label for="resourceRatings">
		<g:message code="user.resourceRatings.label" default="Resource Ratings" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${userInstance?.resourceRatings?}" var="r">
    <li><g:link controller="resourceRating" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="resourceRating" action="create" params="['user.id': userInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'resourceRating.label', default: 'ResourceRating')])}</g:link>
</li>
</ul>


</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'resources', 'error')} ">
	<label for="resources">
		<g:message code="user.resources.label" default="Resources" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${userInstance?.resources?}" var="r">
    <li><g:link controller="resource" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="resource" action="create" params="['user.id': userInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'resource.label', default: 'Resource')])}</g:link>
</li>
</ul>


</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'subscriptions', 'error')} ">
	<label for="subscriptions">
		<g:message code="user.subscriptions.label" default="Subscriptions" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${userInstance?.subscriptions?}" var="s">
    <li><g:link controller="subscription" action="show" id="${s.id}">${s?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="subscription" action="create" params="['user.id': userInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'subscription.label', default: 'Subscription')])}</g:link>
</li>
</ul>


</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'topics', 'error')} ">
	<label for="topics">
		<g:message code="user.topics.label" default="Topics" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${userInstance?.topics?}" var="t">
    <li><g:link controller="topic" action="show" id="${t.id}">${t?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="topic" action="create" params="['user.id': userInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'topic.label', default: 'Topic')])}</g:link>
</li>
</ul>


</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'userName', 'error')} required">
	<label for="userName">
		<g:message code="user.userName.label" default="User Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="userName" required="" value="${userInstance?.userName}"/>

</div>

