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

    @Resource
    private IQueryDao queryDao;


    public List<HashMap> getDatas(String sql){
        return queryDao.getExcelData(sql);
    }

}
