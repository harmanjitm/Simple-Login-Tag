package servlets;

import domain.UserService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 758243
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {  
        if(request.getSession().getAttribute("userName") == null)
        {
            Cookie[] cookies = request.getCookies();
            for(int i=0;i<cookies.length;i++)
            {
                if(cookies[i].getName().equals("username"))
                {
                    request.setAttribute("userName", cookies[i].getValue());
                    request.setAttribute("rememberMe", "checked");
                }
            }
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
        else
        {
            response.sendRedirect("home");
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = request.getParameter("userName");
        String password = request.getParameter("password");
        UserService usr = new UserService();
        
        if(username.equals("") || username == null || password.equals("") || password == null || (usr.login(username, password)==null))
        {
            request.setAttribute("invalidLogin", "Invalid login");
            request.setAttribute("${userName}", username);
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
        else
        {
            session.setAttribute("userName", username);
            if(request.getParameter("rememberMe") != null)
            {
                Cookie c = new Cookie("username", username);
                response.addCookie(c);
            }
            else
            {
                Cookie[] cookies = request.getCookies();
                for(Cookie c : cookies)
                {
                    if(c.getName().equals("username"))
                    {
                        c.setMaxAge(0);
                        response.addCookie(c);
                    }
                }
            }
            response.sendRedirect("home");
        }
        
    }
}
