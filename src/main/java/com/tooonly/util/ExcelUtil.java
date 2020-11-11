package com.tooonly.util;

import com.tooonly.bean.Excel;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.List;


public class ExcelUtil {

    public static Workbook createExcel(String tableName, Excel excel) throws Exception{
        // 第一步，创建一个workbook，对应一个Excel文件
        Workbook workbook = new XSSFWorkbook ();
        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
        Sheet hssfSheet = workbook.createSheet("sheet1");
        //第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
        // 第四步，创建单元格，并设置值表头 设置表头居中
        CellStyle hssfCellStyle = workbook.createCellStyle();
        //居中样式
        hssfCellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        //第五步，创建表头
        createHead(excel.getHeads(),hssfSheet,hssfCellStyle);
        //第六步，填充数据
        createBodys(excel.getBodys(),hssfSheet);
        // 第七步，将文件输出到客户端浏览器
        return workbook;
    }

    private static void createHead(String[] heads,Sheet sheet,CellStyle hssfCellStyle){
        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
        Row row = sheet.createRow(0);
        for (int i = 0;i < heads.length;i++) {
            Cell cell = row.createCell(i);//列索引从0开始
            cell.setCellValue(heads[i]);//列名1
            cell.setCellStyle(hssfCellStyle);//列居中显示
        }
    }

    private static void createBodys(List<List<Object>> datas, Sheet sheet){
        for (int i = 0; i < datas.size(); i++) {
            Row row = sheet.createRow(i+1);
            List<Object> data = datas.get(i);
            // 第六步，创建单元格，并设置值
            createBody(data,row);
        }

    }

    private static void createBody(List<Object> data,Row row){
        // 第六步，创建单元格，并设置值
        for(int i = 0;i < data.size();i++){
            row.createCell(i).setCellValue(data.get(i)+"");
        }
    }

}