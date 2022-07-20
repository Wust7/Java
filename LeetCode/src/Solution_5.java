public class Solution_5 {
    public static String longestPalindrome(String s) {
        int first =0,end = 0;
        for (int i = 0; i < s.length()-1; i++) {
            int a = 0,b = -1;
            if((i+2)<s.length() && s.charAt(i)==s.charAt(i+2)){
                a = i;
                b = i+2;
                for (;b>-1 && b < s.length()&&a>=0&&s.charAt(a)==s.charAt(b); b++,a--);
                a++;
                b--;
                if(b-a>end-first){
                    first = a;
                    end = b;
                }
            }
            if(s.charAt(i) == s.charAt(i+1)){
                a =i;
                b = i+1;
                for (;b>-1 && b < s.length()&&a>=0&&s.charAt(a)==s.charAt(b); b++,a--);
                a++;
                b--;
                if(b-a>end-first){
                    first = a;
                    end = b;
                }
            }

        }
        String res = "";
        for (int i = first; i <= end; i++) {
            res+=String.valueOf(s.charAt(i));
        }
        return res;
    }

    public static void main(String[] args) {
        //
        System.out.println(longestPalindrome("aaaa"));
    }
}
