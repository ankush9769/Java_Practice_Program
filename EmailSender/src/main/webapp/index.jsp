<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Send Mail</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body style="background-color:#f8f9fa;">
    <div class="container mt-5">
        <div class="card shadow p-4 mx-auto" style="max-width: 600px;">
            <h2 class="text-center text-primary mb-4">
                Send Email
            </h2>
            <form action="SendMailServlet" method="post">
                <!-- To -->
                <div class="mb-3">
                    <label class="form-label">To:</label>
                    <input
                        type="email"
                        class="form-control"
                        name="to"
                        placeholder="Enter receiver email"
                        required>
                </div>
                <!-- Subject -->
                <div class="mb-3">
                    <label class="form-label">Subject:</label>
                    <input
                        type="text"
                        class="form-control"
                        name="subject"
                        placeholder="Enter email subject"
                        required>
                </div>
                <!-- Message -->
                <div class="mb-3">
                    <label class="form-label">Message:</label>
                    <textarea
                        class="form-control"
                        name="message"
                        rows="5"
                        placeholder="Enter your message"
                        required></textarea>
                </div>
                <!-- Button -->
                <div class="text-center">
                    <button type="submit" class="btn btn-primary">
                        Send Mail
                    </button>
                </div>
            </form>
        </div>
    </div>
    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
