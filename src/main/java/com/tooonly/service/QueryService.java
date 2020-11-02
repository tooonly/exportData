package com.tooonly.service;

import com.tooonly.dao.IQueryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public class QueryService {

    @Autowired
    private IQueryDao queryDao;

    public List<HashMap> getDatas(String sql){
        return queryDao.getExcelData(sql);
    }
}
