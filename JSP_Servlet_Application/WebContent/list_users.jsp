<%@ include file="include/header.jsp" %>

<%@ page import="java.sql.ResultSet" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- COMMENT
<%
	ResultSet rs = (ResultSet)request.getAttribute("users");

	while(rs.next()){
		String email = rs.getString("user_email");
		out.println(email);
	}
%>
--%>

<table border="1">
<th>User ID</th>
<th>Name </th>
<th>Email </th>
<th>Action </th>

<c:forEach var="temp" items="${ userList }">

<c:url var="tempURL" value="Controller">
<c:param name="page" value="updateUser" />
<c:param name="user_id" value="${ temp.id }" />
</c:url>

<c:url var="tempURL2" value="Controller">
<c:param name="page" value="deleteUser"/>
<c:param name="user_id" value="${temp.id }"></c:param>
</c:url>

<tr>
<td>${ temp.id} </td>
<td>${ temp.name} </td>
<td>${ temp.email} </td>
<td><a href="${tempURL}">Update</a>|
<a href="${tempURL2}" onclick="if(!(confirm('Are you sure, to delete this user ?'))) return false">Delete</a>
</td>
</tr>

</c:forEach>

</table>

<%@ include file="include/footer.jsp" %>