package com.toolpackage.dealpackage;

import com.toolpackage.dealexcel.Tool;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;

public class ansiToUTF_8 {

    @Test
    public void deal() throws IOException
    {
        /*
         * 文件由ANSI转化为UTF-8
         * 需要用到流InputStreamReader和OutputStreamWriter
         * 这两个流有charset功能
         * */
        String dataPath = "C:\\Users\\17822\\Desktop\\广东省雨量数据201208-201512\\data";
        File rootPath = new File(dataPath);
        String[] allPackage = rootPath.list();
        for (int i = 0; i < allPackage.length; i++) {
            String secPackage = dataPath + "\\" + allPackage[i];
            System.out.println(secPackage);
            File secPath = new File(secPackage);
            String[] allTxt = secPath.list();
            File createSecPath = new File(dataPath + "-modify" + "\\" + allPackage[i]);
            System.out.println("createSecPath:" + createSecPath.mkdirs());
            for (int j = 0; j < allTxt.length; j++) {
                String txt = secPackage + "\\" + allTxt[j];
                File srcFile = new File(txt);
                File destFile = new File(dataPath + "-modify" + "\\" + allPackage[i] + "\\" + allTxt[j]);
                InputStreamReader isr = new InputStreamReader(new FileInputStream(srcFile), "GBK"); //ANSI编码
                OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(destFile), "UTF-8"); //存为UTF-8

                int len = isr.read();
                while (-1 != len) {

                    osw.write(len);
                    len = isr.read();
                }
                //刷新缓冲区的数据，强制写入目标文件
                osw.flush();
                osw.close();
                isr.close();
            }
        }
    }
    @Test
    public void txtDeal() throws IOException {
        int count = 0;
        String rootStr = "C:\\Users\\17822\\Desktop\\广东省雨量数据201208-201512\\data-modify";
//        String rootStr = "D:\\test2";
        File rootPath = new File(rootStr);
        String[] secPath = rootPath.list();
        //收集最后表信息
        ArrayList<ArrayList<String>> endExcel = new ArrayList<>();
        for (String secName : secPath) {
            System.out.println(count+"成功创建："+rootStr+"\\"+secName);
            File secFile = new File(rootStr+"\\"+secName);
            String[] txtPath = secFile.list();
            for (String txtName : txtPath) {
                String path = rootStr+"\\"+secName+"\\"+txtName;
                FileReader txtFR = new FileReader(path);
                BufferedReader txtBR = new BufferedReader(txtFR);
                String line;
                //去掉第一行
                line = txtBR.readLine();
                while((line = txtBR.readLine()) != null){
                    //process the line
                    String[] rowStr =line.split("\\t");
                    ArrayList<String> row = new ArrayList<>();
                    String txtReplace = txtName.replaceAll(".txt","");
                    row.add(txtReplace);
                    for (String s : rowStr) {
                        row.add(s);
                    }
                    endExcel.add(row);
                }
            }
//            if(count%3==0){
//                Tool.createExcel("POIDemo","D:\\data"+count/4+".xls",endExcel);
//
//                endExcel = new ArrayList<>();
//            }
//            count++;
            Tool.createExcel("POIDemo","D:\\data"+10+".xls",endExcel);
            break;
        }
    }
}
