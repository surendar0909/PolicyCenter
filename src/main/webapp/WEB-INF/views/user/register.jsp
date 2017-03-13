<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="../header.jsp" />
<body>
<div class="">
<jsp:include page="../menu.jsp" />
<h2>User Details</h2>
<spring:url value="/users/adduser" var="adduserurl" />
<form:form method="POST" action="${adduserurl}" modelAttribute="user">
<form:hidden path="user_id" />
	<div class="form-group">
        <form:label path="username" class="col-sm-2 control-label"> Username</form:label>
        <form:input path="username" type="text" class="form-control " />
        <form:errors path="username" class="control-label" />
    </div>
    <div class="form-group">
        <form:label path="firstname" class="col-sm-2 control-label">First Name</form:label>
        <form:input path="firstname" type="text" class="form-control " />
        <form:errors path="firstname" class="control-label" />
     </div>   
    <div class="form-group">
        <form:label path="mobile" class="col-sm-2 control-label">Mobile</form:label>
        <form:input path="mobile" type="text" class="form-control " />
        <form:errors path="mobile" class="control-label" />
    </div>  
    <div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
		<c:choose>
					<c:when test="${user['user_id']}">
						<button type="submit" class="btn-lg btn-primary pull-right">Update</button>
					</c:when>
					<c:otherwise>
						<button type="submit" class="btn-lg btn-primary pull-right">Submit</button>
					</c:otherwise>
				</c:choose>
        </div>
    </div>
         
</form:form>
</div>
</body>
</html>