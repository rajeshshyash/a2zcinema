<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>User List</title>
    <!-- Bootstrap CSS -->
    <%-- <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet"> --%>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">
    <style type="text/css">
        .myrow-container {
            margin: 0px;
        }
        
    </style>
</head>
<body class=".container-fluid">
<div class="myrow-container">
    <div class="panel panel-success">
        <div class="panel-heading">
            <h3 class="panel-title">
                <div align="left"><b>User List</b> </div>
                <div align="center"><a href="userRegister">Register</a></div>
            </h3>
        </div>
        <div class="panel-body">
            <c:if test="${empty userList}">
                There are no Employees
            </c:if>
            <c:if test="${not empty userList}">   
            
            	<form action="searchUser">
            		<div class="row">
					  <div class="col-md-3">Search User: <input type='text' name='searchName' id='searchName'/> </div>
					  <input class="btn btn-success" type='submit' value='Search'/></div>
					</div>
            	</form>         	
            	            	
                <table class="table table-hover table-bordered">
                    <thead style="background-color: #bce8f1;">
                    <tr>
                        <th>UserId</th>
                        <th>UserName</th>
                        <th>FirstName</th>
                        <th>LastName</th>
                        <th>Email</th>
                        <th>Phone</th>
                        <th>Edit</th>
                        <th>Delete</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${userList}" var="userdata">
                        <tr>
                        	<th><c:out value="${userdata.userId}"/></th>
                        	<th><c:out value="${userdata.userName}"/></th>
                        	<th><c:out value="${userdata.firstName}"/></th>
                        	<th><c:out value="${userdata.lastName}"/></th> 
                        	<th><c:out value="${userdata.emailId}"/></th> 
                        	<th><c:out value="${userdata.mobile}"/></th>
                        	<th><a href="editUser?id=<c:out value='${userdata.userId}'/>"><i class="fa fa-edit"></i> </a></th>
                        	<th><a href="deleteUser?id=<c:out value='${userdata.userId}'/>"><i class="fa fa-trash-o"></i></a></th>  
                        	
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:if>
        </div>
    </div>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>    
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    
    <%-- <script src="<c:url value="/resources/js/jquery-2.1.3.js"/>"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
     --%>

</body>
</html>