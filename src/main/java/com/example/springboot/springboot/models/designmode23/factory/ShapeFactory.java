package com.example.springboot.springboot.models.designmode23.factory;

import org.springframework.util.StringUtils;

/**
 * 工厂模式：一个接口三个实现类生产不同汽车，一个工厂(4S店)根据类型判断客户需要上面汽车，给他造（new）出来，
 * 客户获取方法（取车）
 */
public class ShapeFactory {

    public Shape getShape(String type){
        if(StringUtils.isEmpty(type)){
            return null;
        }else if("Audi".equalsIgnoreCase(type)){
            return new Audi();
        }else if("Bmw".equalsIgnoreCase(type)){
            return new Bmw();
        }else if("MazDa".equalsIgnoreCase(type)){
            return new MazDa();
        }
        return null;
    }
}
