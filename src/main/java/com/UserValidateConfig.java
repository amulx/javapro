package com;

public class UserValidateConfig {
    private int UserNameLength;  //用户名的长度
    private boolean QQRequired;//QQ是否必填

    public UserValidateConfig() {

    }
    public UserValidateConfig(int userNameLength, boolean QQRequired) {
        UserNameLength = userNameLength;
        this.QQRequired = QQRequired;
    }

    public int getUserNameLength() {
        return UserNameLength;
    }

    public void setUserNameLength(int userNameLength) {
        UserNameLength = userNameLength;
    }

    public boolean isQQRequired() {
        return QQRequired;
    }

    public void setQQRequired(boolean QQRequired) {
        this.QQRequired = QQRequired;
    }
}
