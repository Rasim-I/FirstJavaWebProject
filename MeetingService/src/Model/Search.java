package Model;

import Dao.Data;
import Dao.Profile;

import javax.servlet.http.HttpSession;
import java.util.HashSet;

public class Search {
    public static HashSet<Profile> searchForMatch(String text, HttpSession session) {
        String[] tokens = text.toLowerCase().split(" ");

        Data UserList = (Data) session.getAttribute("UserList");
        HashSet<Profile> list = new HashSet<>();
        for (Profile i : UserList.getUserObject()) {
            for (String n : tokens) {
                if (i.getInfo().toLowerCase().contains(n)) {
                    list.add(i);
                }
            }
        }
        return list;
    }
}
