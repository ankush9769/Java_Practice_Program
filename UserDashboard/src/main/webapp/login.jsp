<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-5">

            <div class="card shadow">

                <div class="card-header bg-primary text-white text-center">
                    <h3>Login</h3>
                </div>

                <div class="card-body">

                    <form action="Login" method="post">

                        <div class="mb-3">

                            <label class="form-label">
                                Email
                            </label>

                            <input
                                type="email"
                                class="form-control"
                                name="email"
                                placeholder="Enter Email"
                                required>

                        </div>

                        <div class="mb-3">

                            <label class="form-label">
                                Password
                            </label>

                            <input
                                type="password"
                                class="form-control"
                                name="password"
                                placeholder="Enter Password"
                                required>

                        </div>

                        <div class="d-grid">

                            <button
                                type="submit"
                                class="btn btn-success">
                                Login
                            </button>

                        </div>

                    </form>

                    <div class="text-center mt-3">

                        Don't have an account?

                        <a href="register.jsp">
                            Register Here
                        </a>

                    </div>

                </div>

            </div>

        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
