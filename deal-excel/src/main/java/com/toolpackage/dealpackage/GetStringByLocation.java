package com.toolpackage.dealpackage;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
 
 
 
public class GetStringByLocation {
	
	/**
	 * 按照行读取文本文件的数据，每一行存入到list一维数组中
	 * 
	 * @param list 用来存储读取的数据
	 * @param destFile  读取的文件路径
	 * @throws Exception  读取文件出错  抛出异常
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void readTxt(List list, String destFile) throws Exception {
		try{
			BufferedReader reader = new BufferedReader(new FileReader(destFile));
			String line = reader.readLine();
 
			while (line != null) {
				list.add(line);
				line = reader.readLine();
			}
 
			reader.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param list  存放读取的结果，按照每行的数据格式  \t读取每一个字段
	 * @param pathName  读取的文本文件路径
	 * @throws Exception  抛出异常
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void readTEXT(List list,String pathName) throws Exception{
		String text = null;
		try
		{
		    InputStreamReader read1 = new InputStreamReader(new FileInputStream(pathName));
		    BufferedReader br1 = new BufferedReader(read1);     
		    while((text = br1.readLine())!=null)
		    {
		        /***相应操作***/
		    	System.out.println(text);
		    	String[] ss =text.split("\t");
 
		    	for(int j=0;j<ss.length;j++){
		    		System.out.println(ss[j]);
		    		list.add(ss[j]);
		    	}
	    	
		    	text = br1.readLine();
		    }
		    br1.close();        
		} 
		catch(FileNotFoundException e) 
		{  
		    System.out.println(e); 
		} 
		catch(IOException e) 
		{  
		    System.out.println(e); 
		}
	}
	
 
    /**
     * 从文件读取数据
     * @param path 文件路径
     * @return 文件数据
     */
    public static List<String> getFileData(String path)
    {
        List<String> result = new ArrayList<String>();
        FileReader fr = null;
        BufferedReader br = null;
 
        try
        {
            fr = new FileReader(path);
            br = new BufferedReader(fr);
            String str;
 
            while((str = br.readLine()) != null)
            {
                result.add(str);
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if(fr != null)
                {
                    fr.close();
                }
 
                if(br != null)
                {
                    br.close();
                }
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }
 
        return result;
    }
}