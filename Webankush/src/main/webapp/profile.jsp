<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Successful</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<%
    String name = (String) session.getAttribute("user");
%>

<body style="background-color:#f8f9fa;">

    <div class="container">

        <!-- Navbar -->
        <nav class="navbar navbar-expand-sm navbar-light bg-light mt-3 rounded shadow-sm">
            <div class="container-fluid">

                <a class="navbar-brand" href="#">My Website</a>

                <div class="collapse navbar-collapse">

                    <ul class="navbar-nav me-auto">
                        <li class="nav-item">
                            <a class="nav-link active" href="home.jsp">Home</a>
                        </li>

                        <li class="nav-item">
                            <a class="nav-link" href="about.jsp">About</a>
                        </li>
                    </ul>

                    <!-- Logout Button -->
                    <form action="Logout" method="post">
                        <button type="submit" class="btn btn-danger">
                            Logout
                        </button>
                    </form>

                </div>

            </div>
        </nav>

        <!-- Success Message -->
        <div class="text-center mt-5">
            <h1 class="text-success">
                Welcome, <%= name %>!
            </h1>

            <h3 class="mt-3">
                Login Successful!
            </h3>
        </div>

    </div>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js"></script>

</body>

</html>
