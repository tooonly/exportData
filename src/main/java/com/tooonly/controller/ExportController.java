package com.tooonly.controller;

import com.tooonly.bean.Excel;
import com.tooonly.build.SQLSyntaxParsing;
import com.tooonly.build.method.HandleParamMethod;
import com.tooonly.build.method.MethodHandle;
import com.tooonly.build.sql.SQLConfig;
import com.tooonly.service.ITableService;
import com.tooonly.service.impl.QueryService;
import com.tooonly.util.ExcelImpl;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLDecoder;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/export")
public class ExportController {

    @Resource(name = "queryService")
    private QueryService queryService;

    @Resource
    private ITableService tableService;

    @Resource(name = SQLConfig.localSQLDriver)
    private SQLSyntaxParsing sqlSyntaxParsing;

    @RequestMapping("/excel")
    @ResponseBody
    public String exportExcel(String sql, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String, String[]> paramMap = request.getParameterMap();
        sql = URLDecoder.decode(sql,"utf-8");
        List<MethodHandle> methods = HandleParamMethod.build(paramMap);
        Excel excel = queryService.getDatas(sql,methods);
        Assert.notNull(excel,"未查询到数据");
        //String[] fields = sqlSyntaxParsing.getField(sql);
        String tableName = sqlSyntaxParsing.getTableName(sql);
        //String[] fieldsComment = tableService.getColumnComment(tableName,fields);
        tableName = tableService.getTableComment(tableName);
        ExcelImpl.export(tableName,excel,response);
        return "你好！";
    }

}
