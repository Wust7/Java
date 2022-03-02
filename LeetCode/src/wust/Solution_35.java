package wust;

public class Solution_35 {
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 5;
        int head = 0;
        int rear = nums.length - 1;
        int mid = (head + rear) / 2;
        while(nums[mid] != target && head < rear){
            System.out.println("***"+mid);
            if(target < nums[mid]){
                rear = mid -1;
            } else if(target > nums[mid]){
                head = mid + 1;
            }
            mid = (head + rear)/2;
        }
        if(target == nums[mid]){
            System.out.println("A"+mid);
        }else if(target < nums[head]){
            System.out.println("B"+(head));
        }else{
            System.out.println("C"+(head+1));
        }
    }
}
