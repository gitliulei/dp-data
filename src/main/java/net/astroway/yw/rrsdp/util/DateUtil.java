package net.astroway.yw.rrsdp.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.springframework.util.StringUtils;

/**
 * 项目名称：compass
 * 类名：DateUtil
 * 类描述：时间工具类
 * @Author: 李国华
 * @Date 2017/3/21
 * @Email: liguohua@astroway.net
 * 修改人：
 * 修改时间
 * 备注：
 */
public class DateUtil {


    public static SimpleDateFormat dateDtFormat = new SimpleDateFormat("yyyyMMdd");

    public static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static SimpleDateFormat shortFormat = new SimpleDateFormat("yyyyMM");

    public static SimpleDateFormat getDateDtFormat() {
        return new SimpleDateFormat("yyyyMMdd");
    }

    /**
     * 方法说明：获取某月最后一天
     * @param year 年份，例如2017
     * @param month 月份，1-12
     * @return String 例如"20170331"
     * 创建日期：2017/3/21
     * 创建人：李国华
     * 修改记录：<br>
     * 修改时间：<br>
     * 修改人：<br>
     * 使用人：李国华
     * 使用时间：2017/3/21
     * 使用路径：<br>
     **/
    public static String lastDayOfMonth(int year,int month, Integer day) {

        StringBuffer result = new StringBuffer("");

        if(month == 0 || month > 12) {
            return result.toString();
        }

        Calendar calendar = Calendar.getInstance();
        int currentMonth = calendar.get(Calendar.MONTH) + 1;
        int currentYear  = calendar.get(Calendar.YEAR);

        //若为指定日期所在月份
        if(year == currentYear && month == currentMonth) {
            if(null == day) {
                day = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
            }
            result.append(year).append(formatToTwo(month)).append(formatToTwo(day));
            return result.toString();
        }

        //1,3,5,7,8,10,12月
        if(month == 1 || month == 3 || month == 5 || month == 7 ||
                month == 8 || month == 10 || month == 12) {
            if(null == day) {
                day = 31;
            }
            result.append(year).append(formatToTwo(month)).append(formatToTwo(day));
        }

        //2月
        if(month == 2) {
            if(null == day) {
                if(isLeapYear(year)) {
                    result.append(year).append(formatToTwo(month)).append("29");
                }else {
                    result.append(year).append(formatToTwo(month)).append("28");
                }
            } else {
                result.append(year).append(formatToTwo(month)).append(formatToTwo(day));
            }

        }

        //4,6,9,11月
        if(month == 4 || month == 6 || month == 9 || month == 11) {
            if(null == day) {
                day = 30;
            }
            result.append(year).append(formatToTwo(month)).append(formatToTwo(day));
        }

        return result.toString();
    }

    //判断闰年
    public static Boolean isLeapYear(int year) {
        if((year % 4 == 0 && year % 100 != 00) || year % 400 == 0) return true;
        return false;
    }

    //格式化为两位字符串
    public static String formatToTwo(int index) {
        return String.format("%02d", index);
    }

    /**
     * 获取最近12个月月末日期
     * @param dateStr 例如 20170308
     * **/
    public static List<String> getRecent12Months(String dateStr) {
        List<String> result = new ArrayList<String>();
        if(StringUtils.isEmpty(dateStr) || dateStr.length() != 8) {
            return result;
        }

        String yearStr  = dateStr.substring(0, 4);
        String monthStr = dateStr.substring(4, 6);
        Integer day = Integer.parseInt(dateStr.substring(6, 8));

        int year = Integer.parseInt(yearStr);
        int month = Integer.parseInt(monthStr);

        int offsetLastYear = 12 - month;
        //去年
        for(int i=1;i<=offsetLastYear;i++) {
            int lastYear = year - 1;
            int monthLastYear = month + i;
            result.add(lastDayOfMonth(lastYear, monthLastYear, null));
        }

        //今年
        for(int j=1;j<=month;j++) {
            if(j == month) {
                result.add(lastDayOfMonth(year, j, day));
            } else {
                result.add(lastDayOfMonth(year, j, null));
            }
        }

        return result;
    }


