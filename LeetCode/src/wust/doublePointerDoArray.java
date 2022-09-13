package wust;

public class doublePointerDoArray {
    //快慢指针数组应用
    int removeDuplicates(int[] nums){
        if(nums.length==0){
            return 0;
        }
        int fast=0,slow=0;
        while(fast<nums.length){
            if (nums[fast]!=nums[slow]){
                slow++;
                nums[slow]=nums[fast];
            }
            fast++;
        }
        return slow+1;
    }

    //快慢指针：给你输入一个数组 nums，请你原地修改，将数组中的所有值为 0 的元素移到数组末尾
    void moveZeroes(int[] nums){
        int slow=0,fast=0;
        while(fast<nums.length){
            if(nums[fast]!=0){
                nums[slow]=nums[fast];
                slow++;
            }
            fast++;
        }
        while(slow<nums.length){
            nums[slow]=0;
            slow++;
        }

    }

    //左右指针：请你从数组中找出满足相加之和等于目标数 target 的两个数
    public int[] twoSum(int[] numbers, int target) {
        int left=0,right=numbers.length-1;
        while(left<right){
            int sum=numbers[left]+numbers[right];
            if(sum==target){
                return new int[]{left+1,right+1};
            }else if(sum<target){
                left++;
            }else if(sum>target){
                right--;
            }
        }
        return new int[]{-1,-1};
    }

    //编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
    void reverseString(char[] s) {
        int left=0,right=s.length-1;
        while(left<right){
            char temp=s[left];
            s[left]=s[right];
            s[right]=temp;
            left++;
            right--;
        }
    }

    //给你一个字符串 s，找到 s 中最长的回文子串。
    public String longestPalindrome(String s) {
        String res="";
        for(int i=0;i<s.length();i++){
            String s1=palindrome(s,i,i);
            String s2=palindrome(s,i,i+1);
            res = res.length()>s1.length()?res:s1;
            res = res.length()>s2.length()?res:s2;
        }
        return  res;
    }

    public String palindrome(String s,int left,int right){
        while(left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        //返回字符串s中索引为left+1~right-1的字符串
        return s.substring(left+1,right);
    }
}
