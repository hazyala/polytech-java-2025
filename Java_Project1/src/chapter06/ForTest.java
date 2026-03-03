package chapter06;

import java.util.ArrayList;

public class ForTest {

    public static void main(String[] args) {
        String[] names = {"김나현", "김예진", "김재영", "김지혁", "김해민", "김호석", "도경진"};


        for (int i = 0; i < names.length; i++){
            System.out.println( names[i] + ": 서울정수캠퍼스 인공지능소프트웨어과");
        }


        for(String name: names){
            System.out.println(name);
        }

    }
}
