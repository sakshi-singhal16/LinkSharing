Hello,${user.name}<br>,
You have following unread items:<br>
<table>
<th>
<td>S.No.</td>
<td>From Topic</td>
</th>
<%
    count = 1
%>
<g:each var="resource" in="${unreadResources}">
    <tr>
        <td>${count}</td>
        <td>${resource.topic}</td>
    </tr>
    <% count++ %>
</g:each>

</table>