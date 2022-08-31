package 类;


import 接口.引用类.Student;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Properties;

public class Demo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException, IOException {
        Class<?> c = Class.forName("类.StudentDO");
        /**
         * 类加载器
         */
//        //getSystemClassLoader：返回用于委派的系统类加载器
//        ClassLoader c = ClassLoader.getSystemClassLoader();
//        System.out.println(c);//AppClassLoader
//        //getParent:返回父类加载器进行委派
//        ClassLoader c2 = c.getParent();
//        System.out.println(c2);//ExtClassLoader
//        ClassLoader c3 = c2.getParent();
//        System.out.println(c3);
        /**
         *获取Class类的构造对象
         */
//        //使用类的class属性
//        Class<StudentDO> c = StudentDO.class;
//        System.out.println(c);
//        Class<StudentDO> c2 = StudentDO.class;
//        System.out.println(c==c2);
//
//        //使用getClass方法
//        StudentDO s = new StudentDO();
//        Class<? extends StudentDO> c3 = s.getClass();
//        System.out.println(c==c3);
//
//        //使用Class类中的静态方法forName
//        Class<?> c4 = Class.forName("类.StudentDO");
//        System.out.println(c==c4);
        /**
         * 反射获取构造方法
         */
//        Class<?> c = Class.forName("类.StudentDO");
//        //返回一个包含 Constructor对象的数组， Constructor对象反映了由该 Class对象表示的类的所有公共构造函数
////        Constructor<?>[] cons = c.getConstructors();
//        //返回一个 Class对象的数组，反映了所有被声明为由 Class对象表示的类的成员的类和接口
//        Constructor<?>[] cons = c.getDeclaredConstructors();
//        for (Constructor<?> con : cons) {
//            System.out.println(con);
//        }
//        //返回一个 Constructor对象，该对象反映由该 Class对象表示的类的指定公共构造函数
//        Constructor<?> con = c.getConstructor();
//        System.out.println(con);
//        //返回一个 Constructor对象，该对象反映由此 Class对象表示的类或接口的指定构造函数
//        //使用由此 Constructor对象表示的构造函数，使用指定的初始化参数来创建和初始化构造函数的声明类的新实例
//        Object obj = con.newInstance();
//        System.out.println(obj);
        /**
         *访问公共和私有构造方法
         */
//        //基本数据类型也可以通过.class获取
//        Constructor<?> con = c.getConstructor(String.class, int.class);
//        Object obj = con.newInstance("JYQ", 20);
//        System.out.println(obj);
//        //私有构造方法，不能直接访问
//        Constructor<?> con2 = c.getDeclaredConstructor(int.class);
//
//        //暴力反射
//        //将此反射对象的accessible标志设置为指示的布尔值。 值为true表示反射对象应该在使用Java语言访问控制时抑制检查
//        con2.setAccessible(true);
//        Object obj2 = con2.newInstance(20);
//        System.out.println(obj2);
        /**
         * 反射获取变量
         */
//        //返回一个包含 Field对象的数组， Field对象反映由该 Class对象表示的类或接口的所有可访问的公共字段
////        Field[] fields = c.getFields();
//        //返回一个 Field对象的数组，反映了由该 Class对象表示的类或接口声明的所有字段
//        Field[] fields = c.getDeclaredFields();
//        for (Field field : fields) {
//            System.out.println(field);
//        }
//        Field addressField = c.getField("address");
//        Constructor<?> con = c.getConstructor();
//        Object obj = con.newInstance();
//        //提供有关类或接口的单个字段的信息和动态访问
//        //将指定的对象参数中由此 Field对象表示的字段设置为指定的新值
//        addressField.set(obj,"wuhan");//给obj的成员变量addressField赋值
//        //等价于
//        System.out.println(obj);
//        StudentDO s = new StudentDO();
//        s.address="wuhan";
        /**
         * 成员变量赋值
         */
//        Constructor<?> con = c.getConstructor();
//        Object obj = con.newInstance();
//        System.out.println(obj);
//        //getField不能访问私有成员变量
////        Field name = c.getField("name");
//        Field name = c.getDeclaredField("name");
//        //暴力反射，取消访问检查
//        name.setAccessible(true);
//        name.set(obj,"JYQ");
//        System.out.println(obj);
//
//        Field age = c.getDeclaredField("age");
//        name.setAccessible(true);
//        age.set(obj,20);
//
//        Field address = c.getDeclaredField("address");
//        address.setAccessible(true);
//        address.set(obj,"wuhan");
//        System.out.println(obj);
        /**
         *获取成员方法
         */
//        //返回一个包含 方法对象的数组， 方法对象反映由该 Class对象表示的类或接口的所有公共方法，包括由类或接口声明的对象以及从超类和超级接口继承的类
//        Method[] methods = c.getMethods();
        //返回一个包含 方法对象的数组， 方法对象反映由 Class对象表示的类或接口的所有声明方法，包括public，protected，default（package）访问和私有方法，但不包括继承方法
//        Method[] methods = c.getDeclaredMethods();
//        for (Method method : methods) {
//            System.out.println(method);
//        }
//
//        //获取无参构造创建对象
//        Constructor<?> con = c.getConstructor();
//        Object obj = con.newInstance();
//
//        //返回一个 方法对象，该对象反映由该 Class对象表示的类或接口的指定公共成员方法
//        Method m1 = c.getMethod("method1");
//        //在具有指定参数的指定对象上调用此 方法对象表示的基础方法
//        m1.invoke(obj);//相当于调用obj的m方法
//
//        Method m2 = c.getMethod("method2", String.class);
//        m2.invoke(obj,"JYQ");
//
//        Method m3 = c.getMethod("method3", String.class, int.class);
//        Object o = m3.invoke(obj, "JYQ", 20);//有返回值
//        System.out.println(o);
//        //返回一个 方法对象，它反映此表示的类或接口的指定声明的方法 Class对象
////        Method m4 = c.getMethod("func");
//        Method m4 = c.getDeclaredMethod("func");
//        m4.setAccessible(true);
//        m4.invoke(obj);
        /**
         *ArrayList<Integer>中添加String类型数据
         */
//        ArrayList<Integer> arr = new ArrayList<>();
////        arr.add("JYQ");
//        //反射可以越过泛型检查
//        Class<? extends ArrayList> arrClass = arr.getClass();
//        Method m = arrClass.getMethod("add", Object.class);
//        m.invoke(arr,"JYQ");
//        m.invoke(arr,"JYQ1");
//        m.invoke(arr,10);
//        for (Object o : arr) {
//            System.out.println(o);
//        }
        /**
         * 通过配置文件运行类中方法
         */
//        Stu s = new Stu();
//        s.learn();
//        teacher t = new teacher();
//        t.teach();
        //加载数据
        Properties prop = new Properties();
        FileReader fr = new FileReader("JavaBase\\class.txt");
        prop.load(fr);
        fr.close();
        System.out.println(prop);
        String className = prop.getProperty("className");
        String methodName = prop.getProperty("methodName");
        //通过反射使用
        Class<?> ac = Class.forName(className);
        Constructor<?> con = ac.getConstructor();
        Object obj = con.newInstance();

        Method m = ac.getMethod(methodName);
        m.invoke(obj);


    }
}
