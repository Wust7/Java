package 基本算法;

public class digui {
    /**
     * 递归占用空间大，每一次递归都会把其存在栈中，直到最后一次递归运行完才释放
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[20];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i-1]+arr[i-2];
        }
        System.out.println(arr[19]);
        System.out.println(F(19));
        System.out.println(jiechen(5));
    }
    public static int F(int n){
        if(n==0||n==1)
            return 1;
        return F(n-1)+F(n-2);
    }

    public static int jiechen(int n){
        if(n==1)
            return 1;
        return n*jiechen(n-1);

    }
}
