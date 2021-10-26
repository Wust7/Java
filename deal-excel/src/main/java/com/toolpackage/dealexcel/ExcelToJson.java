package com.toolpackage.dealexcel;

import com.alibaba.fastjson.JSONObject;
import jxl.Cell;
import jxl.NumberCell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class ExcelToJson {
    public static void main(String[] args) {
        String[] dataEnum = {
                "driverName","monitorPoint","monitorTime","waterTemperature","pHValue",
                "dissolvedOxygen","permanganateIndex","COD","BOD","AD","ZL",
                "ZD","Cu","Zn","FX","Se","As","Hg","Cd","Cr6+","Pb","QHW","HHS",
                "SYL","LAS","SHW","FC"
        };
        try{
            //获取无经纬度的水资源成分表
            Workbook waterWorkbook = Workbook.getWorkbook(new File("G:\\2015-2019年监测数据（中国地质大学提供数据）.xls"));
            ArrayList<ArrayList<ArrayList<Cell>>> waterExcel =Tool.getExcel(waterWorkbook);

            //获取经纬度表数据,并制成HashMap表
            Workbook gnotes = Workbook.getWorkbook(new File("G:\\经纬度.xls"));
            ArrayList<ArrayList<ArrayList<Cell>>> gnotesExcel = Tool.getExcel(gnotes);
            ArrayList<ArrayList<Cell>> gnotesSheet = gnotesExcel.get(0);
            HashMap<String,String> gnotesMap = new HashMap<>();
            //取i=0是因为原表第一列有编号
            for(int i = 0;i<gnotesSheet.size();i++){
                String key = gnotesSheet.get(i).get(2).getContents()+gnotesSheet.get(i).get(3).getContents();
                String value = gnotesSheet.get(i).get(4).getContents()+","+gnotesSheet.get(i).get(5).getContents();
                gnotesMap.put(key,value);
            }
            //收集最后表信息
            ArrayList<ArrayList<String>> endExcel = new ArrayList<>();

            //收集无经纬度
            HashSet<ArrayList<String>> noGnotes = new HashSet<>();

            for(ArrayList<ArrayList<Cell>> waterSheet:waterExcel){
                for(ArrayList<Cell> row:waterSheet){
                    ArrayList<String> endRow = new ArrayList<>();
                    JSONObject jsonObject = new JSONObject();
                    String s = row.get(0).getContents()+row.get(1).getContents();
                    String gnotesValue =gnotesMap.get(s);
                    if(gnotesValue==null){
                        ArrayList<String> stringArrayList = new ArrayList<>();
                        stringArrayList.add(row.get(0).getContents());
                        stringArrayList.add(row.get(1).getContents());
                        noGnotes.add(stringArrayList);
                    }
                    //此处可以加一个无经纬度的表
                    for(int i =0;i<row.size();i++){
                        if(i<9){
                            endRow.add(row.get(i).getContents());
                        }else {
//                            jsonObject.put(dataEnum[i],row.get(i).getContents().toString());
                            if (i!=15&&i!=16&&i!=17&&i!=18&&i!=20){
                                jsonObject.put(dataEnum[i],row.get(i).getContents().toString());
                            } else {
                                if(!row.get(i).getContents().equals("-")){
                                    BigDecimal bigDecimal = new BigDecimal(((NumberCell)row.get(i)).getValue());
                                    String f="";
                                    if(i==15||i==16){
                                        f = bigDecimal.setScale(4,BigDecimal.ROUND_HALF_UP).toPlainString();
                                    }else{
                                        f = bigDecimal.setScale(5,BigDecimal.ROUND_HALF_UP).toPlainString();
                                    }

                                    jsonObject.put(dataEnum[i],f);
                                } else{
                                    jsonObject.put(dataEnum[i],"-");
                                }
                            }
                        }
                    }
                    endRow.add(9,jsonObject.toString());
                    endRow.add(10,gnotesValue);
                    endExcel.add(endRow);
                }
            }
            Tool.createExcel("POIDemo","G:\\并入经纬度后的总表.xls",endExcel);
            ArrayList<ArrayList<String>> arrayList = new ArrayList<>();
            for(ArrayList<String> a:noGnotes){
                arrayList.add(a);
            }
            Tool.createExcel("POIDemo","G:\\无经纬度表.xls",arrayList);
            waterWorkbook.close();
            gnotes.close();
        } catch(IOException e){
            e.printStackTrace();
        }catch (BiffException e){
            e.printStackTrace();
        }

    }
}
