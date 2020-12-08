package com.example.springboot.springboot.models.designmode23.proxy.staticproxy;

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
