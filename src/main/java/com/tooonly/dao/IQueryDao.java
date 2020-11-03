package com.tooonly.dao;

import com.tooonly.bean.ColumnInfo;
import com.tooonly.bean.TableInfo;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;
import java.util.List;

public interface IQueryDao {

    @Select("select * from information_schema.TABLES where TABLE_SCHEMA=(select database())")
    List<TableInfo> listTable();

    @Select("select * from information_schema.COLUMNS where TABLE_SCHEMA = (select database())")
    List<ColumnInfo> listTableColumn(String tableName);

    @Select("${sql}")
    public List<HashMap> getExcelData(String sql);

}
