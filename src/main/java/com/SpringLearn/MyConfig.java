package com.SpringLearn;

import com.UserService;
import com.UserValidateConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

    @Bean
    public UserValidateConfig userValidateConfig1(){
        return new UserValidateConfig(){
            {
                setUserNameLength(6);
                setQQRequired(true);
            }
        };
    }

    @Bean
    public UserService myUservice(){
        UserService userService = new UserService();
        userService.setUserValidateConfig(this.userValidateConfig1());
        return userService;
    }
}
