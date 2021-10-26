package com.toolpackage.dealexcel;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class Tool {

    //获取excel表格信息,表中每个元素格式为Cell
    public static ArrayList<ArrayList<ArrayList<Cell>>> getExcel( Workbook inputWorkbook) {
        //获取excel表中所有页
        ArrayList<ArrayList<ArrayList<Cell>>> totalExcel = new ArrayList<>();
        //获取整个表中间的页
        for(int i = 0;i<inputWorkbook.getNumberOfSheets();i++){
            int totalNum =0;
            int num = 0;
            Sheet sheet = inputWorkbook.getSheet(i);
            //获取一页中的每一行
            ArrayList<ArrayList<Cell>> sheetData = new ArrayList<>();
            for(int j = 1;j<sheet.getRows();j++){
                int temp=0;//每行标志位
                //获取一行中的每个元素
                ArrayList<Cell> rowData = new ArrayList<>();
                totalNum++;
                for(int k =0;k<sheet.getColumns();k++){
                    rowData.add(sheet.getCell(k,j));
                    if(sheet.getCell(k,j).getContents().equals("-")&&temp==0){
                        temp=1;
                        num++;
                    }
                }
                sheetData.add(rowData);
            }
            totalExcel.add(sheetData);
            System.out.println((2015+i)+"年数据总数："+totalNum+"  其中缺失数据的行数:"+num);
        }
        return totalExcel;
    }



    //创建excel表并输入数据
    public static void createExcel (String sheetName , String outputPath , ArrayList<ArrayList<String>> inputData) {
        try {
            XSSFWorkbook outputWorkbook = new XSSFWorkbook();
            XSSFSheet outSheet = outputWorkbook.createSheet(sheetName);
            FileOutputStream outputStream = new FileOutputStream(outputPath);
            for(int i = 1;i<inputData.size();i++){
                XSSFRow outputRow = outSheet.createRow(i);
                ArrayList<String> rowData = inputData.get(i-1);
                for(int j =0 ;j<rowData.size();j++){
                    outputRow.createCell(j).setCellValue(rowData.get(j));
                }
            }
            outputWorkbook.write(outputStream);
            outputWorkbook.close();
            outputStream.close();
        } catch (IOException e){
            e.printStackTrace();
        }

    }
}
