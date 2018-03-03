<%@include file="include/header.jsp" %>
add a new user ...
<br>
<br>
<form action="${pageContext.request.contextPath}/Controller">
Name <input type="text" name="name" >
<br><br>
Email <input type="text" name="email" >
<br><br>
<input type="submit" value="Submit">
<input type="hidden" name="page" value="submitUser" >
</form>
<%@include file="include/footer.jsp" %>