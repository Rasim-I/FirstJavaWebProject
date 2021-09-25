package Dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.logging.Handler;

public interface Data {
    public void addUser(String name);

    public void addInfo(String name, int age, String info, String number, String photo, String password);

    //public void addNoPhoto(String name, int age, String info, String number);


    //public Profile getUser(String user);
    public ArrayList<String> getUsers();

    public HashSet<Profile> friendList(Profile user);

    HashSet<Profile> Users = new HashSet<>();

    public Profile findUser(String name);

    public HashSet<Profile> getUserObject();

    public void AddToFL(String name, Profile user);

    public void DeleteFromFL(String name, Profile user);
}