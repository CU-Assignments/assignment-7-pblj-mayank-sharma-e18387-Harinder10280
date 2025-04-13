import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class AttendanceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String studentId = request.getParameter("studentId");
        String studentName = request.getParameter("studentName");
        String date = request.getParameter("date");
        String status = request.getParameter("status");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/attendance_db", "root", "your_password");

            PreparedStatement ps = con.prepareStatement("INSERT INTO attendance (student_id, student_name, date, status) VALUES (?, ?, ?, ?)");
            ps.setString(1, studentId);
            ps.setString(2, studentName);
            ps.setString(3, date);
            ps.setString(4, status);
            ps.executeUpdate();

            request.setAttribute("studentName", studentName);
            RequestDispatcher rd = request.getRequestDispatcher("attendance-success.jsp");
            rd.forward(request, response);
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
