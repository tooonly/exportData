package com.tooonly.util;

import com.tooonly.bean.Person;
import org.apache.poi.hssf.usermodel.*;

import javax.servlet.ServletOutputStream;
import java.util.HashMap;
import java.util.List;


public class ExcleImpl {

    public static void export(String[] heads, String[] bodyNames, List<HashMap> datas, ServletOutputStream out) throws Exception{
        try{
            // 第一步，创建一个workbook，对应一个Excel文件
            HSSFWorkbook workbook = new HSSFWorkbook();
            // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
            HSSFSheet hssfSheet = workbook.createSheet("sheet1");
            //第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
            // 第四步，创建单元格，并设置值表头 设置表头居中
            HSSFCellStyle hssfCellStyle = workbook.createCellStyle();
            //居中样式
            hssfCellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
            //第五步，创建表头
            createHead(heads,hssfSheet,hssfCellStyle);
            //第六步，填充数据
            createBodys(bodyNames,datas,hssfSheet);
            // 第七步，将文件输出到客户端浏览器
            try {
                workbook.write(out);
                out.flush();
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }catch(Exception e){
            e.printStackTrace();
            throw new Exception("导出信息失败！");
        }
    }

    private static void createHead(String[] heads,HSSFSheet hssfSheet,HSSFCellStyle hssfCellStyle){
        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
        HSSFRow row = hssfSheet.createRow(0);
        for (int i = 0; i < heads.length; i++) {
            HSSFCell hssfCell = row.createCell(i);//列索引从0开始
            hssfCell.setCellValue(heads[i]);//列名1
            hssfCell.setCellStyle(hssfCellStyle);//列居中显示
        }
    }

    private static void createBodys(String[] bodyNames,List<HashMap> datas,HSSFSheet hssfSheet){
        for (int i = 0; i < datas.size(); i++) {
            HSSFRow row = hssfSheet.createRow(i+1);
            HashMap map = datas.get(i);
            // 第六步，创建单元格，并设置值
            createBody(bodyNames,map,row);
        }

    }

    private static void createBody(String[] bodyNames,HashMap map,HSSFRow row){
        // 第六步，创建单元格，并设置值
        for(int j = 0;j < bodyNames.length;j++){
            String field = bodyNames[j];
            row.createCell(j).setCellValue(map.get(field.trim())+"");
        }
    }
}