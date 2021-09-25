package Controller;

import Dao.Data;
import Dao.Profile;
import Model.Search;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashSet;

@WebServlet("/StartP")
public class StartController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final HttpSession session = req.getSession();
        Data UserList = (Data) session.getAttribute("UserList");

        try {

            String name = req.getParameter("name");
            String pass = req.getParameter("password");

            if (name != null && UserList.findUser(name).getPassword().equals(pass)) {
                session.setAttribute("name", name);
            } else {
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/UserAuth.jsp");
                requestDispatcher.forward(req, resp);
            }
        }catch (Exception r){
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/UserAuth.jsp");
            requestDispatcher.forward(req, resp);
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/StartPage.jsp");
        requestDispatcher.forward(req, resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final HttpSession session = req.getSession();
        if (session.getAttribute("name") == null) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/UserAuth.jsp");
            requestDispatcher.forward(req, resp);
        }

        String token = req.getParameter("search");
        if (token != null) {
            HashSet<Profile> UserSearch = Search.searchForMatch(token, session);
            req.setAttribute("UserSearch", UserSearch);
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/StartPage.jsp");
        requestDispatcher.forward(req, resp);
    }


}





