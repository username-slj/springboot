package com.example.springboot.springboot.models.staticproxy;

public class DogDaoImpl implements DogDao {
    @Override
    public void toAction() {
        System.out.println("===狗===");
    }
}
