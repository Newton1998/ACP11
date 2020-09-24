package Example;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Objects;

public class Registration extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        if(!Objects.isNull(login) && !Objects.isNull(password)) {
            Cookie cookieLogin = new Cookie("login", login);
            Cookie cookiePass = new Cookie("password", password);
            resp.addCookie(cookieLogin);
            resp.addCookie(cookiePass);
            resp.sendRedirect("index.jsp");
        } else {
            req.getRequestDispatcher("/WEB-INF/error.jsp").forward(req,resp);
        }
    }

    public void destroy() {

    }
}
