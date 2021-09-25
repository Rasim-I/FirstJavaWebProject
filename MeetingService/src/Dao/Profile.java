package Dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Profile {
    public String name;
    public int age;
    public String info;
    public String number;
    public String photo;
    public String password;
    public HashMap<String, Boolean> friends;
    //ArrayList<Profile> profiles = new ArrayList<>();




    public Profile(String name){
        this.name = name;
    }

    //public void AddToFL(String name){
    //    this.friends.replace(name, Boolean.TRUE);
    //}

    //public void DeleteFromFL(String name){
    //    this.friends.replace(name, Boolean.FALSE);
    //}

    public boolean isFriend(String name){

        for(Map.Entry<String, Boolean> h: this.friends.entrySet()){
            if(h.getKey()==name){
                return h.getValue();
            }
        }
                return false;
    }





    public void setPassword(String password){this.password = password;}

    public void setPhoto(String photo){this.photo = photo;}

    public void setAge(int age) {
        this.age = age;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setFriends(HashMap<String, Boolean> friends){this.friends = friends;};

    public HashMap<String, Boolean> getFriends(){return friends;}

    public String getName() {
        return name;
    }

    public String getPassword(){return password;}

    public int getAge() {
        return age;
    }

    public String getInfo() {
        return info;
    }

    public String getNumber() {
        return number;
    }

    public String getPhoto(){return photo;}


}
