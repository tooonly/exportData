package com.tooonly.build.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtil {

    public static String getLastLikeContent(String content,String pattern){
        Pattern pat = Pattern.compile(pattern);
        Matcher matcher = pat.matcher(content);
        String lastContent = "";
        while(matcher.find()){
            String e=matcher.group(0);
            lastContent = e;
        }
        return lastContent;
    }

    public static void main(String[] args) {
        String a = getLastLikeContent("select (select * from a),b FROM  abc left join ddd on abc.a = ddd.a where abc.a = 1 order by def limit 10","FROM\\s+[a-zA-Z]*?\\s+");
        System.out.println(a);
    }
}
