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

        int l = 0, r = 1;
        int resultNum = 0;

        // HashMap<Character, Integer> hashMap = new HashMap<>();
        // HashSet<Character> sets = new HashSet<>();
        // hashMap.put(s.charAt(l), 0);
        // sets.add(s.charAt(l));

        StringBuffer sb = new StringBuffer();
        sb.append(s.charAt(l));
        
        for(l = 0, r = 1; r < length ; r++){
            // if(r >= length) {
            //     break;
            // }
           Character ch = s.charAt(r);
           int temp;
           if (s.substring(l, r).contains(ch)) {
            //    temp = r - l ;
               int k = s.indexOf(ch);
               temp = s.length();
               s = s.substring(k, temp -1);
               s.append(ch);
               l = indexOf
            //    l = hashMap.get(ch) + 1 ;
            //    sets.remove(ch);
           }else {
               sets.add(ch);
               temp = r - l + 1;
           }
            resultNum = Math.max(temp, resultNum);
            hashMap.put(ch, r);
        }
        // if(resultNum == 0){
        //     return sets.size();
        // }

        return resultNum; 

    }
}
// @lc code=end

