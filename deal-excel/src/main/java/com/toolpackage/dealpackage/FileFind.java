package com.toolpackage.dealpackage;

import java.io.File;
import java.util.List;

public class FileFind {

	/**
     * 利用字符串的.endsWith()来判断后缀名
     * 利用文件类的.listFiles()来获取一个文件夹下所有文件
     * 
     * @param path
     * @param data
     * @return
     */
    @SuppressWarnings({"rawtypes", "rawtypes", "unchecked"})
	private static List getData(String path, List data) {
    	try{
			File f = new File(path);
			if (f.isDirectory()) {
				File[] fs = f.listFiles();
				for (int i = 0; i < fs.length; i++) {
					// 如果该文件夹下面还有文件夹，那么继续往下面去找，递归
					data = getData(fs[i].getPath(), data);
				}
			} else if (f.getName().endsWith(".txt")) {
				// 匹配文本文件，*.txt
				data.add(f.getName());// 得到相对路径
			}
			
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return data;
    }
    
    /**
     * 
     * @param path
     * @param data
     * @return  data  返回文件的绝对路径
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public static List getFileAbsolutePath(String path, List data) {
    	try{
			File f = new File(path);
			if (f.isDirectory()) {
				File[] fs = f.listFiles();
				for (int i = 0; i < fs.length; i++) {
					// 如果该文件夹下面还有文件夹，那么继续往下面去找，递归
					data = getFileAbsolutePath(fs[i].getPath(), data);
				}
			} else if (f.getName().endsWith(".txt")) {
				// 匹配文本文件，*.txt
				data.add(f.getAbsolutePath().toString());// 得到相对路径
//				System.out.println(f.getAbsolutePath());// 得到绝对路径
			}
			
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return data;
    }
}