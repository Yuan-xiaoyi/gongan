package com.example.gongan.util;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class lastTwoDay {

    // 判断是否为最后两天
    public static Boolean isLastTwoDay(String cycle) {
        Date date = new Date();
        switch (cycle) { // 每个周期的最后两天
            case "season":
                int month = date.getMonth() + 1;
                if(month == 3 || month == 6 || month == 9 || month == 12){
                    getLastTwoOfMonth(date);
                }
                break;
            case "month":
                getLastTwoOfMonth(date);
                break;
            case "week":
                if(getWeek(date) == "星期六" || getWeek(date) == "星期日"  || getWeek(date) == "星期天"){
                    return true;
                }
                break;
        }
        return false;
    }


    // 返回周期的最后两天
    public static HashMap<String,Date> getLastTwoDay(String cycle) {
        HashMap<String, Date> map = new HashMap<>();
        Date date = new Date();
        switch (cycle) { // 每个周期的最后两天
            case "season":
                int month = date.getMonth() + 1;
                map = getLastTwoDateOfSeason(month);
                break;
            case "month":
                map = getLastTwoDateOfMonth(date);
                break;
            case "week":
                map.put("CycleFirstDay", getSaturdayDate());
                map.put("CycleLastDay", getWeekLastDate());
                break;
        }
        return map;
    }

    public static String getWeek(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
        String week = sdf.format(date);
        return week;
    }

    // 判断是否是月末
    public static Boolean getLastTwoOfMonth(Date date) {
        //1、创建日历类
        Calendar calendar = Calendar.getInstance();
        //2、设置当前传递的时间，不设就是当前系统日期
        calendar.setTime(date);
        //3、data的日期是N，那么N+1【假设当月是30天，30+1=31，如果当月只有30天，那么最终结果为1，也就是下月的1号】
        calendar.set(Calendar.DATE, (calendar.get(Calendar.DATE) + 1));
        //4、判断是否是当月最后一天或两天【1==1那么就表明当天是当月的最后一天返回true】【2==2那么就表明当天是当月的最后第二天返回true】
        if (calendar.get(Calendar.DAY_OF_MONTH) == 1 || calendar.get(Calendar.DAY_OF_MONTH) == 2) {
            return true;
        }
        return false;
    }

    // 获取此季度末的具体日期
    public static HashMap<String,Date> getLastTwoDateOfSeason(Integer month) {
        HashMap<String, Date> map = new HashMap<>();
        Date date = new Date();
        int year = date.getYear();
        if(month <= 3){
            map.put("CycleFirstDay", new Date(year,3,30));
            map.put("CycleLastDay", new Date(year, 3, 31));
        }else if(month > 3 && month <= 6){
            map.put("CycleFirstDay", new Date(year,6,29));
            map.put("CycleLastDay", new Date(year, 6, 30));
        }else if(month > 6 && month <= 9){
            map.put("CycleFirstDay", new Date(year,9,29));
            map.put("CycleLastDay", new Date(year, 9, 30));
        }else if(month > 9 && month <= 12){
            map.put("CycleFirstDay", new Date(year,12,30));
            map.put("CycleLastDay", new Date(year, 12, 31));
        }
        return map;
    }

    // 获取此月末的具体日期
    public static HashMap<String,Date> getLastTwoDateOfMonth(Date date) {
        HashMap<String, Date> map = new HashMap<>();
        int month = date.getMonth() + 1;
        int year = date.getYear();
        if(month == 1 && month == 3 && month == 5 && month == 7 && month == 8 && month == 10 && month == 12){
            map.put("CycleFirstDay", new Date(year, month, 30));
            map.put("CycleLastDay", new Date(year, month, 31));;
        }else if(month == 4 && month == 6 && month == 9 && month == 11) {
            map.put("CycleFirstDay", new Date(year, month, 29));
            map.put("CycleLastDay", new Date(year, month, 30));
        }else {
            if (year%4==0 && year%100!=0 || year%400==0){ // 闰年
                map.put("CycleFirstDay", new Date(year, month, 28));
                map.put("CycleLastDay", new Date(year, month, 29));
            }else {
                map.put("CycleFirstDay", new Date(year, month, 27));
                map.put("CycleLastDay", new Date(year, month, 28));
            }
        }
        return map;
    }

    /**
     * 获取当前日期所在周的周六日期
     * @return String 格式 yyyy-MM-dd
     */
    public static Date getSaturdayDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        if(cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY ){
            cal.set(Calendar.DATE,cal.get(Calendar.DATE)-1 );// 设置时间为前一天
            Date day = new Date(cal.getTime().getYear(),cal.getTime().getMonth()+1, cal.getTime().getDate());
            return day;
        }
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        cal.set(Calendar.DATE, cal.get(Calendar.DATE) + 5);

        Date day = new Date(cal.getTime().getYear(),cal.getTime().getMonth()+1, cal.getTime().getDate());
        return day;
    }
    /**
     * 获取当前日期所在周的周日日期
     * @return String 格式 yyyy-MM-dd
     */
    public static Date getWeekLastDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        if(cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY ){
            Date day = new Date(cal.getTime().getYear(),cal.getTime().getMonth()+1, cal.getTime().getDate());
            return day;
//            return simpleDateFormat.format(cal.getTime());
        }
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        cal.set(Calendar.DATE, cal.get(Calendar.DATE) + 6);

        Date day = new Date(cal.getTime().getYear(),cal.getTime().getMonth()+1, cal.getTime().getDate());
        return day;
    }

}
