import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class EmployeeServlet extends HttpServlet {
    private String dbUrl;
    private String dbUser;
    private String dbPassword;

    public void init() {
        try (InputStream input = getServletContext().getResourceAsStream("/WEB-INF/db-config.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            dbUrl = prop.getProperty("db.url");
            dbUser = prop.getProperty("db.username");
            dbPassword = prop.getProperty("db.password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<String> employees = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM employees")) {

            while (rs.next()) {
                String emp = "ID: " + rs.getInt("id") +
                             ", Name: " + rs.getString("name") +
                             ", Department: " + rs.getString("department") +
                             ", Email: " + rs.getString("email");
                employees.add(emp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h2>Employee List</h2>");
        for (String emp : employees) {
            out.println("<p>" + emp + "</p>");
        }
        out.println("<a href='employeeList.html'>Back to Menu</a>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String empId = request.getParameter("empId");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM employees WHERE id = ?")) {
            ps.setInt(1, Integer.parseInt(empId));

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                out.println("<h2>Employee Found</h2>");
                out.println("<p>ID: " + rs.getInt("id") + "</p>");
                out.println("<p>Name: " + rs.getString("name") + "</p>");
                out.println("<p>Department: " + rs.getString("department") + "</p>");
                out.println("<p>Email: " + rs.getString("email") + "</p>");
            } else {
                out.println("<h2>No Employee Found with ID: " + empId + "</h2>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        out.println("<a href='employeeList.html'>Back to Menu</a>");
    }
}
