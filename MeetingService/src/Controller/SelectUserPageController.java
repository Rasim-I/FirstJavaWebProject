package Controller;

import Dao.Data;
import Dao.Profile;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/test")
public class SelectUserPageController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nameOfPage = req.getParameter("nameOfObj");
        final HttpSession session = req.getSession();
        Data UserList = (Data) session.getAttribute("UserList");

        req.setAttribute("nameOfPage", UserList.findUser(nameOfPage));

        System.out.println(nameOfPage+"THIS IS PAGE NAME");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/UserPage.jsp");
        requestDispatcher.forward(req, resp);

    }
}
