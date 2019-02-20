package com;


import com.MyAnnos.NameCheck;
import com.SpringLearn.MyConfig;
import com.SpringLearn.MyTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.UserService;
import com.UserValidateConfig;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class Xin {
    public static void main(String[] args) throws Exception {
        /*
        //ApplicationContext applicationContext=new ClassPathXmlApplicationContext("myuser.xml");
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfig.class);// 注解
        UserService userService = (UserService)applicationContext.getBean("myUservice");
        userService.UserLogin("123456","852963658");
        */

//        MyTest myTest = new MyTest();
//        myTest.showName("amulx");
        // 反射和注解的综合的使用
        // 反射  动态加载 运行时
        String name = "amu";
        Class mytestClass = Class.forName("com.SpringLearn.MyTest");
        Method showNameMethod = mytestClass.getDeclaredMethod("showName", String.class);

        Object mytestClassobj = mytestClass.newInstance();

        // showNameMethod.invoke(mytestClassobj,name);

//        Annotation[] annotations = showNameMethod.getDeclaredAnnotations();
//        for (Annotation a:annotations) {
//            System.out.println(a.toString());
//        }
        if(showNameMethod.isAnnotationPresent(NameCheck.class)){
            NameCheck nameCheck = showNameMethod.getDeclaredAnnotation(NameCheck.class);
//            System.out.println(nameCheck.forbidden());
            if (nameCheck.forbidden().contains(name)){
                System.out.println("有违禁字符");
            } else {
                System.out.println(name);
            }
        }
    }
}
