package com.example.springboot.springboot.models.designmode23.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {

    private Object obj;

    public ProxyFactory(Object obj) {
        this.obj = obj;
    }

    public Object getProxyInstance() {
        return Proxy.newProxyInstance(
                obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("动态代理----------");
                        Object invoke = method.invoke(obj, args);
                        System.out.println("动态代理----------");
                        return invoke;
                    }
                }
        );
    }
}
