package com.example.springboot.springboot.models.thread.callable;

import java.util.concurrent.*;

public class MyCallable{
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Callable callable = new Callable() {

            @Override
            public Object call() throws Exception {
                Thread.sleep(3000);
                return "call方法返回信息";
            }
        };
        Future future = executorService.submit(callable);
        System.out.println("====="+ future.get());

    }
}
