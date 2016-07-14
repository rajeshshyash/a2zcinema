<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>User Information</title>
    <!-- Bootstrap CSS -->
    <%-- <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet"> --%>    
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <style type="text/css">
        .myrow-container{
            margin: 0px;
        }
    </style>
</head>
<body class=".container-fluid">
    <div class="myrow-container">
        <div class="panel panel-success">
            <div class="panel-heading">
                <h3 class="panel-title">
                    User Details
                </h3>
            </div>
            <div class="panel-body">
                <form:form id="userRegisterForm" cssClass="form-horizontal" modelAttribute="user" method="post" action="saveUser">
    
    				<div class="form-group">
                        <form:label path="firstName" cssClass="control-label col-xs-3"></form:label>
                        <div class="col-xs-2">
                            <form:input cssClass="form-control" placeholder="First Name" path="firstName" value="${userObject.firstName}"/>
                        </div>
                        <%-- <form:label path="lastName" cssClass="control-label col-xs-3"></form:label> --%>
                        <div class="col-xs-2">
                            <form:input cssClass="form-control" placeholder="Last Name" path="lastName" value="${userObject.lastName}"/>
                        </div>
                    </div>
                    
                    <div class="form-group">
                        <div class="control-label col-xs-3"> <form:label path="userName" ></form:label> </div>
                        <div class="col-xs-4">
                            <form:hidden path="userId" value="${userObject.userId}"/>
                            <form:input cssClass="form-control" placeholder="User Name" path="userName" value="${userObject.userName}"/>
                        </div>
                    </div>
    
                    <div class="form-group">
                        <form:label path="emailId" cssClass="control-label col-xs-3"></form:label>
                        <div class="col-xs-4">
                            <form:input cssClass="form-control" placeholder="Email" path="emailId" value="${userObject.emailId}"/>
                        </div>
                    </div>
                    
                    <div class="form-group">
                        <form:label path="mobile" cssClass="control-label col-xs-3"></form:label>
                        <div class="col-xs-4">
                            <form:input cssClass="form-control"  placeholder="Mobile" path="mobile" value="${userObject.mobile}"/>
                        </div>
                    </div>
                    
                    <div class="form-group">
                        <form:label path="password" cssClass="control-label col-xs-3"></form:label>
                        <div class="col-xs-4">
                            <form:input cssClass="form-control" placeholder="Password" path="password" value="${userObject.password}" type="password"/>
                        </div>
                    </div>
                    
                    <div class="form-group">
                        <form:label path="rePassword" cssClass="control-label col-xs-3"></form:label>
                        <div class="col-xs-4">
                            <form:input cssClass="form-control" placeholder="Re-password" path="rePassword" value="${userObject.rePassword}" type="password"/>
                        </div>
                    </div>
    
                    <div class="form-group">
                        <div class="row">
                            <div class="col-xs-4">
                            </div>
                            <div class="col-xs-4">
                                <input type="submit" id="saveUser" class="btn btn-primary" value="Save" onclick="return submitUserForm();"/>
                            </div>
                            <div class="col-xs-4">
                            </div>
                        </div>
                    </div>
    
                </form:form>
            </div>
        </div>
    </div>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	
	<script type="text/javascript">
		function submitUserForm() {				
			
		    // getting the employee form values
		    var userName = $('#userName').val();
		    var firstName = $('#firstName').val();
		    var lastName = $('#lastName').val();
		    var emailId = $('#emailId').val();
		    var mobile = $('#mobile').val();
		    var password = $('#password').val(); 
		    var rePassword = $('#rePassword').val();
		    
		    if(userName.length ==0) {
		        alert('Please enter userName');
		        $('#userName').focus();
		        return false;
		    }
	
		    if(firstName.length ==0) {
		        alert('Please enter firstName');
		        $('#firstName').focus();
		        return false;
		    }

		    if(lastName.length ==0) {
		        alert('Please enter lastName');
		        $('#lastName').focus();
		        return false;
		    }
		    
		    if(emailId.length ==0) {
		        alert('Please enter emailId');
		        $('#emailId').focus();
		        return false;
		    }
		    
		    if(mobile.length ==0) {
		        alert('Please enter mobile');
		        $('#mobile').focus();
		        return false;
		    }
		    
		    if(password.length ==0) {
		        alert('Please enter password');
		        $('#password').focus();
		        return false;
		    }
		    
		   if(rePassword.length ==0) {
		        alert('Please enter rePassword');
		        $('#rePassword').focus();
		        return false;
		    }
		    
		    if (password != rePassword){
		    	alert('Passwords do not match!');
		    	return false;
		    }else{
		    	alert('Passwords match.'); 
		    }
		    return true;
		};	
	</script>

</body>
</html>