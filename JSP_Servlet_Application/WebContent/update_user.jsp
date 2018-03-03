<%@include file="include/header.jsp" %>

<form action="${pageContext.request.contextPath}/Controller" >
Name : <input type="text" name="name" value=${user.name }>
<br/>
email : <input type="text" name="email" value="${user.email }">
<br/>
<input type="submit" value="Update">
<input type="hidden" name="page" value="updateUser">
<input type="hidden" name="action" value="submit">
<input type="hidden" name="user_id" value="${user.id }">
</form>


<%@include file="include/footer.jsp" %>