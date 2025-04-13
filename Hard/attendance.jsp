<!DOCTYPE html>
<html>
<head>
    <title>Student Attendance Form</title>
</head>
<body>
    <h2>Student Attendance Portal</h2>
    <form action="AttendanceServlet" method="post">
        Student ID: <input type="text" name="studentId" required><br><br>
        Student Name: <input type="text" name="studentName" required><br><br>
        Date: <input type="date" name="date" required><br><br>
        Status:
        <select name="status">
            <option value="Present">Present</option>
            <option value="Absent">Absent</option>
        </select><br><br>
        <input type="submit" value="Submit Attendance">
    </form>
</body>
</html>
