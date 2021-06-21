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

        HashMap<Character, Integer> hashMap = new HashMap<>();
        HashSet<Character> sets = new HashSet<>();
        hashMap.put(s.charAt(l), 0);
        sets.add(s.charAt(l));
        
        for(l = 0, r = 1; l < length - 1; r++){
            if(r >= length) {
                break;
            }
           Character ch = s.charAt(r);
           if (sets.contains(ch)) {
               int temp = r - l ;
               resultNum = Math.max(temp, resultNum);
               l = hashMap.get(ch) + 1 ;
               hashMap.put(ch, r);
            //    sets.remove(ch);
           }else {
               hashMap.put(ch, r);
               sets.add(ch);
           }
        }

        return resultNum; 

    }
}
// @lc code=end

