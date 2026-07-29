<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">

            <div class="card shadow">
                <div class="card-header bg-primary text-white text-center">
                    <h3>Register</h3>
                </div>

                <div class="card-body">

                    <form action="register" method="post">

                        <div class="mb-3">
                            <label class="form-label">Name</label>
                            <input
                                type="text"
                                class="form-control"
                                name="name"
                                placeholder="Enter Name"
                                required>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Email</label>
                            <input
                                type="email"
                                class="form-control"
                                name="email"
                                placeholder="Enter Email"
                                required>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Password</label>
                            <input
                                type="password"
                                class="form-control"
                                name="password"
                                placeholder="Enter Password"
                                required>
                        </div>

                        <div class="mb-3">
                            <label class="form-label d-block">Gender</label>

                            <div class="form-check form-check-inline">
                                <input
                                    class="form-check-input"
                                    type="radio"
                                    name="gender"
                                    id="male"
                                    value="Male"
                                    required>

                                <label class="form-check-label" for="male">
                                    Male
                                </label>
                            </div>

                            <div class="form-check form-check-inline">
                                <input
                                    class="form-check-input"
                                    type="radio"
                                    name="gender"
                                    id="female"
                                    value="Female">

                                <label class="form-check-label" for="female">
                                    Female
                                </label>
                            </div>

                        </div>

                        <div class="mb-3">
                            <label class="form-label">City</label>

                            <select class="form-select" name="city" required>

                                <option value="">Select City</option>
                                <option value="Mumbai">Mumbai</option>
                                <option value="Delhi">Delhi</option>
                                <option value="Chennai">Chennai</option>
                                <option value="Bangalore">Bangalore</option>
                                <option value="Hyderabad">Hyderabad</option>
                                <option value="Pune">Pune</option>

                            </select>

                        </div>

                        <div class="d-grid">

                            <button
                                type="submit"
                                class="btn btn-success">
                                Register
                            </button>

                        </div>

                    </form>

                    <div class="text-center mt-3">

                        Already have an account?

                        <a href="login.jsp">
                            Login Here
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
