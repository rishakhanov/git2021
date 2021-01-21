<body>

<nav class="navbar fixed-top navbar-expand-lg navbar-light bg-light">
    <div class="container">
        <a href="index.jsp" class="navbar-brand">KidsToys</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarContent"
                aria-controls="navbarContent" aria-expanded="false">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarContent">
            <ul class="navbar-nav me-auto mb-2">
                <li class="nav-item">
                    <a href="index.jsp" class="nav-link">Home</a>
                </li>

                <li class="nav-item dropdown">
                    <a href="#" class="nav-link dropdown-toggle" id="navDrop" role="button"
                       data-bs-toggle="dropdown" aria-expanded="false">Toys</a>
                    <ul class="dropdown-menu" aria-labelledby="navDrop">
                        <li><form method="post" action="carsshow">Cars
                            <input type="submit" value="Show"/>
                            </form>
                        </li>

                        <li><form method="post" action="stuffedtoysshow">Stuffed toys
                            <input type="submit" value="Show"/>
                        </form>
                        </li>

                        <li><form method="post" action="constructorsshow">Constructors
                            <input type="submit" value="Show"/>
                        </form>
                        </li>
                    </ul>
                </li>
            </ul>
            <div class="d-flex">
                <button class="btn btn-outline-success" data-bs-toggle="modal" data-bs-target="#exampleModal">Sign in</button>
                <button class="btn btn-outline-primary ms-3" data-bs-toggle="modal" data-bs-target="#exampleModalLogin">Login</button>
            </div>
            <div>

            </div>
        </div>
    </div>
</nav>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Registration form</h5>
                <button class="btn-close" data-bs-dismiss="modal" aria-label="close"></button>
            </div>
            <div class="modal-body">
                <form method="post" action="useradd">
                    <div class="row mb-2">
                        <label for="firstName" class="col-sm-3 col-form-label">First name</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" placeholder="First name" aria-label="First name" id="firstName" name="firstName">
                        </div>
                    </div>
                    <div class="row mb-2">
                        <label for="lastName" class="col-sm-3 col-form-label">Last name</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" placeholder="Last name" aria-label="Last name" id="lastName" name="lastName">
                        </div>
                    </div>
                    <div class="row mb-2">
                        <label for="inputBirthday" class="col-sm-3 col-form-label">Birthday</label>
                        <div class="col-sm-9">
                            <input type="date" class="form-control" placeholder="12/31/2000" aria-label="12/31/2000" id="inputBirthday" name="inputBirthday">
                        </div>
                    </div>
                    <div class="row mb-2">
                        <label for="inputIIN" class="col-sm-3 col-form-label">IIN</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" placeholder="123456789012" aria-label="123456789012" id="inputIIN" name="inputIIN">
                        </div>
                    </div>
                    <div class="row mb-2">
                        <label for="inputPhone" class="col-sm-3 col-form-label">Phone</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" placeholder="71234567890" aria-label="71234567890" id="inputPhone" name="inputPhone">
                        </div>
                    </div>
                    <div class="row mb-2">
                        <label for="inputEmail" class="col-sm-3 col-form-label">Email</label>
                        <div class="col-sm-9">
                            <input type="email" class="form-control" id="inputEmail" name="inputEmail">
                        </div>
                    </div>
                    <div class="row mb-2">
                        <label for="inputAddress" class="col-sm-3 col-form-label">Address</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" placeholder="Delivery address" aria-label="Delivery address" id="inputAddress" name="inputAddress">
                        </div>
                    </div>
                    <div class="row mb-2">
                        <label for="inputPassword" class="col-sm-3 col-form-label">Password</label>
                        <div class="col-sm-9">
                            <input type="password" class="form-control" id="inputPassword" name="inputPassword">
                        </div>
                    </div>
                    <fieldset>
                        <div class="row mb-2">
                            <div class="col-form-label col-sm-3">Checkbox</div>
                            <div class="col-sm-9">
                                <div class="form-check">
                                    <input type="checkbox" id="gridCheck" class="form-check-input">
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
                <h5 class="modal-title" id="exampleModalLabelLogin">Login form</h5>
                <button class="btn-close" data-bs-dismiss="modal" aria-label="close"></button>
            </div>
            <div class="modal-body">
                <form method="post" action="login">
                    <div class="row mb-2">
                        <label for="inputEmailLogin" class="col-sm-3 col-form-label">Email</label>
                        <div class="col-sm-9">
                            <input type="email" class="form-control" id="inputEmailLogin" name="inputEmail">
                        </div>
                    </div>
                    <div class="row mb-2">
                        <label for="inputPassLogin" class="col-sm-3 col-form-label">Password</label>
                        <div class="col-sm-9">
                            <input type="password" class="form-control" id="inputPassLogin" name="inputLoginPassword">
                        </div>
                    </div>
                    <fieldset>
                        <div class="row mb-2">
                            <div class="col-form-label col-sm-3">Checkbox</div>
                            <div class="col-sm-9">
                                <div class="form-check">
                                    <input type="checkbox" id="gridCheckLogin" class="form-check-input">
                                    <label for="gridCheckLogin" class="form-check-label">Show password</label>
                                </div>
                            </div>
                        </div>
                    </fieldset>
                    <div class="modal-footer">
                        <input type="submit" class="btn btn-secondary" value="Login"/>
                    </div>
                </form>
            </div>

        </div>
    </div>
</div>


</body>
