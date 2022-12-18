package com.laba.laba.service;

import com.laba.laba.Entity.Appliance;
import com.laba.laba.Entity.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ApplianceService {

    private static final String path = String.valueOf("Appliances.txt");

    public static List<Appliance> getAppliances(){
        List<Appliance> result = new ArrayList<>();
        try{
            ObjectInputStream oos = new ObjectInputStream (new FileInputStream(path));
            result = (List<Appliance>) oos.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void addAppliance(Appliance appliance){
        try{
            List<Appliance> temp = getAppliances();
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
            temp.add(appliance);
            oos.writeObject(temp);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
