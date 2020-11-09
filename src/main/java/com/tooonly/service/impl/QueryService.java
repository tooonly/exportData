package com.tooonly.service.impl;

import com.tooonly.bean.ColumnInfo;
import com.tooonly.bean.TableInfo;
import com.tooonly.dao.IQueryDao;
import org.dom4j.Element;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

@Service("queryService")
public class QueryService {

    @PostConstruct
    private void init(){
        List<LinkedHashMap> objs = queryDao.getTestData();
        System.out.println(objs);
    }

    @Resource
    private IQueryDao queryDao;


    public List<LinkedHashMap> getDatas(String sql){
        return queryDao.getExcelData(sql);
    }

}
