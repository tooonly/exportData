package com.tooonly.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

public interface IQueryDao {

    @Select("${sql}")
    public List<HashMap> getExcelData(String sql);

}
