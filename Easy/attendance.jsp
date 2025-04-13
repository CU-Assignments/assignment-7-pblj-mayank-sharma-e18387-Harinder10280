<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Attendance Form</title>
</head>
<body>
    <h2>Student Attendance Form</h2>
    <form action="AttendanceServlet" method="post">
        Student ID: <input type="text" name="studentId" required><br><br>
        Name: <input type="text" name="studentName" required><br><br>
        Date: <input type="date" name="date" required><br><br>
        Status: 
        <select name="status">
            <option value="Present">Present</option>
            <option value="Absent">Absent</option>
        </select><br><br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>
