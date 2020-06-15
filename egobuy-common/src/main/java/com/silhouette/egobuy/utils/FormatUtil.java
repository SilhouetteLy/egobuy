package com.silhouette.egobuy.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashSet;
import java.util.Set;

/**
 * @author liuyi
 * @version 1.0
 * @create -- 15:01
 * @description:
 */
public class FormatUtil {

    //------------------------------   格式化数值   ---------------------------------
    /** 把Double类型的数值转化成"###,###.00"的字符串   */
    public static String toStringWithDecimal(Double price) {
        try {return  new DecimalFormat("###,###.00").format(price);} catch (Exception pe) { return null;}
    }
    /** 把String类型的数值转化成"###,###.00"的字符串   */
    public static String toStringWithDecimal(String decimal) {
        try {return  new DecimalFormat("###,###.00").format(new Double(decimal));} catch (Exception pe) { return null;}
    }
    /** 把String类型的货币数值转化成"###,###"的字符串   */
    public static String toStringWithoutDecimal(String nodecimal) {
        try {return  new DecimalFormat("###,###").format(new Double(nodecimal));} catch (Exception pe) { return null;}
    }
    /** 把类型为"###,###.00"的字符串转化成Double类型的货币数值 */
    public static Double toDoubleCurrency(String price) {
        try {return new Double(new DecimalFormat("###,###.00").parse(String.valueOf(price)).doubleValue());} catch (Exception pe) { return null;}
    }

    /** 把String类型的数值转化成"###.00"的字符串   */
    public static String toStrWithDecimal(String decimal) {
        try {return  new DecimalFormat("###.00").format(new Double(decimal));} catch (Exception pe) { return null;}
    }

    /** 把类型为"###.00"的字符串转化成Double类型的货币数值 */
    public static Double toDoubleData(String price) {
        try {return new Double(new DecimalFormat("###.00").parse(String.valueOf(price)).doubleValue());} catch (Exception pe) { return null;}
    }
    //------------------------------   char型数值与整型数据间的转换   ---------------------
    public static int toInt(char c){try{return c;}catch(Exception e){return 0;}}
    public static int toChar(int c){try{return c;}catch(Exception e){return 0;}}

    //------------------------------   Boolean型数值与   ---------------------
    /** 通用转换：true--> 1 false-->0  */
    public static int toIntYes2One(boolean status){
        if(status){
            return 1;
        }
        return 0;
    }

    public static boolean toBooleanOne2Yes(int status){
        if(status == 1) {
            return true;
        }
        return false;
    }

    //------------------------------  Boolean型数值与数据库字典中定义的值相互转换  ---------------------
    public static boolean toBoolean(String status){
        if(ValidateUtils.isBlank(status)) {
            return false;
        }
        if("TRUE".equals(status.toUpperCase().trim())) {
            return true;
        }
        return false;
    }

    //-------------------------   通用类型转换：先转成Double在根据需求转换   -------------
    //简单类型
    public static int     toInt(Object obj) {       try{return toDouble(obj).intValue();}catch(Exception e){return 0;} }
    public static long    toLongSmp(Object obj) {   try{return toDouble(obj).longValue();}catch(Exception e){return 0;}}
    public static float   toFloatSmp(Object obj) {  try{return toDouble(obj).floatValue();}catch(Exception e){return 0;}}
    public static double  toDoubleSmp(Object obj) { try{return toDouble(obj).doubleValue();}catch(Exception e){return 0;}}

    //引用类型
    public static Integer toInteger(Object obj) {   try{return toDouble(obj).intValue();}catch(Exception e){return null;}}
    public static Long    toLong(Object obj) {      try{return toDouble(obj).longValue();}catch(Exception e){return null;}}
    public static Float   toFloat(Object obj) {     try{return toDouble(obj).floatValue();}catch(Exception e){return null;}  }
    public static Double  toDouble(Object obj){     try{return new Double(obj.toString());}catch(Exception e){return null;} }

    public static String  toString(Object obj){
        try{
            if(obj == null){
                return null;
            }
            if(obj instanceof Double){
                return new DecimalFormat("0.00").format(obj);
            }
            if(obj instanceof Float){
                return new DecimalFormat("0.00").format(obj);
            }
            return obj.toString();
        }catch(Exception e){return null;}
    }

    public static String  toString6(Object obj){
        try{
            if(obj instanceof Double){
                return new DecimalFormat("0.000000").format(obj);
            }
            if(obj instanceof Float) {
                return new DecimalFormat("0.000000").format(obj);
            }
            return obj.toString();
        }catch(Exception e){return null;}
    }
    public static Set toSet(Object obj){
        Set set = new HashSet();
        try{
            String[] cities = obj.toString().split("/");
            for(int i=0;i<cities.length;i++)
                set.add(cities[i]);
            return set;
        }catch(Exception e){return set;}
    }

    /**
     * BigDecimal转换为String
     *
     * @param number BigDecimal数字
     * @param length 字符串长度
     * @return
     */
    public static String format(BigDecimal number, int length) {
        String str = "";

        if (length == 0) {
            return "";
        }
        NumberFormat formatter = NumberFormat.getNumberInstance();
        formatter.setMinimumIntegerDigits(length);

        //去除结果中的","
        try {
            str = formatter.format(number).replace(",", "");
        } catch (Exception e) {
            return "";
        }

        return str;
    }
}
