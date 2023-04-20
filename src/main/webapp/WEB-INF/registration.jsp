<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
    <title>Registration</title>
</head>
<body>
    <h1 class="d-flex justify-content-center">TableMaster</h1>
    <div class="d-flex justify-content-center">
        <form:form class="d-inline-block w-25 mx-3" action="/" method="post" modelAttribute="waitstaff">
            <h2>New Waitstaff</h2>
            <div class="mb-3">
                <form:label path="name" class="form-label">Name</form:label>
                <form:errors path="name"/>
                <form:input path="name" type="text" class="form-control"/>
            </div>
            <div class="mb-3">
                <form:label path="email" class="form-label">Email address</form:label>
                <form:errors path="email"/>
                <p><c:out value="${errorEmail}"/></p>
                <form:input path="email" type="email" class="form-control"/>
            </div>
            <div class="mb-3">
                <form:label path="password" class="form-label">Password</form:label>
                <form:errors path="password"/>
                <form:password path="password" class="form-control"/>
            </div>
            <div class="mb-3">
                <form:label path="passwordConfirmation" class="form-label">Confirm Password</form:label>
                <form:errors path="passwordConfirmation"/>
                <form:password path="passwordConfirmation" class="form-control"/>
            </div>
            <input type="submit" class="btn btn-info" value="Submit"/>
        </form:form>
        
        <form action="/login" method="post" class="d-inline-block align-top w-25 mx-3">
            <h2>Log in</h2>
            <p><c:out value="${errorLog}"/></p>
            <div class="mb-3">
                <label for="email" class="form-label">Email address</label>
                <input name="email" type="email" class="form-control"/>
            </div>
            <div class="mb-3">
                <label for="password" class="form-label">Password</label>
                <input name="password" type="password" class="form-control"/>
            </div>
            <input type="submit" class="btn btn-info" value="Submit"/>
        </form>
    </div>
</body>
</html>