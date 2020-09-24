package HelloExample;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Registration extends HttpServlet {

    private Map<String,String> db = new TreeMap<>();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login = String.valueOf(request.getParameter("login"));
        String password = String.valueOf(request.getParameter("password"));

        db.put(login,password);
        response.sendRedirect("index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        if(db.get(login) != null && db.get(login).equals(password)) {
            HttpSession session = req.getSession(true);
            session.setAttribute("inSystem", true);
            session.setAttribute("login", login);
            resp.sendRedirect("index.jsp");
        } else {
            req.getRequestDispatcher("/WEB-INF/error.jsp").forward(req,resp);
        }
    }

    public void destroy() {
    }
}
