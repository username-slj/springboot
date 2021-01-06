package com.example.springboot.springboot.models.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import java.lang.reflect.Method;

public class ProxyFactory implements MethodInterceptor {
    private Object obj;

    public ProxyFactory(Object obj){
        this.obj=obj;
    }

    public Object getProxyInstance(){
        //工具类
        Enhancer enhancer = new Enhancer();
        //set父类
        enhancer.setSuperclass(obj.getClass());
        //回调函数
        enhancer.setCallback(this);
        //创建子类代理对象
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib----------");
        Object invoke = method.invoke(obj, objects);
        System.out.println("cglib----------");
        return invoke;
    }
}
