package Collection.ComparatorDemo;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class ComparatorDemo {
    public static void main(String[] args) {
        TreeSet<Stu> ts = new TreeSet<Stu>(new Comparator<Stu>() {
            @Override
            public int compare(Stu o1, Stu o2) {
                int temp = o1.getAge() - o2.getAge();
                int num = temp == 0 ? o1.getName().compareTo(o2.getName()):temp;
                return num;
            }
        });
        Stu s1 = new Stu("JYQ",23);
        Stu s2 = new Stu("WLK",24);
        Stu s3 = new Stu("WST",25);
        Stu s4 = new Stu("WST",25);

        ts.add(s1);
        ts.add(s2);
        ts.add(s3);
        ts.add(s4);
        for(Stu s : ts){
            System.out.println(s.getName()+" "+s.getAge());
        }
    }
}
