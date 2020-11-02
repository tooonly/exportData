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
}
