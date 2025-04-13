import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class AttendanceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int studentId = Integer.parseInt(request.getParameter("studentId"));
        String studentName = request.getParameter("studentName");
        String date = request.getParameter("date");
        String status = request.getParameter("status");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/attendance_db", "root", "your_password");
            PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO attendance (student_id, student_name, date, status) VALUES (?, ?, ?, ?)");
            ps.setInt(1, studentId);
            ps.setString(2, studentName);
            ps.setString(3, date);
            ps.setString(4, status);
            ps.executeUpdate();

            request.setAttribute("studentName", studentName);
            RequestDispatcher rd = request.getRequestDispatcher("attendance-success.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
