package com.example.springboot.springboot.models.thread.callable;

import java.util.concurrent.*;

public class MyCallable implements Callable{

    @Override
    public Object call() throws Exception {
        return "======".concat(Thread.currentThread().getName());
    }
}
