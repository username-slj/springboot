package com.example.springboot.springboot.models.proxy.cglib;
/**
 * cglib：目标对象不需要实现接口，只是一个单独类
 *       （UserDaoImpl单独一个普通类，没有实现任何接口的）
 */
public class CglibProxyTest {
    public static void main(String[] args) {
        UserDaoImpl userDao1= (UserDaoImpl)new ProxyFactory(new UserDaoImpl()).getProxyInstance();
        userDao1.toAction();
    }
}
