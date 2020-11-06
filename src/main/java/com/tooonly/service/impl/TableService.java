package com.tooonly.service.impl;

import com.tooonly.bean.ColumnInfo;
import com.tooonly.bean.TableInfo;
import com.tooonly.dao.IQueryDao;
import com.tooonly.service.ITableService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TableService implements ITableService {

    private static Map<String,TableInfo> tableMap;

    private static Map<String,ColumnInfo> columnMap;

    @Resource
    private IQueryDao queryDao;

    @PostConstruct
    private void init(){
        List<TableInfo> tables = getTables();
        parseTable(tables);
        List<ColumnInfo> columns = getColumns();
        parseColumn(columns);
    }

    private void parseTable(List<TableInfo> tables){
        tableMap = new HashMap<String,TableInfo>(tables.size()<<1);
        for (TableInfo tableInfo:
             tables) {
            tableMap.put(tableInfo.getTableName(),tableInfo);
        }
    }

    private void parseColumn(List<ColumnInfo> columns){
        columnMap = new HashMap<String,ColumnInfo>(columns.size()<<1);
        for (ColumnInfo columnInfo:
             columns) {
            columnMap.put(columnInfo.getTableName()+"."+columnInfo.getColumnName(),columnInfo);
        }
    }

    /**
     * 获取字段备注
     *
     * @param tableName
     * @param columnName
     * @return
     */
    @Override
    public String getColumnComment(String tableName, String columnName) {
        String name = tableName+"."+columnName;
        if(!columnMap.containsKey(name)){
            return columnName;
        }
        String comment = columnMap.get(name).getColumnComment();
        return StringUtils.isBlank(comment) ? columnName : comment;
    }

    /**
     * 获取多个字段的备注
     * @param tableName
     * @param columnNames
     * @return
     */
    @Override
    public String[] getColumnComment(String tableName,String...columnNames){
        String[] comments = new String[columnNames.length];
        for (int i = 0;i < columnNames.length;i++) {
            comments[i] = getColumnComment(tableName,columnNames[i]);
        }
        return comments;
    }

    /**
     * 获取表格备注
     *
     * @param tableName
     * @return
     */
    @Override
    public String getTableComment(String tableName) {
        if(!tableMap.containsKey(tableName)){
            return tableName;
        }
        String tableComment = tableMap.get(tableName).getTableComment();
        return StringUtils.isBlank(tableComment) ? tableName : tableComment;
    }

    /**
     * 获取所有表信息
     *
     * @return
     */
    @Override
    public TableInfo[] getTableInfos() {
        return tableMap.values().toArray(new TableInfo[tableMap.size()]);
    }

    /**
     * 获取某个表的字段信息
     *
     * @param tableName
     * @return
     */
    @Override
    public ColumnInfo getColumnInfoByName(String tableName,String columnName) {
        return columnMap.get(tableName+"."+columnName);
    }

    public List<TableInfo> getTables(){
        List<TableInfo> list = queryDao.listTable();
        System.out.println(list);
        return list;
    }

    public List<ColumnInfo> getColumns(){
        List<ColumnInfo> list = queryDao.listTableColumn("deal_record");
        System.out.println(list);
        return list;
    }
}
