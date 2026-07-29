<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
    String name = (String) session.getAttribute("user");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

</head>

<body class="bg-light">

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">

            <div class="card shadow text-center">
                <div class="card-header bg-primary text-white">
                    <h2>Welcome</h2>
                </div>

                <div class="card-body">

                    <h3>Hello, <%= name %>!</h3>

                    <p class="mt-3">
                        You have successfully logged in.
                    </p>

                    <a href="Logout" class="btn btn-danger">
                        Logout
                    </a>

                </div>
            </div>

        </div>
    </div>
</div>

</body>
</html>
