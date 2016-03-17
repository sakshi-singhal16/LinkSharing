<!DOCTYPE html>
%{--
<html>
	<head>
		<title><g:if env="development">Grails Runtime Exception</g:if><g:else>Error</g:else></title>
		<meta name="layout" content="ApplicationLayout">
		<g:if env="development"><asset:stylesheet src="errors.css"/></g:if>
	</head>
	<body>
		<g:if env="development">
			<g:renderException exception="${exception}" />
		</g:if>
		<g:else>
			<ul class="errors">
				<li>An error has occurred</li>
			</ul>
		</g:else>
	</body>
</html>
--}%
<html>
<head>
    <asset:stylesheet src="application.css"/>
    <meta name="layout" content="ApplicationLayout"/>
    <title>Link Sharing | Error</title>

</head>

<body>
<h1>Oops!</h1>

<div class="col-md-5 col-md-offset-1 alert alert-danger">Error 500: Internal server error</div>
</body>
</html>
