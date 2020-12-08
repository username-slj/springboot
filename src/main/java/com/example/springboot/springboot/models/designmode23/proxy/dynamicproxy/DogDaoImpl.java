package com.example.springboot.springboot.models.designmode23.proxy.dynamicproxy;

import org.springframework.stereotype.Repository;

@Repository
public class DogDaoImpl implements DogDao {
    @Override
    public void toAction() {
        System.out.println("===狗===");
    }
}
