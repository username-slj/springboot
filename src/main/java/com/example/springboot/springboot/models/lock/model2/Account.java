package com.example.springboot.springboot.models.lock.model2;

import java.math.BigDecimal;

public class Account {
    private BigDecimal amount=BigDecimal.ZERO;

    //存钱
    public void addAmount(BigDecimal amt) throws InterruptedException {
        if (amt != null && amt.compareTo(BigDecimal.ZERO) == 1) {
            this.amount = amount.add(amt);
//            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + "存钱金额为：" + amt + ",余额：" + this.amount);
        }
    }
}
