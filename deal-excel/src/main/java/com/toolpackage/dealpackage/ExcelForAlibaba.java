package com.toolpackage.dealpackage;

import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelForAlibaba {
	@SuppressWarnings("rawtypes")
	public static void main(String[] args)    
	{   
 
		String targetfile = "D:\\out.xls";// 输出的excel文件名
		String worksheet = "InfoList";// 输出的excel文件工作表名
		String[] title = { "A", "A", "A","A" };// excel工作表的标题
 
		WritableWorkbook workbook;
		try {
			// 创建可写入的Excel工作薄,运行生成的文件在tomcat/bin下
			// workbook = Workbook.createWorkbook(new File("output.xls"));
 
			OutputStream os = new FileOutputStream(targetfile);
			workbook = Workbook.createWorkbook(os);
 
			WritableSheet sheet = workbook.createSheet(worksheet, 0); // 添加第一个工作表
 
			jxl.write.Label label;
			System.out.println("title:"+title.length);
			// 完成第一行标签输入
			for (int i = 0; i < title.length; i++) {
				// Label(列号,行号 ,内容 )
				label = new jxl.write.Label(i, 0, title[i]); 
				sheet.addCell(label);
			}
		
			
			//添加内容：
			String[] row = { "E", "E", "E" };// excel工作表的的行数据
			jxl.write.Label label1;
			System.out.println("row:"+row.length);
			for(int i =0;i<row.length;i++){
				label1 = new jxl.write.Label(i, 1, row[i]);
				
				sheet.addCell(label1);
			}
			
			try{
				GetStringByLocation test = new GetStringByLocation();
				FileFind filefind = new FileFind();
				
				List absdata = new ArrayList();//存放文本文件的绝对路径
				
 
				String path = "D:\\test";//文件夹路径
 
				absdata = filefind.getFileAbsolutePath(path, absdata);//获取文本文件的路径集，存放在数组中
				int j=2;//从第三行开始，写到Excel文件中
				
				for (int m = 0; m < absdata.size(); m++) {
					//每一个文件进行操作，每一个文件里面的内容都放在list中，
					List list = new ArrayList();//存放每一个文件的内容
					test.readTEXT(list, absdata.get(m).toString());					
					for (int i = 0; i < 3; i++) {
						//i表示第一列，第二列。。。。。。
						jxl.write.Label labeltemp;
//						System.out.println(list.get(i).toString());
						labeltemp = new jxl.write.Label(i, j, list.get(i).toString());
						sheet.addCell(labeltemp);							
					}
					
					j++;//从下一行开始写起
				}
				
			}catch(Exception e){
				e.printStackTrace();
			}
	        
			workbook.write();
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("end");
 
	}
 
}