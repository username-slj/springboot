package com.example.springboot.springboot.models.cglib;
/**
 * cglib
 * 优点：目标对象没有实现接口,用Cglib代理
 */
public class CglibProxyTest {
    public static void main(String[] args) {
        UserDaoImpl userDao = new UserDaoImpl();
        UserDaoImpl userDao1= (UserDaoImpl)new ProxyFactory(userDao).getProxyInstance();
        userDao1.toAction();
    }
}
