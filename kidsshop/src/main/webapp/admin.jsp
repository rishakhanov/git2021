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
        <title>Admin</title>
    </head>
    <body>
        <h2>Admin service</h2>

        Welcome <%=request.getAttribute("userEmail") %>


            <form method="post" action="logout">
               <!-- <div class="modal-footer">-->
                    <input type="submit" class="btn btn-secondary" value="Logout"/>
              <!--  </div>-->
            </form>


        <div id="wrapper">
            <div id="header">
                <h2>Products</h2>
            </div>
        </div>
        <br><br>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <!--<div class="container">-->
                <form method="post" action="productsshow">
                    <input type="submit" class="add-product-button" value="Show products"/>
                </form>

                    <button class="add-product-button ms-3" data-bs-toggle="modal" data-bs-target="#exampleModal">Add product</button>
                    <button class="add-product-button ms-3" data-bs-toggle="modal" data-bs-target="#exampleModalUpdate">Update product</button>

            <!--</div>-->
        </nav>

        <div id="container">
            <div id="content">
                <table>
                    <tr>
                        <th>id</th>
                        <th>name</th>
                        <th>categoryId</th>
                        <th>category</th>
                        <th>sectionId</th>
                        <th>section</th>
                        <th>brandId</th>
                        <th>brand</th>
                        <th>price</th>
                        <th>quantity</th>
                        <th>details</th>
                    </tr>

                    <c:forEach var="productItem" items="${productList}">
                        <tr>
                            <td>${productItem.id}</td>
                            <td>${productItem.name}</td>
                            <td>${productItem.categoryId}</td>
                            <td>${productItem.category}</td>
                            <td>${productItem.sectionId}</td>
                            <td>${productItem.section}</td>
                            <td>${productItem.brandId}</td>
                            <td>${productItem.brand}</td>
                            <td>${productItem.price}</td>
                            <td>${productItem.quantity}</td>
                            <td>${productItem.details}</td>
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
                        <h5 class="modal-title" id="exampleModalLabel">Add new product form</h5>
                        <button class="btn-close" data-bs-dismiss="modal" aria-label="close"></button>
                    </div>
                    <div class="modal-body">
                        <form method="post" action="productadd">
                            <div class="row mb-2">
                                <label for="productName" class="col-sm-3 col-form-label">Name</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" placeholder="Product name" aria-label="Product name" id="productName" name="productName">
                                </div>
                            </div>
                            <div class="row mb-2">
                                <label for="categoryId" class="col-sm-3 col-form-label">Category id</label>
                                <div class="col-sm-9">
                                    <input type="number" class="form-control" placeholder="Category id" aria-label="Category id" id="categoryId" name="categoryId">
                                </div>
                            </div>
                            <div class="row mb-2">
                                <label for="sectionId" class="col-sm-3 col-form-label">Section id</label>
                                <div class="col-sm-9">
                                    <input type="number" class="form-control" placeholder="Section id" aria-label="Section id" id="sectionId" name="sectionId">
                                </div>
                            </div>
                            <div class="row mb-2">
                                <label for="brandId" class="col-sm-3 col-form-label">Brand id</label>
                                <div class="col-sm-9">
                                    <input type="number" class="form-control" placeholder="Brand id" aria-label="Brand id" id="brandId" name="brandId">
                                </div>
                            </div>
                            <div class="row mb-2">
                                <label for="price" class="col-sm-3 col-form-label">Price</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" placeholder="Price" aria-label="Price" id="price" name="price">
                                </div>
                            </div>
                            <div class="row mb-2">
                                <label for="quantity" class="col-sm-3 col-form-label">Quantity</label>
                                <div class="col-sm-9">
                                    <input type="number" class="form-control" placeholder="Quantity" aria-label="Quantity" id="quantity" name="quantity">
                                </div>
                            </div>
                            <div class="row mb-2">
                                <label for="details" class="col-sm-3 col-form-label">Details</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" placeholder="Details" aria-label="Details" id="details" name="details">
                                </div>
                            </div>
                            <div class="modal-footer">
                                <input type="submit" class="btn btn-secondary" value="Submit"/>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>


        <!-- Modal -->
        <div class="modal fade" id="exampleModalUpdate" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleUpdateLabel">Update product form</h5>
                        <button class="btn-close" data-bs-dismiss="modal" aria-label="close"></button>
                    </div>
                    <div class="modal-body">
                        <form method="post" action="productupdate">
                            <div class="row mb-2">
                                <label for="productIdUpd" class="col-sm-3 col-form-label">id</label>
                                <div class="col-sm-9">
                                    <input type="number" class="form-control" placeholder="Product id" aria-label="Product id" id="productIdUpd" name="productId">
                                </div>
                            </div>
                            <div class="row mb-2">
                                <label for="productName" class="col-sm-3 col-form-label">Name</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" placeholder="Product name" aria-label="Product name" id="productNameUpd" name="productName">
                                </div>
                            </div>
                            <div class="row mb-2">
                                <label for="categoryId" class="col-sm-3 col-form-label">Category id</label>
                                <div class="col-sm-9">
                                    <input type="number" class="form-control" placeholder="Category id" aria-label="Category id" id="categoryIdUpd" name="categoryId">
                                </div>
                            </div>
                            <div class="row mb-2">
                                <label for="sectionId" class="col-sm-3 col-form-label">Section id</label>
                                <div class="col-sm-9">
                                    <input type="number" class="form-control" placeholder="Section id" aria-label="Section id" id="sectionIdUpd" name="sectionId">
                                </div>
                            </div>
                            <div class="row mb-2">
                                <label for="brandId" class="col-sm-3 col-form-label">Brand id</label>
                                <div class="col-sm-9">
                                    <input type="number" class="form-control" placeholder="Brand id" aria-label="Brand id" id="brandIdUpd" name="brandId">
                                </div>
                            </div>
                            <div class="row mb-2">
                                <label for="price" class="col-sm-3 col-form-label">Price</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" placeholder="Price" aria-label="Price" id="priceUpd" name="price">
                                </div>
                            </div>
                            <div class="row mb-2">
                                <label for="quantity" class="col-sm-3 col-form-label">Quantity</label>
                                <div class="col-sm-9">
                                    <input type="number" class="form-control" placeholder="Quantity" aria-label="Quantity" id="quantityUpd" name="quantity">
                                </div>
                            </div>
                            <div class="row mb-2">
                                <label for="details" class="col-sm-3 col-form-label">Details</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" placeholder="Details" aria-label="Details" id="detailsUpd" name="details">
                                </div>
                            </div>
                            <div class="modal-footer">
                                <input type="submit" class="btn btn-secondary" value="Submit"/>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>

    <!-- JavaScript Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
    </body>
</html>
