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
    <title>Edit Board</title>
</head>
<body>
    <div class="d-flex justify-content-between w-75">
        <h1>New Table</h1>
        <a href="/home/logout">Logout</a>
    </div>
    <form:form class="d-inline-block" action="/boards/edit/${board.id}" method="post" modelAttribute="board">
        <input type="hidden" name="_method" value="put">
        <div class="mb-3">
            <form:label path="guestName" class="form-label">Guest Name</form:label>
            <form:errors path="guestName"/>
            <form:input path= "guestName" type="text" class="form-control"/>
        </div>
        <div class="mb-3">
            <form:select class="form-control-sm form-select" path="numberOfGuests">
                <form:option value="1" label="1"/>
                <form:option value="2" label="2"/>
                <form:option value="3" label="3"/>
                <form:option value="4" label="4"/>
                <form:option value="5" label="5"/>
                <form:option value="6" label="6"/>
                <form:option value="7" label="7"/>
                <form:option value="8" label="8"/>
                <form:option value="9" label="9"/>
                <form:option value="10" label="10"/>
            </form:select>
        </div>
        </div>
        <div class="mb-3">
            <form:label path="note" class="form-label">Notes</form:label>
            <form:errors path="note"/>
            <form:textarea path="note" class="form-control"></form:textarea>
            </div>
            <button type="button" class="btn btn-danger"><a href="/home" class="text-white text-decoration-none">Cancel</a></button> <input type="submit" class="btn btn-info" value="Submit"/>
    </form:form>
    <form class="d-inline-block" action="/boards/delete/${board.id}" method="post">
        <input type="hidden" name="_method" value="Delete">
        <input type="submit" value="Delete Table">
    </form>
</body>
</html>