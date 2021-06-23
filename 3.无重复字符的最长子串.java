import java.util.HashMap;
import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution {

    public int lengthOfLongestSubstring(String s) {

        if(s == null || s.length() == 0){
            return 0;
        }
        int length = s.length();
        if(length == 1){
            return 1;
        }

        int l = 0, res = 0;

        HashMap<Character, Integer> hashMap = new HashMap<>();
        hashMap.put(s.charAt(l), 0);

        for(int r = 1; r < length; r++){
            char ch = s.charAt(r);
            if(hashMap.containsKey(ch)){
                // 这个是核心, 我们不去删除left元素之前的元素，但是如果再次找到的元素是在他的左边，我们就忽略即可。
                l = Math.max(l, hashMap.get(ch)+1);
            }
            hashMap.put(ch, r);
            res = Math.max(res, r-l+1);
        }

        return res;
    }


    /**
     * 第一种
     *  主要是利用了滑动窗口指针 左指针的移动
     * @param s
     * @return
     */
    // public int lengthOfLongestSubstring(String s) {

    //     if(s == null || s.length() == 0){
    //         return 0;
    //     }
    //     int length = s.length();
    //     if(length == 1){
    //         return 1;
    //     }

    //     int l = 0, r = 1;
    //     int resultNum = 0;

    //     // HashMap<Character, Integer> hashMap = new HashMap<>();
    //     // HashSet<Character> sets = new HashSet<>();
    //     // hashMap.put(s.charAt(l), 0);
    //     // sets.add(s.charAt(l));

    //     for(l = 0, r = 1; r < length ; r++){
    //        Character ch = s.charAt(r);
    //        int temp;
    //        int pos;
    //        if ((pos = s.substring(l, r).indexOf(ch)) > -1) {
    //            temp = r - l ;
    //            l = pos + l + 1;
    //         //    l = hashMap.get(ch) + 1 ;
    //         //    sets.remove(ch);
    //        }else {
    //            temp = r - l + 1;
    //        }
    //         resultNum = Math.max(temp, resultNum);
    //     }
    //     return resultNum; 
    // }
}
// @lc code=end

