package com.example.springboot.springboot.models.staticproxy;

public class DogProxy implements DogDao {
    private DogDao dogDao;

    public DogProxy(DogDao dogDao){
        this.dogDao=dogDao;
    }

    @Override
    public void toAction() {
        System.out.println("---------------");
        dogDao.toAction();
        System.out.println("---------------");
    }
}
