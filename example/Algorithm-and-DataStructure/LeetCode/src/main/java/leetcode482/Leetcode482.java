package leetcode482;

import java.io.StringBufferInputStream;

public class Leetcode482 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(new String("asdad-asdasda").toUpperCase());
//        System.out.println(solution.licenseKeyFormatting("aaa",1));
    }

}

class Solution {
    public String licenseKeyFormatting(String s, int k) {
        char[] temp=new char[4];
        char[] chars=s.toUpperCase().toCharArray();
        for(int i=0;i<s.length();i++){
            if(chars[i]=='-'){
                
            }
        }
        return s;
    }
}
