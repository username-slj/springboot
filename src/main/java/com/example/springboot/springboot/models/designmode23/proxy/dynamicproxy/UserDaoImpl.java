package com.example.springboot.springboot.models.designmode23.proxy.dynamicproxy;

public class UserDaoImpl implements UserDao {
    @Override
    public void toAction() {
        System.out.println("===admin===");
    }
}
