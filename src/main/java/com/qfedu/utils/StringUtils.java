package com.qfedu.utils;

import java.text.DecimalFormat;

/**
 * @program: QFVideos
 * @ClassName: StringUtils
 * @description: TODO
 * @author: ccq
 * @create: 2019-08-08 08:45
 **/
public class StringUtils {

    public static String getTimeByInt(int second){

        DecimalFormat decimalFormat =new DecimalFormat("00");
        // 3700    01:01:40
        String time = "";
        int hour = second / 3600 ;
        // time += hour > 10 ? hour : "0"+hour+":";
        time += decimalFormat.format(hour) +":";
        int minute = (second - hour*3600) / 60 ;
        //time += minute > 10 ? minute : "0"+minute +":" ;
        time += decimalFormat.format(minute) +":";
        int sec = second % 60 ;
        // time += sec > 10 ? sec :"0"+sec;
        time += decimalFormat.format(sec);

        return time;
    }

}