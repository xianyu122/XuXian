package com.xuxian.utils;

import java.util.Random;

public class IdentifyUtil {


    public static final String[] STR = {"0","1","2","3","4","5","6","7","8","9"};

    public static String randomStr(){
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for (int i = 0;i<6;i++){
            sb.append(STR[random.nextInt(9)]);
        }
        return sb.toString();
    }

}
