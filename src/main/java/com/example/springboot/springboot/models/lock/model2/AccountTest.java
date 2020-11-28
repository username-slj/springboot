package com.example.springboot.springboot.models.lock.model2;

/**
 * 两个用户往同一个账户存钱
 */
public class AccountTest {
    public static void main(String[] args) {
        Account account = new Account();

        MyAccount myAccount1 = new MyAccount(account);
        MyAccount myAccount2 = new MyAccount(account);

        Thread thread1=new Thread(myAccount1);
        Thread thread2=new Thread(myAccount2);
        thread1.start();
        thread2.start();

    }
}
