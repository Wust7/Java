package 接口.引用类;

import java.util.Locale;

public class Demo {
    public static void main(String[] args) {
//        useConverter((String s)->{
//            return Integer.parseInt(s);
//        });
//        useConverter(s->Integer.parseInt(s));
//
//        //引用类  Lambda表达式被类方法替代的时候，它的形式参数全部传递给静态方法作为参数
//        useConverter(Integer::parseInt);

        //实例方法
//        usePrinter(s -> {
////            String result=s.toUpperCase();
////            System.out.println(result);
//            System.out.println(s.toUpperCase());
//        });
//        usePrinter(s-> System.out.println(s.toUpperCase()));
//
//        //引用对象的实例方法
//        //Lambda表达式被对象的实例方法替代的时候，他的形式参数全部传递给该方法作为参数
//        PrintString ps= new PrintString();
//        usePrinter(ps::printUpper);
//        useMysString((String s,int x,int y)->{
//            return s.substring(x,y);
//        });
//
//        useMysString((s,x,y)->s.substring(x,y));
//
//        //引用类中的实例方法
//        useMysString(String::substring);
        useStudentBuilder((String name,int age)->{
            return new Student(name,age);
        });

        useStudentBuilder((name,age)->new Student(name,age));

        //引用构造器   Lambda表达式被构造器替代的时候，它的形式参数全部传递给构造器作为参数
        useStudentBuilder(Student::new);
    }

    private static void useStudentBuilder(StudentBuilder sb) {
        Student jyq = sb.build("JYQ", 30);
        System.out.println(jyq.getName()+","+jyq.getAge());

    }

    private static void useMysString(MyString my) {
        String s = my.mySubString("hello world",1,2);
        System.out.println(s);
    }

    private static void usePrinter(Printer p) {
        p.printUpper("中国我爱你");

    }

    private static void useConverter(Converter c){
        int number=c.convert("666");
        System.out.println(number);
    }


}
