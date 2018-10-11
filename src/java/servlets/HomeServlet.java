package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 758243
 */
public class HomeServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession username = request.getSession();
        
        if(!(request.getParameter("logout") == null))
        {
            username.setAttribute("userName", null);
            request.setAttribute("invalidLogin", "You have successfully logged out.");
            request.getSession().invalidate();
            response.sendRedirect("login");
            //request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
        else if(username.getAttribute("userName") == null)
        {
            response.sendRedirect("login");
        }
        else if(!(username.getAttribute("userName") == null))
        {
            request.getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
