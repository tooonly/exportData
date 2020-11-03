package com.tooonly.build;

public class SQLSyntaxParsing {

    public static String[] getField(String sql){
        String[] fields = sql.split("from")[0].replace("select","").split(",");
        for (String field:
             fields) {
            if(field.indexOf("as") > -1){
                field = field.split("as")[1].trim();
            }
        }
        return fields;
    }

    public static String getTableName(String sql){
        return sql.split("from")[1].trim().split(" ")[0];
    }

    public static void main(String[] args) {
        System.out.println(getTableName("select%20strLoginId,strMobile,strName,strIdentity%20from%20tbLender%20limit%2010"));
    }
}
