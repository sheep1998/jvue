package com.jvue.backend.util;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;

public class XlsxUtil {
    public ArrayList<String[]> readXlsx(String filename,String sheetname) throws IOException {
        ArrayList<String[]> content = new ArrayList<>();
        String path = "C:\\Users\\1535725170\\Documents\\GitHub\\jvue\\xlsx\\" + filename;
        InputStream inputStream = new FileInputStream(new File(path));
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheet(sheetname);
        //sheet = workbook.getSheetAt(0);
        for(Row row:sheet){
            //表头跳过
            if(row.getRowNum()==0){
                continue;
            }
            //读取方式
            Cell cell1 = (Cell)row.getCell(0);
            cell1.setCellType(CellType.STRING);
            String s1 = cell1.getStringCellValue();

            Cell cell2 = (Cell)row.getCell(1);
            cell2.setCellType(CellType.STRING);
            String s2 = cell2.getStringCellValue();

            String[] item = {s1,s2};
            content.add(item);
        }
        workbook.close();
        System.out.println("文件"+filename+" 行数为："+String.valueOf(content.size()));
        return content;
    }

    public void writeXlsx(String filename,String[] title,ArrayList<String[]> content) throws IOException {
        String path = "C:\\Users\\1535725170\\Documents\\GitHub\\jvue\\xlsx\\" + filename;
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet();

        //标题
        Row titleRow = sheet.createRow(0);
        for (int i=0;i<title.length;i++){
            titleRow.createCell(i).setCellValue(title[i]);
        }

        for(String[] item:content){
            int lastRowNum = sheet.getLastRowNum();
            Row dataRow = sheet.createRow(lastRowNum+1);
            for(int i=0;i<item.length;i++){
                dataRow.createCell(i).setCellValue(item[i]);
            }
        }
        FileOutputStream outputStream = new FileOutputStream(path);
        workbook.write(outputStream);
        outputStream.close();
    }
}
