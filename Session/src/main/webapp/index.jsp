<!doctype html>
<html lang="en" data-bs-theme="light">
<head>
    <title>Student Form</title>

    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link
        href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css"
        rel="stylesheet"
        integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB"
        crossorigin="anonymous">
</head>

<body>

    <header>
    </header>

    <main>

        <div class="container border rounded shadow-sm p-4 mt-5" style="width: 60%;">

            <h3 class="text-center mb-4">Student Form</h3>

            <form action="servlet1" method="get">

                <div class="mb-3">
                    <label class="form-label">Name</label>
                    <input
                        type="text"
                        class="form-control"
                        name="name"
                        placeholder="Enter your name"
                        required>
                </div>

                <button type="submit" class="btn btn-primary">
                    Submit
                </button>

            </form>

        </div>

    </main>

    <footer>
    </footer>

    <!-- Bootstrap JavaScript -->
    <script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI"
        crossorigin="anonymous"></script>

</body>
</html>
