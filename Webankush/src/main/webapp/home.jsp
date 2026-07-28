<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<%-- String name=(String)request.getAttribute("username");--%>
<% String name=(String)session.getAttribute("user");%>

   <body style="background-color:#f8f9fa;">

       <div class="container">

           <!-- Navbar -->
           <nav class="navbar navbar-expand-sm navbar-light bg-light mt-3 rounded shadow-sm">
               <div class="container-fluid">

                   <a class="navbar-brand" href="profile.jsp">My Website</a>

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


                   <h1 style="color:green; text-align:center; margin-top:100px;">
                       <%=name %> home page
                   </h1>


       </div>

       <!-- Bootstrap JS -->
       <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js"></script>

   </body>
</html>