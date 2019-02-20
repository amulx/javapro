package com;

public class UserService {
    private UserValidateConfig userValidateConfig;

    public UserValidateConfig getUserValidateConfig() {
        return userValidateConfig;
    }

    public void setUserValidateConfig(UserValidateConfig userValidateConfig) {
        this.userValidateConfig = userValidateConfig;
    }

    public void UserLogin(String username, String qq) throws Exception {
        if(username.length()<userValidateConfig.getUserNameLength())
        {
            throw  new Exception("用户名长度不合法");
        }

        if(userValidateConfig.isQQRequired() && qq.trim().equals(""))
        {
            throw  new Exception("QQ必须得填");
        }

        System.out.println("用户登录开始执行");
    }
}
