<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <meta name="veiwport" content="width=device-width, initial-scale=1.0">
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-1.10.2.js"></script>


    <title>Cars</title>
</head>
<body>

    <!--Navigation bar-->
    <div id="nav-placeholder">

    </div>

    <script>
        $(function(){
            $("#nav-placeholder").load("navbar.jsp");
        });
    </script>-->
    <!--end of Navigation bar-->

    <!--images from folder C:\Program Files\Apache Software Foundation\Tomcat 9.0\webapps\uploaded_files-->
    <br><br><br><br>
    <div>
        <img src="http://localhost:8080/uploaded_files/bugatti.png">
        <button class="btn btn-outline-primary ms-3" data-bs-toggle="modal" data-bs-target="#exampleModalBugatti">Order (id=2)</button>
    <div>
        <img src="http://localhost:8080/uploaded_files/lamborghini.jpg">
        <button class="btn btn-outline-primary ms-3" data-bs-toggle="modal" data-bs-target="#exampleModalBugatti">Order (id=1)</button>
    </div>
    <div>
        <img src="http://localhost:8080/uploaded_files/monstertrack.jpg">
        <button class="btn btn-outline-primary ms-3" data-bs-toggle="modal" data-bs-target="#exampleModalBugatti">Order (id=3)</button>
    </div>
    <div>
        <img src="http://localhost:8080/uploaded_files/tractor.jpg">
        <button class="btn btn-outline-primary ms-3" data-bs-toggle="modal" data-bs-target="#exampleModalBugatti">Order (id=4)</button>
    </div>
    <footer class="pt-1 my-md-1 pt-md-1 border-top">
        <div class="row">
            <div class="mx-auto" style="width: 200px">
                <h5>KidsToys</h5>
                ${user}

            </div>
        </div>
    </footer>

    <!-- Modal -->
    <div class="modal fade" id="exampleModalBugatti" tabindex="-1" aria-labelledby="exampleModalBugatti" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Order form</h5>
                    <button class="btn-close" data-bs-dismiss="modal" aria-label="close"></button>
                </div>
                <div class="modal-body">
                    <form method="post" action="buycar">
                        <div class="row mb-2">
                            <label for="id" class="col-sm-3 col-form-label">id</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" placeholder="id" aria-label="id" id="id" name="productId">
                            </div>
                        </div>
                        <div class="row mb-2">
                            <label for="Quantity" class="col-sm-3 col-form-label">Quantity</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" placeholder="Quantity" aria-label="Quantity" id="Quantity" name="quantity">
                            </div>
                        </div>
                        <div class="row mb-2">
                            <label for="inputEmail" class="col-sm-3 col-form-label">Email</label>
                            <div class="col-sm-9">
                                <input type="email" class="form-control" id="inputEmail" name="inputEmail">
                            </div>
                        </div>
                        <div class="modal-footer">
                            <input type="submit" class="btn btn-secondary" value="Order"/>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>

</body>
  </html>
