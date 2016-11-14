package com.zcl.somecode.changevalue;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhanchunliang on 16/11/14.
 */
public class TestChangeValue {

    public static void main(String[] args) {
        List<Apple> appList = new ArrayList<Apple>();
        appList.add(new Apple("红","red"));
        appList.add(new Apple("绿","green"));
        TestChangeValue testChangeValue = new TestChangeValue();
        testChangeValue.changAppleValue(appList);
        for (Apple a : appList){
            System.out.println(a.getName()+'-'+a.getColor());
        }
    }


    /***
     * 结论，
     * 引用所指向的属性值能被改变
     * 引用的本身不会被改变
     */
    private boolean changAppleValue(List<Apple> appleList){
        for (Apple apple : appleList){
            apple.setName("sssss");
            apple.setColor("ddddd");
        }
        /*appleList  = new ArrayList<Apple>();
        appleList.add(new Apple("333","222"));*/
        return true;
    }

}
