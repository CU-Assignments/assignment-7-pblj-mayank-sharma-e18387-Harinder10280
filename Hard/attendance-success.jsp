<!DOCTYPE html>
<html>
<head>
    <title>Attendance Submitted</title>
</head>
<body>
    <h2>Attendance Submitted Successfully!</h2>
    <p>Thank you, <strong><%= request.getAttribute("studentName") %></strong>.</p>
    <a href="attendance.jsp">Submit Another</a>
</body>
</html>
