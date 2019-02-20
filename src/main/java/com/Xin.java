package com;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.UserService;
import com.UserValidateConfig;
public class Xin {
    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("myuser.xml");
//        UserValidateConfig userValidateConfig = (UserValidateConfig)applicationContext.getBean("user_config1");
//        System.out.println(userValidateConfig.getUserNameLength());
//        System.out.println(userValidateConfig.isQQRequired());
        UserService userService = (UserService)applicationContext.getBean("userService");
        userService.UserLogin("123456","852963658");
    }
}
