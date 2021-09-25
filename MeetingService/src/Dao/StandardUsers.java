package Dao;

import Dao.Data;
import Model.Users;

public class StandardUsers {

    public static Data getUserList(){
        Data UserList = new Users();
        UserList.addUser("Betty");
        UserList.addUser("Joseph");
        UserList.addUser("Ann");
        UserList.addUser("Ernest");
        UserList.addUser("Merry");
        UserList.addUser("William");
        //
        UserList.addInfo("Betty", 25, "Hello, hello, good morning", "434242452", "photos/W2.jpg", "1111");

        UserList.addInfo("Joseph", 30, "Nice to meet you", "2222239", "photos/M1.jpg", "1111");

        UserList.addInfo("Ann", 33, "My Profile is not empty", "33424522", "photos/W1.jpg", "1111");

        UserList.addInfo("Ernest", 28, "What came first, the chicken or the egg?", "5545455", "photos/M3.jpg", "1111");

        UserList.addInfo("Merry", 23, "Hello!", "43859639", "photos/W3.jpg", "1111");

        UserList.addInfo("William", 24, "Yep.", "00359639", "photos/M2.jpg", "1111");

        return UserList;
    }
}
