package 文件流操作;

import java.io.*;
import java.util.*;


public class betyStream {
    /**
     * 换行识别问题：
     * windows：\r\n
     * Linux:\n
     * mac:\r
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        FileOutputStream fos = new FileOutputStream("a.txt");
//        // 等价于
//        File file = new File("a.txt");
//        FileOutputStream fos2 = new FileOutputStream(file);
//        FileOutputStream fos3 = new FileOutputStream(new File("a.txt"));
//
//
//        // 将字节写入文件输出流
////        fos.write(97); //ASCII 97:a
////        fos.write(57);
//
//        // 写入字节数组
//        byte[]bys = {97,23,12,34,21};
//        //getBytes():返回字符串对应字节数组
//        byte[] bys2 = "abcd".getBytes();
////        fos.write(bys);
////        fos.write(bys2,1,3);
//        // 所有IO操作都要释放资源
//        //close:关闭并释放资源

//        FileOutputStream fos4 = new FileOutputStream("a.txt",true);
////        FileOutputStream fos = new FileOutputStream("a.txt");
//        for (int i = 0; i < 10; i++) {
//            // 换行
//            fos4.write("hello2".getBytes());
//            fos4.write("\r\n".getBytes());
//        }


//        fos.close();
//        fos4.close();
//
//        FileInputStream fis = new FileInputStream("a.txt");
//        // 读取一个字节
////        int by = fis.read();
//////        System.out.println((char)by);
////        //如果文件到了末尾，返回值为-1
////        while(by!=-1){
////            System.out.println((char)by);
////            by = fis.read();
////        }
//        int by2;
//        while((by2=fis.read())!=-1){
//            System.out.print((char)by2);
//        }
//        fis.close();
//        FileOutputStream fos = new FileOutputStream("b.txt");
//        FileInputStream fis = new FileInputStream("a.txt");
//        int by;
//        while((by=fis.read())!=-1){
//            fos.write(by);
//        }
//
//
//        fos.close();
//        fis.close();
//
//        FileInputStream fis = new FileInputStream("a.txt");
//        /*
//            第一次：hello
//            第二次：\r\nwor
//            第三次：ld
//         */
//        byte[] by = new byte[5];
//        // 读取一个字节数组的字符
//        int len = fis.read(by);
//        // 将字节数组转换为字符串
//        System.out.println(new String(by));
//        len = fis.read(by);
//        System.out.println(len);
//        // 将字节数组转换为字符串
//        System.out.println(new String(by));
//        len = fis.read(by);
//        System.out.println(len);
//        // 将字节数组转换为字符串
////        System.out.println(new String(by));//返回ldwor,原因是之前by已经是\r\nwor，后面读取的两个会赋值给前面两个位置
//        System.out.println(new String(by,0,len));
//    byte[] bys = new byte[1024];
//    FileInputStream fis = new FileInputStream("a.txt");
//    int len;
//    while((len=fis.read(bys))!=-1){
//        System.out.println(new String(bys,0,len));
//    }
//    fis.close();
//        FileInputStream fis = new FileInputStream("1.jpg");
//        FileOutputStream fos = new FileOutputStream("2.jpg");
//        byte[]bys = new byte[1024];
//        int len;
//        while((len=fis.read(bys))!=-1){
//            fos.write(bys,0,len);
//        }
//
//        fos.close();
//        fis.close();


