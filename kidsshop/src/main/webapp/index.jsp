<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
    <head>
        <meta charset="UTF-8"/>
        <meta name="veiwport" content="width=device-width, initial-scale=1.0">
        <!-- CSS only -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
        <link rel="stylesheet" href="style.css">
        <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
        <title>KidsShop</title>
    </head>
    <!--<body style="height: 6000px">-->
    <body>

    <!--Navigation bar-->
        <div id="nav-placeholder">

        </div>

        <<script>
            $(function(){
                $("#nav-placeholder").load("navbar.jsp");
            });
        </script>
        <!--end of Navigation bar-->

    <!-- Modal -->
        <main>
            <div class="carousel slide" id="carouselControls" data-bs-ride="carousel">
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img class="d-block w-100" src="https://images.pexels.com/photos/163696/toy-car-toy-box-mini-163696.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940" alt="">
                    </div>
                    <div class="carousel-item">
                        <img class="d-block w-100" src="https://images.pexels.com/photos/4887083/pexels-photo-4887083.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940" alt="">
                    </div>
                    <div class="carousel-item">
                        <img class="d-block w-100" src="https://images.pexels.com/photos/6129704/pexels-photo-6129704.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940" alt="">
                    </div>
                </div>
                <a class="carousel-control-prev" role="button" href="#carouselControls" data-bs-slide="prev">
                    <span class="carousel-control-prev-icon"></span>
                </a>
                <a class="carousel-control-next" role="button" href="#carouselControls" data-bs-slide="next">
                    <span class="carousel-control-next-icon"></span>
                </a>
            </div>
        </main>
        <footer class="pt-1 my-md-1 pt-md-1 border-top">
            <div class="row">
                <div class="mx-auto" style="width: 200px">
                    <h5>KidsToys</h5>
                    ${user}
                </div>
            </div>
        </footer>


    <!-- JavaScript Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
    </body>
</html>
