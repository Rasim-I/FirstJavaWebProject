package Controller;

import Dao.Data;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/Reg")
public class RegisterController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final HttpSession session = req.getSession();
        Data UserList = LoginController.UserList;

        try {
            String name = req.getParameter("name");
            int age = Integer.parseInt(req.getParameter("age"));
            String info = req.getParameter("info");
            String number = req.getParameter("number");
            String photo = "photos/"+session.getAttribute("photo");
            String password = req.getParameter("password");
            System.out.println("Registered pass "+password);
            UserList.addUser(name);

            UserList.addInfo(name, age, info, number, photo, password);
            //System.out.println("User's pass" + UserList.findUser(name).getPassword());
            session.removeAttribute("photo");
        }catch (Exception e){
            req.setAttribute("error", e);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/Login");
            requestDispatcher.forward(req, resp);
        }
        req.setAttribute("error", "Registration completed successfully");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/Login");
        requestDispatcher.forward(req, resp);

    }
}
