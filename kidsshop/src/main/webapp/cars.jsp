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
        <button class="btn btn-outline-primary ms-3" data-bs-toggle="modal" data-bs-target="#exampleModalBugatti" onclick="submitFunction(2)">Bugatti, $12</button>
    </div>
    <div>
        <img src="http://localhost:8080/uploaded_files/lamborghini.jpg">
        <button class="btn btn-outline-primary ms-3" data-bs-toggle="modal" data-bs-target="#exampleModalBugatti" onclick="submitFunction(1)">Lamborghini, $12</button>
    </div>
    <div>
        <img src="http://localhost:8080/uploaded_files/monstertrack.jpg">
        <button class="btn btn-outline-primary ms-3" data-bs-toggle="modal" data-bs-target="#exampleModalBugatti" onclick="submitFunction(3)">Monstertrack, $15</button>
    </div>
    <div>
        <img src="http://localhost:8080/uploaded_files/tractor.jpg">
        <button class="btn btn-outline-primary ms-3" data-bs-toggle="modal" data-bs-target="#exampleModalBugatti" onclick="submitFunction(4)">Tractor, $9</button>
    </div>
    <footer class="pt-1 my-md-1 pt-md-1 border-top">
        <div class="row">
            <div class="mx-auto" style="width: 200px">
                <h5>KidsToys</h5>
            </div>
        </div>
    </footer>

    <!-- Modal -->
    <div class="modal fade" id="exampleModalBugatti" tabindex="-1" aria-labelledby="exampleModalBugatti" aria-hidden="true" data-carId="carId">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Order form</h5>
                    <button class="btn-close" data-bs-dismiss="modal" aria-label="close"></button>
                </div>
                <div class="modal-body">
                    <form method="post" action="buycar">
                        <div class="row mb-2">
                            <label for="Quantity" class="col-sm-3 col-form-label">Quantity</label>
                            <div class="col-sm-9">
                                <input type="number" class="form-control" placeholder="Quantity" aria-label="Quantity" id="Quantity" name="quantity" required>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <input type="hidden" id="carId"  name="carId" value=""/>
                            <input type="hidden" name="jspName" value="/cars.jsp">
                            <input type="hidden" name="userEmail" value=${user}>
                            <input type="submit" class="btn btn-secondary" value="Order"/>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <script>
        function submitFunction(id) {
            $(".modal-footer #carId").val(id);
        }
    </script>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>

</body>
  </html>
