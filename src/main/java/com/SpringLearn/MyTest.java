package com.SpringLearn;

import com.MyAnnos.NameCheck;

public class MyTest {

    @NameCheck(forbidden = "amu,lx,lisi")
    public void showName(String name){
        System.out.println(name);
    }
}
