package com.tooonly.build;

import com.tooonly.build.regex.RegexUtil;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class SQLSyntaxParsing {

    private static String fromRegex = "FROM\\s+[a-zA-Z]*?\\s+";

    public String[] getField(String sql){
        String fromContent = RegexUtil.getLastLikeContent(sql,fromRegex);
        String[] fields = sql.substring(0,sql.lastIndexOf(fromContent)).replace("SELECT","").trim().split(",");
        for (int i = 0;i<fields.length;i++) {
            fields[i] = getAsName(fields[i]);
        }
        return fields;
    }

    public String getTableName(String sql){
        String fromContent = RegexUtil.getLastLikeContent(sql,fromRegex);
        return fromContent.replace("FROM","").trim();
    }

    public String getAsName(String field){
        if(field.toLowerCase().indexOf("AS")<0){
            return field;
        }
        String asContent = field.split("AS")[1].trim();
        return asContent;
    }

    public void main(String[] args) throws Exception {
        String sql = "select%20strLoginId,strMobile,strName,strIdentity%20from%20tbLender%20limit%2010";
        sql = URLDecoder.decode(sql,"utf-8");
        System.out.println(getField(sql));
    }
}
