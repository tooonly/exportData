package com.tooonly.service.impl;

import com.tooonly.bean.ColumnInfo;
import com.tooonly.bean.TableInfo;
import com.tooonly.dao.IQueryDao;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service("queryService")
public class QueryService {

    @PostConstruct
    private void init(){
        getTables();
    }

    @Resource
    private IQueryDao queryDao;

    public List<TableInfo> getTables(){
        List<TableInfo> list = queryDao.listTable();
        System.out.println(list);
        getTableInfos();
        return list;
    }

    public List<ColumnInfo> getTableInfos(){
        List<ColumnInfo> list = queryDao.listTableColumn("deal_record");
        System.out.println(list);
        return list;
    }

    public List<HashMap> getDatas(String sql){
        return queryDao.getExcelData(sql);
    }

}
