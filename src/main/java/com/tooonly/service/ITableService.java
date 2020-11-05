package com.tooonly.service;

import com.tooonly.bean.ColumnInfo;
import com.tooonly.bean.TableInfo;

public interface ITableService {

    /**
     * 获取字段备注
     * @param tableName
     * @param columnName
     * @return
     */
    String getColumnComment(String tableName,String columnName);

    /**
     * 获取多个字段的备注
     * @param tableName
     * @param columnNames
     * @return
     */
    String[] getColumnComment(String tableName,String...columnNames);

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
    TableInfo[] getTableInfos();

    /**
     * 获取某个表的字段信息
     * @param tableName
     * @return
     */
    ColumnInfo getColumnInfoByName(String tableName, String columnName);


}
