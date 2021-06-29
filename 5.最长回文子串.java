/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {

        int len = s.length();
        if(len == 1){
            return  s;
        }
        String restr = "";

        for(int i = 0; i < len - 1; i++){
            for(int j = i ; j < len; j++){
                String str = s.substring(i, j+1);
                int m = 0, n = j-i;
                boolean flag = true;
                while(m < n){
                    if(str.charAt(m++) != str.charAt(n--)){
                        flag = false;
                        break;
                    }                    
                }
                if(flag){
                    if(restr.length() < str.length()){
                        restr = str;
                    }
                }

            }
        }
        return restr;
    }
}
// @lc code=end

