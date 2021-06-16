import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {

        // 用 hashmap既可以利用keySet的集合属性，有可以保存下标索引
        HashMap<Integer, Integer> hash = new HashMap<>();

        int[] result = new int[2];

        for(int i = 0; i < nums.length; i++){

            if(hash.containsKey(nums[i])){
                result[0] = hash.get(nums[i]);
                result[1] = i;
                return result;
            }
            // 将遍历过的每一个元素所需要的下标都存放在hashMap里
            hash.put(target - nums[i], i);   
        }





        // 暴力破解法, 复杂度是o(n^2)
        // int length = nums.length;
        // for(int i = 0; i < length-1; i++){
        //     int s1 = nums[i];
        //     for(int j = i+1; j < length; j++){
        //         if(nums[j] == target - s1){
        //             return new int[]{i, j};
        //         }
        //     }
        // }
    }
}
// @lc code=end

