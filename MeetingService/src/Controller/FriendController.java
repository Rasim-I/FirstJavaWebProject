package Controller;

import Dao.Data;
import Dao.Profile;

import javax.jws.soap.SOAPBinding;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet("/FriendRequest")
public class FriendController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final HttpSession session = req.getSession();
        Data UserList = (Data) session.getAttribute("UserList");
        String name = (String) session.getAttribute("name");
        String nameOfPage = req.getParameter("nameOfPage");
        String request = req.getParameter("request");
        req.setAttribute("nameOfPage", UserList.findUser(nameOfPage));
        Profile user = UserList.findUser(name);
        user.getFriends().replace(nameOfPage, Boolean.TRUE);

        if(request.equals("true")){
            user.getFriends().replace(nameOfPage, Boolean.TRUE);
        }else if(request.equals("false")){
            user.getFriends().replace(nameOfPage, Boolean.FALSE);
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/UserPage.jsp");
        requestDispatcher.forward(req, resp);

    }
}
