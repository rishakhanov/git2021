<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
    <head>
        <meta charset="UTF-8"/>
        <meta name="veiwport" content="width=device-width, initial-scale=1.0">
        <!-- CSS only -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
        <!--<link rel="stylesheet" href="style.css">-->
        <link type="text/css" rel="stylesheet" href="style2.css">
        <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
        <title>Cart</title>
    </head>
    <body>
        <h2>Cart</h2>

        Welcome ${user}

        <div id="container">
            <div>
                <form method="post" action="homepageshow">
                    <input type="hidden" name="userEmail" value=${user}>
                    <input type="submit" class="btn btn-secondary" value="Home"/>
                </form>
            </div>
            <div>
                <form method="post" action="logout">
                    <input type="submit" class="btn btn-secondary" value="Logout"/>
                </form>
            </div>
        </div>

        <div id="wrapper">
            <div id="header">
                <h2>Products</h2>
            </div>
        </div>
        <br><br>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <form method="post" action="cartshow">
                <input type="hidden" name="userEmail" value=${user}>
                <input type="submit" class="add-product-button" value="Show cart"/>
            </form>
            <button class="add-product-button ms-3" data-bs-toggle="modal" data-bs-target="#exampleModal">Delete order item</button>
        </nav>

        <div id="container">
            <div id="content">
                <table>
                    <tr>
                        <th>order id</th>
                        <th>order item id</th>
                        <th>date</th>
                        <th>name</th>
                        <th>quantity</th>
                        <th>price</th>
                        <th>totalCost</th>
                        <th>status</th>
                    </tr>

                    <c:forEach var="cartItem" items="${cartList}">
                        <tr>
                            <td>${cartItem.orderId}</td>
                            <td>${cartItem.itemId}</td>
                            <td>${cartItem.date}</td>
                            <td>${cartItem.name}</td>
                            <td>${cartItem.quantity}</td>
                            <td>${cartItem.price}</td>
                            <td>${cartItem.totalCost}</td>
                            <td>${cartItem.status}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>


        <!-- Modal -->
        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel"></h5>
                        <button class="btn-close" data-bs-dismiss="modal" aria-label="close"></button>
                    </div>
                    <div class="modal-body">
                        <form method="post" action="deleteorderitem">
                            <div class="row mb-2">
                                <label for="orderItemId" class="col-sm-3 col-form-label">Item id</label>
                                <div class="col-sm-9">
                                    <input type="number" class="form-control" placeholder="Order item id" aria-label="Category id" id="orderItemId" name="orderItemId" required>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <input type="submit" class="btn btn-secondary" value="Submit"/>
                            </div>
                            <input type="hidden" name="userEmail" value=${user}>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <!-- JavaScript Bundle with Popper -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
    </body>
</html>
