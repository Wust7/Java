package 文件流操作;

import java.io.Serializable;

public class Student implements Serializable {
    /**
     * 强烈建议需要序列化或反序列化的类，申明自己的序列化ID，以免后续出现问题
     * InvalidClassException: FILE.Student; local class incompatible:
     * stream classdesc serialVersionUID = 42,
     * local class serialVersionUID = -8893593479819521234
     */
    private static final long serialVersionUID=42L;
    private String name;
//    private int age;
    //被transient修饰的变量不参与序列化过程
    private transient int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "FILE.Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student() {
    }
}
