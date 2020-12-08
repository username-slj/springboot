package com.example.springboot.springboot.jdk8.statics;

/**
 * 类加载过程
 * 加载、验证、准备、解析、初始化、使用、卸载
 * 类加载过程包括：加载、验证、准备、解析、初始化五个阶段。
 *
 * 类加载
 * 静态变量和静态代码块的加载顺序由编写先后决定
 * new 对象（方法调用前加载匿名代码块（多个匿名代码块根据顺序加载））
 * 执行方法（类.方法）
 * 静态方法（）调用才会加载
 */

public class ClassLoadTest {//第一步

    public static void main(String[] args) {
        new ClassLoadTest();                         //4.第四步，new一个类，但在new之前要处理匿名代码块
    }

    static int num = 4;                    //2.第二步，静态变量和静态代码块的加载顺序由编写先后决定

    {
        num += 3;
        System.out.println("b");           //5.第五步，按照顺序加载匿名代码块，代码块中有打印
    }

    int a = 5;                             //6.第六步，按照顺序加载变量

    { // 成员变量第三个
        System.out.println("c");           //7.第七步，按照顺序打印c
    }

    ClassLoadTest() { // 类的构造函数，第四个加载
        System.out.println("d");           //8.第八步，最后加载构造函数，完成对象的建立
    }

    static {                              // 3.第三步，静态块，然后执行静态代码块，因为有输出，故打印a
        System.out.println("a");
    }

    static void run()                    // 静态方法，调用的时候才加载// 注意看，e没有加载
    {
        System.out.println("e");
    }

}
