package 文件流操作;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class Demo {
    @Test
    public void test1() {
        //File(String pathname):通过将给定的路径名字字符串转换为抽象路径名来创建新的File实例
        File f1 = new File("D:\\a.txt");
        System.out.println(f1);
        //File(String parent, String child):从父路径名字符串和子路径名字符串创建新的File实例
        File f2 = new File("D:", "a.txt");
        System.out.println(f2);
        //从父抽象路径名和子路径名字符串创建新的File实例
        File f3 = new File("D:");
        File f4 = new File(f3, "a.txt");
        System.out.println(f4);
    }

    @Test
    public void test2() throws IOException {
        //创建文件，文件若存在直接创建返回true，若不存在则不创建返回false
        File f1 = new File("D:\\c.txt");
        System.out.println(f1.createNewFile());

        //创建一级目录，目录若存在直接创建返回true，若不存在则不创建返回false
        File f2 = new File("D:\\FileTest");
        System.out.println(f2.mkdir());

        //创建多级目录，目录若存在直接创建返回true，若不存在则不创建返回false
        File f3 = new File("D:\\FileTest2\\a\\b");
        System.out.println(f3.mkdirs());
    }

    @Test
    public void test3() {
        File f = new File("myFile\\java.txt");
        //测试此抽象路径表示的File是否为目录
        System.out.println(f.isDirectory());
        //测试此抽象路径表示的File是否为文件
        System.out.println(f.isFile());
        //测试此抽象路径表示的File是否存在
        System.out.println(f.exists());
        //返回抽象路径名的绝对路径名字符串
        System.out.println(f.getAbsolutePath());
        //将此抽象路径名转换为路径名字符串
        System.out.println(f.getPath());
        //返回抽象路径名表示的文件或目录的名称
        System.out.println(f.getName());

        //返回抽象路径名表示的目录中的文件和目录名称字符串数组
        File f2 = new File("D:\\");
        //返回抽象路径名
        String[] list = f2.list();
        for (String s : list) {
            System.out.println(s);
        }
        //返回抽象路径名表示的目录中的文件和目录名称的File对象数组
        File[] listFiles = f2.listFiles();
        for (File file : listFiles) {
            if (file.isDirectory()) {
                System.out.println(file);
            }
        }
    }

    @Test
    public void test4() throws IOException {
        File f = new File("javatest.txt");
        System.out.println(f.createNewFile());

    }

    @Test
    public void test5() throws IOException {
        File f = new File("D:\\test2-modify\\2014213");
        System.out.println(f.mkdirs());
        File f2 = new File("D:\\test2-modify\\2014213\\t1.txt");
        System.out.println(f2.createNewFile());

    }

    @Test
    public void test6() {
        getAllFilePath(new File("D:\\"));
    }

    public void getAllFilePath(File file) {
        File[]fileArr = file.listFiles();
        if(fileArr!=null){
            for (File f : fileArr) {
                if(f.isDirectory()){
                    getAllFilePath(f);
                }else{
                    System.out.println(f.getAbsolutePath());
                }
            }
        }
    }
}
