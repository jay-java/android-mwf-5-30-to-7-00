package com.example.firsstapp;

import java.util.ArrayList;
import java.util.List;

class Car {
    private String name;
    private int image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
public class Data {
    public static List<Car> getAllCar(){
        List<Car> list = new ArrayList<Car>();
        Car mer = new Car();
        mer.setName("Mercedes");
        mer.setImage(R.drawable.mer);

        Car bmw = new Car();
        bmw.setName("BMW");
        bmw.setImage(R.drawable.bmw);

        Car volvo = new Car();
        volvo.setName("VOLVO");
        volvo.setImage(R.drawable.volvo);

        Car rr = new Car();
        rr.setName("Rolce Royce");
        rr.setImage(R.drawable.rr);

        list.add(mer);
        list.add(bmw);
        list.add(volvo);
        list.add(rr);
        return list;
    }
}
