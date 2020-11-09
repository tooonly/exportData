package com.tooonly.controller;

import com.tooonly.build.MySQLSyntaxParsing;
import com.tooonly.build.SQLSyntaxParsing;
import com.tooonly.service.ITableService;
import com.tooonly.service.impl.QueryService;
import com.tooonly.util.ExcleImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/export")
public class ExportController {

    @Resource(name = "queryService")
    private QueryService queryService;

    @Resource
    private ITableService tableService;

    @RequestMapping("/excel")
    @ResponseBody
    public String exportExcel(String sql,String aes, HttpServletResponse response) throws Exception {
        Set<String> decodes = new HashSet<String>();
        if(StringUtils.isNotBlank(aes)){
            for(String decode:aes.split(",")){
                decodes.add(decode);
            }
        }
        sql = URLDecoder.decode(sql,"utf-8");
        List<HashMap> datas = queryService.getDatas(sql);
        Assert.notEmpty(datas,"未查詢到數據");
        String[] fields = MySQLSyntaxParsing.getField(sql);
        String tableName = MySQLSyntaxParsing.getTableName(sql);
        String[] fieldsComment = tableService.getColumnComment(tableName,fields);
        tableName = tableService.getTableComment(tableName);
        ExcleImpl.export(tableName,fieldsComment,fields,datas,decodes,response);
        return "你好！";
    }

}
