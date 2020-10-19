package com.example.springboot.springboot.models.staticproxy;

public class TestMain {
    public static void main(String[] args) {
        DogDaoImpl dogDaoImpl = new DogDaoImpl();
        DogDao dogDao=new DogProxy(dogDaoImpl);
        dogDao.toAction();
    }
}