    //获取上月的同一天日期
    public static String getDateOfLastMonth(String dateStr) throws ParseException{
        Date date = dateDtFormat.parse(dateStr);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, -1);
        Date last = calendar.getTime();
        return dateDtFormat.format(last);
    }

    //获取上月的最后一天日期
    public static String getLastDayOfLastMonth(String dateStr) throws ParseException{
        Date date = dateDtFormat.parse(dateStr);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, -1);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        Date last = calendar.getTime();
        return dateDtFormat.format(last);
    }

    /**
     * 方法说明：获取昨天日期
     * @param dateStr
     * @return String 例如"20170331"
     * 创建日期：2017/3/21
     * 创建人：李国华
     * 修改记录：<br>
     * 修改时间：<br>
     * 修改人：<br>
     * 使用人：李国华
     * 使用时间：2017/3/21
     * 使用路径：<br>
     **/
    public static String getDateOfYesterday(String dateStr) throws ParseException{
        Calendar calendar = Calendar.getInstance();
        Date date = dateDtFormat.parse(dateStr);
        calendar.setTime(date);
        calendar.add(Calendar.DATE, -1);
        Date yesterday = calendar.getTime();
        return dateDtFormat.format(yesterday);
    }

    //获取上月第一天
    public static String getFirstDayOfLastMonth(String dateStr) throws ParseException{
        Calendar calendar = Calendar.getInstance();
        Date date = dateDtFormat.parse(dateStr);
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, -1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        Date first = calendar.getTime();
        return dateDtFormat.format(first);
    }

    //获取上月最后一天
    public static String getLastDayOfLastMonth(Calendar date){
        date.set(Calendar.DAY_OF_MONTH, 1);
        date.add(Calendar.DATE, -1);
        Date last = date.getTime();
        return dateDtFormat.format(last);
    }

    //获取今年所有月份最后一天
    public static List<String> getLastDayOfMonthOfThisYear() {
        List<String> list = new ArrayList<String>();
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;

        for(int i=1;i<=month;i++) {
            String date = lastDayOfMonth(year, i, null);
            list.add(date);
        }

        return list;
    }

    //获取本月第一天
    public static String getFirstDayOfThisMonth(String dateStr) throws ParseException{
        Date date = dateDtFormat.parse(dateStr);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return dateDtFormat.format(calendar.getTime());
    }

    //获取本月最后一天
    public static String getLastDayOfThisMonth(String dateStr) throws ParseException{
        Date date = dateDtFormat.parse(dateStr);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return dateDtFormat.format(calendar.getTime());
    }


    //获取今年第一天
    public static String getFirstDayOfThisYear(String dateStr) throws ParseException{
        Date date = dateDtFormat.parse(dateStr);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        return year + "0101";
    }

    //获取本月剩余天数
    public static int getLastDays(String dateStr) {
        Calendar calendar = Calendar.getInstance();
        try {
            Date date = dateDtFormat.parse(dateStr);
            calendar.setTime(date);
        } catch (ParseException e) {}

        int days = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        String dayStr = dateStr.substring(6);
        return days - Integer.parseInt(dayStr) + 1;
    }

    //获取月趋势时间区间
    public static Map<String,String> getDateStr(String beginDay, boolean isContainNow){
        Map<String,String> resultMap = new HashMap<String, String>();
        try {
            // 获取时间
            SimpleDateFormat formatYm = new SimpleDateFormat("yyyyMM");
            SimpleDateFormat formatYmd = new SimpleDateFormat("yyyyMMdd");
            Date date = formatYmd.parse(beginDay);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            if(!isContainNow){
                calendar.add(Calendar.MONTH, -1);
            }
            String endDate = formatYm.format(calendar.getTime());

            if(calendar.get(Calendar.MONTH)<Calendar.JULY){
                // 1-6月向前推12个月
                calendar.add(Calendar.MONTH, -10);
            }else{
                // 7-12月推到本年的1月
                calendar.set(Calendar.MONTH, Calendar.JANUARY);
            }

            String beginDate = formatYm.format(calendar.getTime());

            resultMap.put("endDate", endDate);
            resultMap.put("beginDate", beginDate);
            System.out.println("月趋势取值区间为:"+beginDate+"至"+endDate);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resultMap;
    }

    //格式化月份
    public static String formatMonth(String month){
        if(month.substring(0, 4).equals(new SimpleDateFormat("yyyy").format(new Date()))) {
            return Integer.parseInt(month.substring(4,6)) + "月";
        }
        return month;
    }

    //获取明天
    public static String getYesterday(Date date) throws ParseException{
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, -1);
        Date yesterday = calendar.getTime();
        return dateFormat.format(yesterday);
    }

    //获取本月天数
    public static int getDaysNum(String dateStr) {
        String dayStr = dateStr.substring(6);
        return Integer.parseInt(dayStr);
    }

    //获取去年最后一天
    public static String getLastYearLastDay(int year){
        SimpleDateFormat formatYmd = new SimpleDateFormat("yyyyMMdd");
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year-1);
        calendar.roll(Calendar.DAY_OF_YEAR, -1);
        Date currYearLast = calendar.getTime();
        String date = formatYmd.format(currYearLast);
        return date;
    }

    /**
     * 方法说明：获取最近30天的日期
     **/
    public static List<String> getRecent30Days(String dateStr) throws ParseException{
        Calendar calendar = Calendar.getInstance();
        Date date = dateDtFormat.parse(dateStr);
        calendar.setTime(date);
        List<String> dateList = new ArrayList<String>();
        calendar.add(Calendar.DATE, -31);
        for(int i=-30;i<0;i++) {
            calendar.add(Calendar.DATE, +1);
            Date yesterday = calendar.getTime();
            String dateTime = dateDtFormat.format(yesterday);
            dateList.add(dateTime);
        }
        return dateList;
    }

    /**
     * 获取最近12个月月份
     * @param dateStr 例如 20170308
     * **/
    public static List<String> getMYRecent12Months(String dateStr) {
        List<String> result = new ArrayList<String>();
        if(StringUtils.isEmpty(dateStr) || dateStr.length() != 8) {
            return result;
        }

        String yearStr  = dateStr.substring(0, 4);
        String monthStr = dateStr.substring(4, 6);

        int year = Integer.parseInt(yearStr);
        int month = Integer.parseInt(monthStr);

        int offsetLastYear = 12 - month;
        //去年
        for(int i=1;i<=offsetLastYear;i++) {
            int lastYear = year - 1;
            int monthLastYear = month + i;
            result.add(lastYear + formatToTwo(monthLastYear));
        }

        //今年
        for(int j=1;j<=month;j++) {
            result.add(yearStr + formatToTwo(j));
        }

        return result;
    }

    //获取当天近8个小时
    public List<Integer> getRecentHour() {
        Calendar calendar = Calendar.getInstance();
        int b = calendar.get(Calendar.HOUR_OF_DAY);
        List<Integer> list = new ArrayList<Integer>();
        if(b >= 8) {
            for(int i=8;i>0;i--) {
                int c = b - i;
                list.add(c);
            }
        }

        if(b < 8 && b > 1) {
            int d = (8 - b);
            for(int j=d;j>0;j--) {
                int f = 24 - j;
                list.add(f);
            }

            if(b != 0){
                list.add(0);
            }
            for(int m=1;m<b;m++) {
                list.add(m);
            }
        }
        return list;
    }

//    public static void main(String[] args) {
//        try{
//            //List<String> months = getRecent12Months("20170510");
////            int a = DateUtil.getLastDays("20170612");
//            String date = "20170929";
//            int a = getLastDays(date);
//            System.out.println(getRecent30Days("20170929"));
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
}
