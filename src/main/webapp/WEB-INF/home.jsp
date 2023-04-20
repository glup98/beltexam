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
    <title>Home</title>
</head>
<body>
    <div class="d-flex justify-content-between w-75">
        <h1>Welcome back, <c:out value="${waitstaff.name}"/></h1>
        <a href="/home/logout">Logout</a>
    </div>
    
        <!-- Tabla con todas las mesas del mesero logeado -->
        <table class="table table-hover">
            <thead>
                <tr>
                    <th scope="col">Guest Name</th>
                    <th scope="col"># Guests</th>
                    <th scope="col">Arrived at</th>
                    <th scope="col">Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${boards}" var="board">
                    <tr>
                        <th><c:out value="${board.guestName}"/></th>
                        <td><c:out value="${board.numberOfGuests}"/></td>
                        <td><c:out value="${board.createdAt}"/></td>
                        <td>
                            <!-- Boton eliminar -->
                            <form class="d-inline-block" action="/boards/delete/${board.id}" method="post">
                                <input type="hidden" name="_method" value="Delete">
                                <input type="submit" value="Finished">
                            </form>
                            <!-- Boton editar -->
                            <form class="d-inline-block" action="/boards/edit/${board.id}" method="get">
                                <input type="hidden" name="_method" value="get">
                                <input type="submit" value="Edit">
                            </form>
                            <a href="/boards/open/${board.id}">Give Up Table</a>
                        </td>                
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <a href="/boards/allboards">See Other Tables</a>
        <button type="button" class="btn btn-info"><a href="/boards/new" class="text-dark text-decoration-none">+ new table</a></button>
</body>
</html>