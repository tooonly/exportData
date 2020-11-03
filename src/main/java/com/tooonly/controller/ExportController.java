package com.tooonly.controller;

import com.tooonly.build.SQLSyntaxParsing;
import com.tooonly.service.impl.QueryService;
import com.tooonly.util.ExcleImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/export")
public class ExportController {

    @Resource(name = "queryService")
    private QueryService queryService;

    @RequestMapping("/excel")
    @ResponseBody
    public String exportExcel(String sql, HttpServletResponse response) throws Exception {
        sql = URLDecoder.decode(sql,"utf-8");
        List<HashMap> datas = queryService.getDatas(sql);
        String[] fields = SQLSyntaxParsing.getField(sql);
        String tableName = SQLSyntaxParsing.getTableName(sql);
        ExcleImpl.export(tableName,fields,fields,datas,response);
        return "你好！";
    }

}
