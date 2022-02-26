package wust;

public class Solution_26 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,3,3,4};
        if(nums.length == 0)
            System.out.println(0);
        if(nums.length == 1)
            System.out.println(1);
        int i = 1;
        int k = 1;
        while(i<nums.length-1){
            if(nums[i-1] != nums[i]){
                System.out.println(nums[k]);
                nums[k] = nums[i];
                k++;

            }
            i++;
        }
        System.out.println(k);
    }
}
