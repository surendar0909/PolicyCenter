<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Update User</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
</head>
<body>
<div class="container">
<h2>User Details</h2>
<form:form method="POST" modelAttribute="userForm" action="users/adduser">
<form:hidden path="user_id" />
<spring:bind path="username">
	<div class="form-group">
        <form:label path="username" class="col-sm-2 control-label" id="username"> Username</form:label>
        <form:input path="username" type="text" class="form-control " />
    </div>
</spring:bind>
<spring:bind path="firstname">
    <div class="form-group">
        <form:label path="firstname" class="col-sm-2 control-label" id="firstname">First Name</form:label>
        <form:input path="firstname" type="text" class="form-control " />
     </div>
</spring:bind>
<spring:bind path="mobile">        
    <div class="form-group">
        <form:label path="mobile" class="col-sm-2 control-label" id="mobile">Mobile</form:label>
        <form:input path="mobile" type="text" class="form-control " />  
    </div>  
</spring:bind>    
<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
        	<input type="submit" value="Update"/>
        </div>
</div>
         
</form:form>
</div>
</body>
</html>