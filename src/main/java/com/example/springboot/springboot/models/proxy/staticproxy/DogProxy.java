package com.example.springboot.springboot.models.proxy.staticproxy;

import com.example.springboot.springboot.models.proxy.staticproxy.DogDao;

public class DogProxy implements DogDao {
    private DogDao dogDao;

    public DogProxy(DogDao dogDao){
        this.dogDao=dogDao;
    }

    @Override
    public void toAction() {
        System.out.println("静态代理---------------");
        dogDao.toAction();
        System.out.println("静态代理---------------");
    }
}
