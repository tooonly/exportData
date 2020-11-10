package com.tooonly.service.impl;

import com.tooonly.bean.Excel;
import com.tooonly.build.method.HandleParamMethod;
import com.tooonly.build.method.MethodHandle;
import com.tooonly.dao.IQueryDao;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.*;

@Service("queryService")
public class QueryService {

    @PostConstruct
    private void init(){
        List<LinkedHashMap> objs = queryDao.getTestData();
        System.out.println(objs);
    }

    @Resource
    private IQueryDao queryDao;


    public Excel getDatas(String sql,List<MethodHandle> methods){
        List<LinkedHashMap<String,String>> list = queryDao.getExcelData(sql);
        if(list == null || list.isEmpty()){
            return null;
        }
        List<List<Object>> datas = new ArrayList<>(list.size());
        String[] names = null;
        for(int i = 0;i < list.size();i++){
            Map<String,String> map = list.get(i);
            if(i == 0){
                Set<String> set = map.keySet();
                names = set.toArray(new String[set.size()]);
            }
            List<Object> data = new ArrayList<>(map.size());
            for(Map.Entry<String,String> entry:map.entrySet()){
                data.add(entry.getValue());
            }
            datas.add(data);
        }
        HandleParamMethod.invoke(methods,datas);
        return new Excel(names,datas);
    }

}
