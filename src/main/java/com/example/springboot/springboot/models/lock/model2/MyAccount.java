package com.example.springboot.springboot.models.lock.model2;

import java.math.BigDecimal;
import java.util.concurrent.locks.ReentrantLock;

public class MyAccount implements Runnable {
    private Account account;


    public MyAccount(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                this.account.addAmount(new BigDecimal(100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
