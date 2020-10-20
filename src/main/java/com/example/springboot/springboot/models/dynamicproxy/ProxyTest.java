package com.example.springboot.springboot.models.dynamicproxy;

/**
 * 动态代理
 * 优点：代理l类不需要实现接口,但是目标对象一定要实现接口,否则不能用动态代理
 */
public class ProxyTest {
    public static void main(String[] args) {
        DogDao dogDao=new DogDaoImpl();
        DogDao dogDao1 = (DogDao)new ProxyFactory(dogDao).getProxyInstance();
        dogDao1.toAction();

        UserDao userDao = new UserDaoImpl();
        UserDao userDao1 = (UserDao)new ProxyFactory(userDao).getProxyInstance();
        userDao1.toAction();
    }
}
