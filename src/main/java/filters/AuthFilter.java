package filters;

import DAO.UserDAO;
import models.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebFilter(filterName = "AuthFilter")
public class AuthFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        List<User> users = UserDAO.getInstance().getAllUsers();

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        PrintWriter out = resp.getWriter();
        boolean logged = false;
        for(User user: users) {
            if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
                logged = true;

                HttpServletRequest request = (HttpServletRequest) req;
                request.getSession().setMaxInactiveInterval(15*60);

                chain.doFilter(req, resp);
            }
        }

        if(!logged) {
            out.print("username or password error!");
            RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
            rd.include(req, resp);
        }


    }

    public void init(FilterConfig config) throws ServletException {

    }

}
