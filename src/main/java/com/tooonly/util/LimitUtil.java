package com.tooonly.util;

import com.tooonly.build.regex.RegexUtil;

public class LimitUtil {

    private static int pageSize = 10000;

    private static String limitRegex = "LIMIT\\s+\\d*(\\s*,?\\s*\\d*)?";

    public static String getNextPageSql(String sql){
        return null;
    }

    public static int getMaxSize(String sql){
        String limitStr = RegexUtil.getLastLikeContent(sql,limitRegex);
        limitStr = limitStr.replace("LIMIT","").replaceAll("\\s","");
        System.out.println(limitStr);
        return -1;
    }

    public static void main(String[] args) {
        getMaxSize("select * from tbLender limit     10  ,  20  ;");
    }
}
