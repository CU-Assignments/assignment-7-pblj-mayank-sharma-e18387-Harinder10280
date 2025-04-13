import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if ("admin".equals(username) && "admin123".equals(password)) {
            request.setAttribute("username", username);
            RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
            rd.forward(request, response);
        } else {
            PrintWriter out = response.getWriter();
            out.println("<h3>Invalid username or password!</h3>");
        }
    }
}