        /**
         * 字节缓冲流提高读写数据速度
         */
//        FileOutputStream fos = new FileOutputStream("a.txt");
//        BufferedOutputStream bos = new BufferedOutputStream(fos);
//        // 等价于
////      BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("a.txt"));
//        bos.write("hello world\r\n".getBytes());
//        bos.close();
//        fos.close();
//        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("b.txt"));
//         读取一个字节
//        int by;
//        while((by=bis.read())!=-1){
//            System.out.println((char)by);
//        }
//        byte[] bys = new byte[1024];
//        int len;
//        while((len=bis.read(bys))!=-1){
//            System.out.println(new String(bys,0,len));
//        }
//
//        bis.close();
        /**
         * 复制视频
         */
//        long starttime = System.currentTimeMillis();
//        method4();
//        long endtime = System.currentTimeMillis();
//        System.out.println("时间："+(endtime-starttime));
        /**
         * 一个汉字存储：
         * 如果是GBK编码，占用2个字节
         * 如果是UTF-8，占用3个字节
         * 汉字在存储的时候无论是哪种编码存储，第一个字节都是负数
         */
////        String s = "abc";//[97,98,99]
//        String s = "中国";//[-28, -72, -83, -27, -101, -67]
////        byte[]bys =s.getBytes("UTF-8");//默认字符集：[-28, -72, -83, -27, -101, -67]
//        byte[]bys =s.getBytes("GBK");//[-42, -48, -71, -6]
//        // 解码
//        String s2 = new String(bys,"GBK");
//        System.out.println(Arrays.toString(bys));
//        System.out.println(s2);//默认字符集UTF-8进行解码
        /**
         * 字符流中的编码解码问题
         */
        // 使用默认字符编码
//        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("a.txt"),"UTF-8");
        //指定为GBK
//        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("a.txt"),"GBK");
//
//        //指定编码方式
//        InputStreamReader isr = new InputStreamReader(new FileInputStream("b.txt"),"GBK");
        // InputStreamReader 读取字符
//        int ch;
//        while((ch=isr.read())!=-1){
//            osw.write(ch);
//        }
        //读取字符数组
//        char[] chs = new char[1024];
//        int len;
//        while((len=isr.read(chs))!=-1){
//            osw.write(chs,0,len);
//        }
//        osw.write(98);
//        //数据首先到缓冲区，需要flush刷新到指定文件中
////        osw.flush();
//        osw.write("abcde",0,3);
//
////        osw.write("中国");
//        //close:先刷新，再关闭流，故不需要flush
//        osw.close();
//        isr.close();
        /**
         * 复制.java文件
         */
//        InputStreamReader isr = new InputStreamReader(new FileInputStream("a.txt"));
//        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("b.txt"));
//        char[] chs = new char[1024];`
//        int len;
//        while ((len = isr.read(chs)) != -1) {
//            osw.write(chs, 0, len);
//        }
//        osw.close();
//        isr.close();
        /**
         * InputStreamReader的子类FileReader
         * OutputStreamWriter的子类FileWriter
         */
//        FileWriter fw = new FileWriter("b.txt");
//        FileReader fr = new FileReader("a.txt");
//        char[] chs = new char[1024];
//        int len;
//        while((len=fr.read(chs))!=-1){
//            fw.write(chs);
//        }
//        fw.close();
//        fr.close();

