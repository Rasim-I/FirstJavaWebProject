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

@WebServlet("/UserPage")
public class PageController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final HttpSession session = req.getSession();
        String name = (String) session.getAttribute("name");


        if(name!=null) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/UserPage.jsp");
            requestDispatcher.forward(req, resp);
        }else{
            System.out.println("Name null");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/ErrorPage.jsp");
            requestDispatcher.forward(req, resp);
        }



    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final HttpSession session = req.getSession();
        //Data UserList = StandartUsers.getUserList();
        //String name = session.getAttribute("name");
        String infoToChange = req.getParameter("changeInfo");
        String numberToChange = req.getParameter("changePhone");
        String passToChange = req.getParameter("changePass");

        try {

            //session.getAttribute("UserList");
            Data UserList = (Data) session.getAttribute("UserList");
            Profile name = UserList.findUser((String) session.getAttribute("name"));

            if (infoToChange != null) {
                name.setInfo(infoToChange);
            }
            if (numberToChange != null) {
                name.setNumber(numberToChange);
            }
            if(passToChange != null){
                name.setPassword(passToChange);
            }
        }catch (Exception e){
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/ErrorPage.jsp");
            requestDispatcher.forward(req, resp);
        }

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/StartPage.jsp");
            requestDispatcher.forward(req, resp);


        }
    }

