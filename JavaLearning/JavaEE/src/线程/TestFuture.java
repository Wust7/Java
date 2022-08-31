package 线程;
import org.junit.Test;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
public class TestFuture {
    @Test
    public void testA(){
//        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> a(1000));
//        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> a(1000));
//        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> a(1000));
//        CompletableFuture<String> future4 = CompletableFuture.supplyAsync(() -> a(1000));
//        CompletableFuture<String> future5 = CompletableFuture.supplyAsync(() -> a(1000));
//        CompletableFuture<String> future6 = CompletableFuture.supplyAsync(() -> a(1000));
//        System.currentTimeMillis();
        try {
            //获取并行执行任务结果
//            System.out.println(future3.get());
//            System.out.println(future1.get());
//            System.out.println(future2.get());
//            System.out.println(future4.get());
//            System.out.println(future5.get());
//            System.out.println(future6.get());

            ArrayList<CompletableFuture<String>> num = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                for (int i1 = 0; i1 < 9; i1++) {
                    num.add(CompletableFuture.supplyAsync(() -> a(1000)));
                }
            }
            for (CompletableFuture<String> stringCompletableFuture : num) {
                stringCompletableFuture.get();
            }
//            num.get(0).get();
//            num.get(1).get();
//            num.get(2).get();
//            num.get(3).get();
//            num.get(4).get();
//            num.get(5).get();
        }catch (Exception e){
        }
    }
    public String a(int aa){
        try {
            Thread.sleep(aa);
        }catch (Exception e){
        }
        return "a";
    }
    private String b(){
        try {
            //模拟业务执行时间
            Thread.sleep(2000);
        }catch (Exception e){
        }
        return "b";
    }
    private String c(){
        try {
            //模拟业务执行时间
            Thread.sleep(5000);
        }catch (Exception e){
        }
        return "c";
    }
}
