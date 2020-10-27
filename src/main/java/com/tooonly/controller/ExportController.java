package com.tooonly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/export")
public class ExportController {

    @RequestMapping("/excel")
    @ResponseBody
    public String exportExcel(String sql){
        return "你好！";
    }

}
