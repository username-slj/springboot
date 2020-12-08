package com.example.springboot.springboot.models.designmode23.proxy.staticproxy;

/**
 * 静态代理
 * 1.优点：可以对其他方法前后添加其他业务操作
 * 2.缺点：每个代理类必须实现接口的方法，后期添加方法代理类也需要添加
 */
public class TestMain {
    public static void main(String[] args) {
        DogDaoImpl dogDaoImpl = new DogDaoImpl();
        DogDao dogDao=new DogProxy(dogDaoImpl);
        dogDao.toAction();
    }
}
