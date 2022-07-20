package 类;

public class StudentDO {
    private String name;
    int age;
    public String address;

    public StudentDO() {
    }

    public StudentDO(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    private StudentDO(int age) {
        this.age = age;
    }

    public StudentDO(String address) {
        this.address = address;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public void method1(){
        System.out.println("method1");
    }
    public void method2(String name){
        System.out.println("method2:"+name);
    }
    public String method3(String name,int age){
        return name+","+age;
    }
    private void func(){
        System.out.println("func");
    }
    @Override
    public String toString() {
        return "StudentDO{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
