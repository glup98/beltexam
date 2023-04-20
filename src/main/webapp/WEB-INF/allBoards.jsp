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
    <title>All Table</title>
</head>
<body>
    <div class="d-flex justify-content-between w-75">
        <h1>All Tables</h1>
        <a href="/home">Home</a>
    </div>
    
        <!-- Tabla con todas las mesas -->
        <table class="table table-hover">
            <thead>
                <tr>
                    <th scope="col">Guest Name</th>
                    <th scope="col"># Guests</th>
                    <th scope="col">Arrived at</th>
                    <th scope="col">Server</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${allBoards}" var="board">
                    <tr>
                        <th><c:out value="${board.guestName}"/></th>
                        <td><c:out value="${board.numberOfGuests}"/></td>
                        <td><c:out value="${board.createdAt}"/></td>
                        <td><c:out value="${board.waitstaff.name}"/></td>                
                    </tr>
                </c:forEach>
            </tbody>
        </table>
</body>
</html>