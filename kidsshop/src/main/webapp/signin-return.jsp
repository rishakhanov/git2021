<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <meta name="veiwport" content="width=device-width, initial-scale=1.0">
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">

    <title>Sign in</title>
</head>
    <body>
    <c:set var="user" scope="application"><%=request.getAttribute("userEmail") %></c:set>
        <section id="signIn" class="text-center">
            <form class="form-inline" method="POST">
                <div class="form-group">
                    <h1 class="text-center">You are signed in to KidsStore!</h1>
                    <h1 class="text-center">Please use your email and password to login in the Home page.</h1>
                </div>
                <div class="form-group">
                    <a class="btn btn-success btn-lg" href="index.jsp" role="button">Home</a>
                </div>
            </form>
        </section>
    <!-- JavaScript Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
    </body>
</html>
