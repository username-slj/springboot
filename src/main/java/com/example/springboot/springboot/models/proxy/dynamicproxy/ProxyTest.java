package com.example.springboot.springboot.models.proxy.dynamicproxy;

/**
 * 动态代理： 目标对象必须实现接口，否则不能用动态代理（DogDaoImpl实现了DogDao接口）
 * CGLIB: 目标对象不需要实现接口，只是一个单独类
 *        （UserDaoImpl单独一个普通类，没有实现任何接口的）
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
