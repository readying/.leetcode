/*
 * @lc app=leetcode.cn id=4 lang=java
 *
 * [4] 寻找两个正序数组的中位数
 */

// @lc code=start
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int l1 = nums1.length;
        int l2 = nums2.length;
        int[] res = new int[l1 + l2];
        int i = 0, j = 0, k = 0;
        while(i < l1 && j < l2){
            if(nums1[i] < nums2[j]){
                res[k++] = nums1[i];
                i++;
            }else{
                res[k++] = nums2[j];
                j++;
            }
        }

        while(i < l1){
            res[k++]  = nums1[i++];
        }

        while(j < l2){
            res[k++]  = nums2[j++];
        }

        if((l1 + l2) % 2 == 0){
            int t1 = res[(l1+l2)/2 -1];
            int t2 = res[(l1+l2)/2];
            return (t1 + t2)/2.0;
        }else{
            int t2 = res[(l1+l2)/2];
            return t2;
        }
    }
}
// @lc code=end

