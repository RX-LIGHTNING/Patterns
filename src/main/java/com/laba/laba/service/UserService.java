package com.laba.laba.service;

import com.laba.laba.Entity.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    private static final String path = String.valueOf("Users.txt");
    public static void addUser(User user){
        try{
            List<User> temp = getUsers();
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
            temp.add(user);
            oos.writeObject(temp);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<User> getUsers(){
        List<User> result = null;
        try{
            ObjectInputStream oos = new ObjectInputStream (new FileInputStream(path));
                result = (List<User>) oos.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }
    public static boolean isLoggedIn(String login,String password){

        return getUsers().contains(new User(login,password));
    }
}
