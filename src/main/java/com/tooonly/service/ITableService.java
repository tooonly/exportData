package com.tooonly.service;

public interface ITableService {

    /**
     * 获取字段备注
     * @param tableName
     * @param columnName
     * @return
     */
    String getColumnComment(String tableName,String columnName);

    /**
     * 获取表格备注
     * @param tableName
     * @return
     */
    String getTableComment(String tableName);

    /**
     * 获取所有表信息
     * @return
     */
    String getTableInfos();

    /**
     * 获取某个表的字段信息
     * @param tableName
     * @return
     */
    String getColumnInfoByTable(String tableName);


}
