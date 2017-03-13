<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="../header.jsp" />
    <body>
    <div class="">
    <jsp:include page="../menu.jsp" />
        <h3>Please enter the correct details</h3>
        <table class="table table-striped">
        
           <c:forEach items="${alluser}" var="usr">
           <spring:url value="/users/${usr.user_id}" var="updateUrl" /> 
           <spring:url value="/users/${usr.user_id}/delete" var="deleteUrl" /> 
				<tr>
					<td>${usr.firstname} </td>
					<td>${usr.mobile}</td>
					<td><button class="btn btn-primary" onclick="location.href='${updateUrl}'">Update</button>
					<td><button class="btn btn-primary" onclick="location.href='${deleteUrl}'">Delete</button>
				</tr>
			</c:forEach>
		</table>
		<button class="btn btn-primary" onclick="location.href='register'">Add User</button>
		</div>
    </body>
 
</html>