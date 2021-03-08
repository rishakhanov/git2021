<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<body>

<nav class="navbar fixed-top navbar-expand-lg navbar-light bg-light">
    <div class="container">
        <a href="homepageshow?userEmail=${user}" class="navbar-brand">KidsToys</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarContent"
                aria-controls="navbarContent" aria-expanded="false">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarContent">
            <ul class="navbar-nav me-auto mb-2">
                <li class="nav-item">
                    <a href="homepageshow?userEmail=${user}" class="nav-link"><fmt:message key="home"/></a>
                </li>

                <li class="nav-item dropdown">
                    <a href="#" class="nav-link dropdown-toggle" id="navDrop" role="button"
                       data-bs-toggle="dropdown" aria-expanded="false"><fmt:message key="toys"/></a>
                    <ul class="dropdown-menu" aria-labelledby="navDrop">
                        <li>
                            <a href="carsshow" class="dropdown-item"><fmt:message key="cars"/></a>
                        </li>
                        <li>
                            <a href="stuffedtoysshow" class="dropdown-item"><fmt:message key="stuffedtoys"/></a>
                        </li>
                        <li>
                            <a href="constructorsshow" class="dropdown-item"><fmt:message key="constructors"/></a>
                        </li>
                    </ul>
                </li>
            </ul>
            <div>
                ${user}
            </div>

            <div>
                <button class="btn btn-outline-success ms-2" data-bs-toggle="modal" data-bs-target="#exampleModal"><fmt:message key="signin"/></button>
            </div>
            <div>
                <button class="btn btn-outline-primary ms-2" data-bs-toggle="modal" data-bs-target="#exampleModalLogin"><fmt:message key="login"/></button>
            </div>
            <div>
                <form method="post" action="cartshow">
                    <input type="hidden" name="userEmail" value=${user}>
                    <button class="btn btn-outline-info ms-2" input type="submit"><fmt:message key="cart"/></button>
                </form>
            </div>
            <div>
                <form method="post" action="logout">
                    <button class="btn btn-outline-secondary ms-2" input type="submit"><fmt:message key="logout"/></button>
                </form>
            </div>
            <div>
                <form action="homepageshow" method="post">
                    <select name="ddlLanguage" class="choice-box ms-3">
                        <option value="en_US">English</option>
                        <option value="ru_RU">Russian</option>
                        <option value="es_ES">Spanish</option>
                    </select>
                    <input type="hidden" name="userEmail" value=${user}>
                    <input type="submit" class="btn ms-1" value="<fmt:message key="button"/>"/>
                </form>
            </div>
        </div>
    </div>
</nav>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel"><fmt:message key="registrationForm"/></h5>
                <button class="btn-close" data-bs-dismiss="modal" aria-label="close"></button>
            </div>
            <div class="modal-body">
                <form method="post" action="useradd">
                    <div class="row mb-2">
                        <label for="firstName" class="col-sm-3 col-form-label"><fmt:message key="firstName"/></label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" placeholder="First name" aria-label="First name" id="firstName" name="firstName" required>
                        </div>
                    </div>
                    <div class="row mb-2">
                        <label for="lastName" class="col-sm-3 col-form-label"><fmt:message key="lastName"/></label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" placeholder="Last name" aria-label="Last name" id="lastName" name="lastName" required>
                        </div>
                    </div>
                    <div class="row mb-2">
                        <label for="inputBirthday" class="col-sm-3 col-form-label"><fmt:message key="birthday"/></label>
                        <div class="col-sm-9">
                            <input type="date" class="form-control" placeholder="12/31/2000" aria-label="12/31/2000" id="inputBirthday" name="inputBirthday" required>
                        </div>
                    </div>
                    <div class="row mb-2">
                        <label for="inputIIN" class="col-sm-3 col-form-label"><fmt:message key="iin"/></label>
                        <div class="col-sm-9">
                            <input type="number" class="form-control" placeholder="123456789012" aria-label="123456789012" id="inputIIN" name="inputIIN" required>
                        </div>
                    </div>
                    <div class="row mb-2">
                        <label for="inputPhone" class="col-sm-3 col-form-label"><fmt:message key="phone"/></label>
                        <div class="col-sm-9">
                            <input type="number" class="form-control" placeholder="71234567890" aria-label="71234567890" id="inputPhone" name="inputPhone" required>
                        </div>
                    </div>
                    <div class="row mb-2">
                        <label for="inputEmail" class="col-sm-3 col-form-label"><fmt:message key="email"/></label>
                        <div class="col-sm-9">
                            <input type="email" class="form-control" id="inputEmail" name="inputEmail" required>
                        </div>
                    </div>
                    <div class="row mb-2">
                        <label for="inputAddress" class="col-sm-3 col-form-label"><fmt:message key="address"/></label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" placeholder="Delivery address" aria-label="Delivery address" id="inputAddress" name="inputAddress" required>
                        </div>
                    </div>
                    <div class="row mb-2">
                        <label for="inputPassword" class="col-sm-3 col-form-label"><fmt:message key="password"/></label>
                        <div class="col-sm-9">
                            <input type="password" class="form-control" id="inputPassword" name="inputPassword" required>

                        </div>
                    </div>
                    <fieldset>
                        <div class="row mb-2">
                            <div class="col-form-label col-sm-3"> </div>
                            <div class="col-sm-9">
                                <div class="form-check">
                                    <input type="checkbox" id="gridCheck" class="form-check-input" onclick="signFunction()">
                                    <label for="gridCheck" class="form-check-label">Show password</label>
                                </div>
                            </div>
                        </div>
                    </fieldset>
                    <div class="modal-footer">
                    <input type="submit" class="btn btn-secondary" value="Sign in"/>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>


<!-- Modal -->
<div class="modal fade" id="exampleModalLogin" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabelLogin"><fmt:message key="loginForm"/></h5>
                <button class="btn-close" data-bs-dismiss="modal" aria-label="close"></button>
            </div>
            <div class="modal-body">
                <form method="post" action="login">
                    <div class="row mb-2">
                        <label for="inputEmailLogin" class="col-sm-3 col-form-label"><fmt:message key="email"/></label>
                        <div class="col-sm-9">
                            <input type="email" class="form-control" id="inputEmailLogin" name="userEmail" required>
                        </div>
                    </div>
                    <div class="row mb-2">
                        <label for="inputPassLogin" class="col-sm-3 col-form-label"><fmt:message key="password"/></label>
                        <div class="col-sm-9">
                            <input type="password" class="form-control" id="inputPassLogin" name="inputLoginPassword" required>
                        </div>
                    </div>
                    <fieldset>
                        <div class="row mb-2">
                            <div class="col-form-label col-sm-3"> </div>
                            <div class="col-sm-9">
                                <div class="form-check">
                                    <input type="checkbox" id="gridCheckLogin" class="form-check-input" onclick="loginFunction()">
                                    <label for="gridCheckLogin" class="form-check-label"><fmt:message key="showPassword"/></label>
                                </div>
                            </div>
                        </div>
                    </fieldset>
                    <div class="modal-footer">
                        <input type="submit" id="submit" class="btn btn-secondary" value="Login" onclick="submitFunction()"/>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
    <script>
        function signFunction() {
            var x = document.getElementById("inputPassword");
            if (x.type === "password") {
            x.type = "text";
            } else {
            x.type = "password";
            }
        }
    </script>
    <script>
        function loginFunction() {
            var x = document.getElementById("inputPassLogin");
            if (x.type === "password") {
                x.type = "text";
            } else {
                x.type = "password";
            }
        }
    </script>


</body>