        /**
         *字节缓冲流
         */
//        BufferedWriter bw = new BufferedWriter(new FileWriter("b.txt"));
////        bw.write("中国\r\n");
//
//        BufferedReader br = new BufferedReader(new FileReader("a.txt"));
////        char[] chs = new char[1024];
////        int len;
////        while((len=br.read(chs))!=-1){
////            System.out.println(new String(chs));
////        }
////        System.out.println(br.readLine());
////        System.out.println(br.readLine());
////        System.out.println(br.readLine());
////        String line;
////        //readLine:读取内容不包含换行符
////        while((line=br.readLine())!=null){
////            System.out.print(line+"\n");
////        }
//        String line;
//        while((line = br.readLine())!=null){
//            bw.write(line);
//            // 不会读取换行符
//            bw.newLine();
//            bw.flush();
//        }
//
//        bw.close();
//        br.close();
//        collections2();

//        copySimpleFold();
//        copyMutilFold();
//        SystemIn();
//        Properties();
        mystore();
        myload();
    }

    private static void myload() throws IOException {
        Properties prop = new Properties();
        FileReader fr = new FileReader("a.txt");
        //以简单的线性格式从输入字符流读取属性列表（关键字和元素对）。
        prop.load(fr);
        fr.close();
        System.out.println(prop);

    }

    private static void mystore() throws IOException {
        Properties prop = new Properties();
        prop.setProperty("w1","WST1");
        prop.setProperty("w2","WST2");
        prop.setProperty("w3","WST3");
        prop.setProperty("w4","WST4");
        FileWriter fw = new FileWriter("a.txt");
        //将此属性列表（键和元素对）写入此 Properties表中，以适合使用 load(Reader)方法的格式输出到输出字符流。 comment:描述信息
        prop.store(fw,null);
        fw.close();
    }


    public static void F() {
        // 加入异常处理
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("Z:\\b.txt");
            fos.write("wst".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void method1() throws IOException {
        //时间：92744
        FileInputStream fis = new FileInputStream("C:\\Users\\17822\\Desktop\\1.mp4");
        FileOutputStream fos = new FileOutputStream("1.mp4");
        int by;
        while ((by = fis.read()) != -1) {
            fos.write(by);
        }
        fos.close();
        fis.close();

    }

    public static void method2() throws IOException {
//        时间：127
        FileInputStream fis = new FileInputStream("C:\\Users\\17822\\Desktop\\1.mp4");
        FileOutputStream fos = new FileOutputStream("1.mp4");
        byte[] bys = new byte[1024];
        int len;
        while ((len = fis.read(bys)) != -1) {
            fos.write(bys);
        }
        fos.close();
        fis.close();

    }

    public static void method3() throws IOException {
//        时间：381
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("C:\\Users\\17822\\Desktop\\1.mp4"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("1.mp4"));
        int by;
        while ((by = bis.read()) != -1) {
            bos.write(by);
        }
        bos.close();
        bis.close();

    }

    public static void method4() throws IOException {
//        时间：22
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("C:\\Users\\17822\\Desktop\\1.mp4"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("1.mp4"));
        byte[] bys = new byte[1024];
        int len;
        while ((len = bis.read(bys)) != -1) {
            bos.write(len);
        }
        bos.close();
        bis.close();

    }

    public static void collections() throws IOException {
        ArrayList<String> array = new ArrayList<>();
        array.add("hello");
        array.add("world");
        array.add("中国");
        BufferedWriter bw = new BufferedWriter(new FileWriter("c.txt"));
        for (String s : array) {
            bw.write(s);
            bw.newLine();
            bw.flush();
        }
        bw.close();
    }

    public static void collections2() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("c.txt"));
        ArrayList<String> array = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) {
            array.add(line);
        }
        System.out.println(array);
        br.close();


    }

    public static void copySimpleFold() throws IOException {
        File srcFolder = new File("D:\\test\\hello");
        String srcFolderName = srcFolder.getName();
        File destFolder = new File("myCharStream", srcFolderName);
        if (!destFolder.exists()) {
            // 创建多级目录
            destFolder.mkdirs();
        }
        File[] listFiles = srcFolder.listFiles();
        for (File srcFile : listFiles) {
            String srcFileName = srcFile.getName();
            File destFile = new File(destFolder, srcFileName);
            copyFile(srcFile, destFile);

        }
    }

    public static void copyMutilFold() throws IOException {
        File srcFile = new File("D:\\test");
        File destFile = new File("D:\\est");
        copyFold(srcFile, destFile);

    }

    private static void copyFold(File srcFile, File destFile) throws IOException {
        if (srcFile.isDirectory()) {
            String srcFileName = srcFile.getName();
            File newFold = new File(destFile, srcFileName);
            if (!newFold.exists()) {
                newFold.mkdirs();
            }
            File[] listFiles = srcFile.listFiles();
            for (File file : listFiles) {
                copyFold(file, newFold);
            }
        } else {
            File newfile = new File(destFile, srcFile.getName());
            copyFile(srcFile, newfile);
        }
    }

    public static void copyFile(File srcFile, File destFile) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFile));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFile));
        byte[] bys = new byte[1024];
        int len;
        while ((len = bis.read(bys)) != -1) {
            bos.write(bys, 0, len);
        }
        bos.close();
        bis.close();

    }

    public static void exceptionDeal() {
        /**
         * JDK7之后，该格式会自动释放数据流，故不需要close
         */
        try (FileReader fr = new FileReader("a.txt"); FileWriter fw = new FileWriter("a.txt");) {
            char[] chs = new char[1024];
            int len;
            while ((len = fr.read(chs)) != -1) {
                fw.write(chs, 0, len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void SystemIn() throws IOException {
//        InputStream in = System.in;
//        int by;
//        while((by=in.read())!=-1){
//            System.out.println((char)by);
//        }
//        //用转换流将字节流-》字符流
//        InputStreamReader isr = new InputStreamReader(in);
//        //字符缓冲流特有方法：readLine():一次读取一行
//        BufferedReader br = new BufferedReader(isr);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        while (!s.equals("111")) {
            System.out.println(s);
            s = br.readLine();
        }
        //键盘录入
//        Scanner in = new Scanner(System.in);
    }

    public static void PrintStream() throws IOException {
        PrintStream ps = new PrintStream("b.txt");
        ps.write(97);//a
        //字符流需要刷新到内存中
        ps.print(97);//97
        ps.println("中国");

        //true表示自动刷新
        PrintWriter pw = new PrintWriter(new FileWriter("b.txt"), true);
        pw.println("hello");
        pw.println(97);
        pw.close();
    }

    //序列化
    public static void ObjectOutputStream() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("b.txt"));
        // HashMap实现了Serializable接口，实现该接口的类都可以序列化和反序列化
//        HashMap<Integer, String> ish = new HashMap<>();
        Student stu = new Student("JYQ", 1);

        //将对象写入ObjectOutputStream类
        oos.writeObject(stu);
        System.out.println(stu);
        oos.close();


    }

    //反序列化
    public static void ObjectInputStream() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("b.txt"));
        Object obj = ois.readObject();
        System.out.println(obj);
        Student s = (Student) obj;
        System.out.println(s.getName() + "," + s.getAge());
        ois.close();
    }
    public static void Properties(){
        //Properties作为Map集合使用
        Properties prop = new Properties();

        prop.put("JYQ",23);
        prop.put("JYQ2",24);
        prop.put("JYQ3",25);
        prop.put("JYQ4",26);
        /**
         *     public synchronized Object setProperty(String key, String value) {
         *         return put(key, value);
         *     }
         */
        prop.setProperty("WST","JYQ");
        Set<Object> keyset = prop.keySet();
        for (Object key : keyset) {
            Object value = prop.get(key);
            System.out.println(key+","+value);

        }
        //getProperty根据键得到值
        System.out.println(prop.getProperty("WST"));
        //stringPropertyNames：得到键的集合
        Set<String> keyset2 = prop.stringPropertyNames();
        for (String key : keyset2) {
            System.out.println(key+","+prop.getProperty(key));
        }


    }
}
