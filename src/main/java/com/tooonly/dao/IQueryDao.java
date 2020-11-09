package com.tooonly.dao;

import com.tooonly.bean.ColumnInfo;
import com.tooonly.bean.TableInfo;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.ResultMapping;
import org.dom4j.Element;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public interface IQueryDao {

    @Select("select * from information_schema.TABLES where TABLE_SCHEMA=(select database())")
    List<TableInfo> listTable();

    @Select("select * from information_schema.COLUMNS where TABLE_SCHEMA = (select database())")
    List<ColumnInfo> listTableColumn(String tableName);

    @Select("${sql}")
    public List<LinkedHashMap> getExcelData(String sql);

    @Select("select * from tbLender limit 10")
    public List<LinkedHashMap> getTestData();

}
