package Model;

import Dao.Data;
import Dao.Profile;
import com.sun.deploy.util.StringUtils;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Users implements Data {

    static HashSet<Profile> Users = new HashSet<>();

    @Override
    public void addUser(String name) {
        Users.add(new Profile(name));
    }

    @Override
    public void addInfo(String name, int age, String info, String number, String photo, String password) {
        for (Profile User : Users) {
            //HashMap<String, Boolean> friends = User.getFriends();
            if (User.name.equals(name)) {
                HashMap<String, Boolean> friends = new HashMap<>();
                User.setInfo(info);
                User.setNumber(number);
                User.setAge(age);
                User.setPhoto(photo);
                User.setPassword(password);

                for(Profile i : Users){
                    if(i.getName()!=name){
                        friends.put(i.getName(), Boolean.FALSE);
                    }
                }
                User.setFriends(friends);
            }else if(User.friends!=null){
                User.friends.put(name, Boolean.FALSE);
            }




            /*
            HashMap<String, Boolean> friends = new HashMap<>();
            for(Profile AddToOld : Users){

                    friends.put(AddToOld.getName(), Boolean.FALSE);
                    User.setFriends(friends);

            }*/


        }
    }

    @Override
    public void AddToFL(String name, Profile user){
        user.getFriends().replace(name, Boolean.FALSE, Boolean.TRUE);
    }

    @Override
    public void DeleteFromFL(String name, Profile user){
        user.getFriends().replace(name, Boolean.TRUE, Boolean.FALSE);
    }

    @Override
    public Profile findUser(String name){
        for(Profile i : Users){
            if(i.getName().equals(name)){
                return i;
            }
        }
        return null;
    }

    @Override
    public HashSet<Profile> friendList(Profile user){
        HashSet<Profile> friends = new HashSet<>();
        for(Map.Entry<String, Boolean> us : user.getFriends().entrySet()){
            if(us.getValue()==Boolean.TRUE){
                if(findUser(us.getKey()).getFriends().get(user.getName())==Boolean.TRUE){
                    friends.add(findUser(us.getKey()));
                }
            }
        }

        return friends;
    }



/*
    @Override
    public void addNoPhoto(String name, int age, String info, String number) {
        for (Profile User : Users) {
            if (User.name.equals(name)) {
                User.setInfo(info);
                User.setNumber(number);
                User.setAge(age);
                //User.setPhoto(photo);
            }
        }
    }
*/

    public HashSet<Profile> getUserObject(){return Users;}

/*
    public Profile getUser(String user) {
        for (Profile User : Users) {
            if (User.name.equals(user)) {
                return User;
            }
        }
        return null;
    }
*/
    @Override
    public ArrayList<String> getUsers() {
        ArrayList<String> R = new ArrayList<>();
        String T = "";
        for (Iterator iterator = Users.iterator(); iterator.hasNext(); ) {
            Profile sp = (Profile) iterator.next();
            T = sp.name;
            R.add(T);
        }
        return R;
    }







}
