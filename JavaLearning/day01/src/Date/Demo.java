package Date;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Demo {
    @Test
    public  void test1() throws ParseException {
        Date date = new Date();
        System.out.println(date);
        System.out.println(date.getTime()*1.0/1000/60/60/24/365);

        //Date ---> String
//        SimpleDateFormat sdf = new SimpleDateFormat();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
        String s = sdf.format(date);
        System.out.println(s);

        //String ---> Date
        String sd = "2022年02月26日15时14分09秒";
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
        Date dd = sdf2.parse(sd);
        System.out.println(dd);
    }

    @Test
    public void test2(){
        Calendar cdate = Calendar.getInstance();
        System.out.println(cdate);
        System.out.println(cdate.get(Calendar.YEAR));
        System.out.println(cdate.get(Calendar.MONTH)+1);
        System.out.println(cdate.get(Calendar.DATE));

        cdate.add(Calendar.MONTH,-2);//往前推两个月
        cdate.add(Calendar.DATE,-10);
        System.out.println(cdate.get(Calendar.MONTH));
        System.out.println(cdate.get(Calendar.DATE));

        cdate.set(2311,1,23);
        System.out.println(cdate.get(Calendar.YEAR));
        System.out.println(cdate.get(Calendar.MONTH)+1);
        System.out.println(cdate.get(Calendar.DATE));
    }
    @Test
    public void test3(){
        Calendar c = Calendar.getInstance();
        c.set(2022,2,1);
        c.add(Calendar.DATE,-1);
        System.out.println(c.get(Calendar.DATE));
    }
}
