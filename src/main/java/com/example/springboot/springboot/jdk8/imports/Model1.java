package com.example.springboot.springboot.jdk8.imports;

import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

//@Component
public class Model1 {

    public void print(){
        System.out.println("Model1.print======="+Thread.currentThread().getName());
    }
}
