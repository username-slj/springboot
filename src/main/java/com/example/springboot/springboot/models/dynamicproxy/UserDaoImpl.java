package com.example.springboot.springboot.models.dynamicproxy;

public class UserDaoImpl implements UserDao {
    @Override
    public void toAction() {
        System.out.println("===admin===");
    }
}
