package wust.jianzhi;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution_6 {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        ListNode head = new ListNode(2);
        ListNode next1 = new ListNode(3);
        head.next = next1;
        ListNode next2 = new ListNode(1);
        head.next.next = next2;
        ListNode p = head;
        for(int i = 0;p!=null;i++){
            nums.add(p.val);
            p = p.next;
        }
        int[] endNums=new int[nums.size()];
        for(int j = 0;j <nums.size();j++){
            endNums[j] = nums.get(nums.size()-j-1);
        }
        System.out.println(endNums[0]+""+endNums[1]+endNums[2]);
    }

}
