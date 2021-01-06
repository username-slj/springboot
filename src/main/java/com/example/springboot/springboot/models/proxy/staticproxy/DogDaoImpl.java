package com.example.springboot.springboot.models.proxy.staticproxy;

import com.example.springboot.springboot.models.proxy.staticproxy.DogDao;

public class DogDaoImpl implements DogDao {
    @Override
    public void toAction() {
        System.out.println("===狗===");
    }
}
