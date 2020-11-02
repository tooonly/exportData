package com.tooonly.controller;

import com.tooonly.build.SQLSyntaxParsing;
import com.tooonly.dao.IQueryDao;
import com.tooonly.service.QueryService;
import com.tooonly.util.ExcleImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/export")
public class ExportController {

    @Resource
    private QueryService queryService;

    @RequestMapping("/excel")
    @ResponseBody
    public String exportExcel(String sql, HttpServletResponse response) throws Exception {
        ServletOutputStream out = response.getOutputStream();
        List<HashMap> datas = queryService.getDatas(sql);
        String[] fields = SQLSyntaxParsing.getField(sql);
        ExcleImpl.export(fields,fields,datas,out);
        return "你好！";
    }

}
