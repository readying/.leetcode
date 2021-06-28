/*
 * @lc app=leetcode.cn id=4 lang=java
 *
 * [4] 寻找两个正序数组的中位数
 */

// @lc code=start
class Solution {

    /**
     * 第四种 最优先记住的一种方法
     * 是第三种的升级版， 用二分来移除没用的数据，
     *  而且找第k大的数都可以用此方法
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int m = nums1.length;
        int n = nums2.length;

        int mid = (m+n)/2;

        if((m+n)%2 == 0){
            return (compare(nums1, 0, m-1, nums2, 0, n-1, (m+n)/2)  +
                    compare(nums1, 0, m-1, nums2, 0, n-1, (m+n)/2 +1))/2.0;
        }else {
            return compare(nums1, 0, m-1, nums2, 0, n-1, (m+n)/2 +1);
        }
    }

    public int compare(int[] a, int aStart, int aEnd, int[] b, int bStart, int bEnd, int pos){

        int alen = aEnd - aStart + 1;
        int blen = bEnd - bStart + 1;

        // 总是让短的是nums1,这样可以排除当数组1为空的情况
        if(alen > blen){
            return  compare(b, bStart, bEnd, a, aStart, aEnd, pos);
        }
        if(alen == 0){
            return b[bStart + pos -1];
        }

        if(pos == 1) return Math.min(a[aStart], b[bStart]);

        int i = aStart + Math.min(alen, pos/2) -1;
        int j = bStart + Math.min(blen, pos/2) -1;


        if(a[i] > b[j]){
            return compare(a, aStart, aEnd, b, j+1, bEnd, pos- (j-bStart+1));
        }else {
            return  compare(a, i + 1, aEnd, b, bStart, bEnd, pos- (i-aStart+1));
        }
    }

    /**
     * 第三种 (找第(m+n+1)/2个数，或两个数)
     * 此种方法最为简单，记住了
     * 但是此方法的复杂度是O(log(m+n/2)) -> Olog(m+n), 不满足要求
     * 
     * @param nums1
     * @param nums2
     * @return
     */
    // public double findMedianSortedArrays(int[] nums1, int[] nums2) {


    //     int m = nums1.length;
    //     int n = nums2.length;

    //     int mid = (m+n)/2;
    //     int aStart = 0, bStart = 0;

    //     int left = 0, right =0;
    //     for(int i = 0; i <= mid; i++){
    //         left = right;
    //         if(aStart < m && (bStart >= n || nums1[aStart] < nums2[bStart])){
    //             right = nums1[aStart];
    //             aStart++;
    //         }else{
    //             right = nums2[bStart];
    //             bStart++;
    //         }
    //     }
    //     if((m+n)%2 ==0){
    //         return (left+right)/2.0;
    //     }else{
    //         return (double)right;
    //     }


    // }


    /**
     * 第二种 （比较复杂可以尝试背答案。。。）
     *  考虑到是取中位数，而且是O(log(m+n)), 一般都是要二分查找的，而且合并两个有序数组确实有些浪费
     *  用i,j 分别表示两个数组的分界点，满足
     *      1. num1[i-1] <= nums2[j] && nums2[j-1] <= nums1[j]
     *      2. i + j = (m+n+1)/2 
     * 
     * @param nums1
     * @param nums2
     * @return
     */
    // public double findMedianSortedArrays(int[] nums1, int[] nums2) {

    //     int m = nums1.length;
    //     int n = nums2.length;
    //     if(m > n){
    //         return findMedianSortedArrays(nums2, nums1);
    //     }

    //     int left = 0;
    //     int right = m;

    //     int total = (m + n + 1)/2;  // i+j 的总和

    //     while(left < right){
            
    //         int i = left + (right - left +1)/2;  // 这是nums1的中间位置
    //         int j = total - i;
            
    //         if(nums1[i-1] > nums2[j]){
    //             // 说明 i 的位置太靠右了, 下次搜索范围 [left,  i-1]
    //             right = i - 1;
    //         }else{
    //             // 说明 i 的位置太靠左了，得向右移动 [i, right]
    //             left = i ;
    //         }
    //     }
    //     int i = right;
    //     int j = total - i;
    //     int nums1_l1 = i == 0? Integer.MIN_VALUE : nums1[i-1];
    //     int nums1_r1 = i == m? Integer.MAX_VALUE : nums1[i];
    //     int nums2_l1 = j == 0? Integer.MIN_VALUE : nums2[j-1];
    //     int nums2_r1 = j == n? Integer.MAX_VALUE : nums2[j];


    //     if((m+n)%2 == 0){
    //         // 偶数 
    //         int l1 = Math.max(nums1_l1, nums2_l1);
    //         int l2 = Math.min(nums1_r1, nums2_r1);
    //         return (l1 + l2)/2.0;
    //     }else{
    //         int k = Math.max(nums1_l1, nums2_l1);
    //         return (double)k;
    //     }

    // }


    /**
     * 第一种
     *  这种方法的思路很简单，就是两个有序数组进行简单的合并成一个有序数组，然后再取中间的返回即可
     *  
     *  劣势：复杂的O(m+n)
     * @param nums1
     * @param nums2
     * @return
     */
    // public double findMedianSortedArrays(int[] nums1, int[] nums2) {

    //     int l1 = nums1.length;
    //     int l2 = nums2.length;
    //     int[] res = new int[l1 + l2];
    //     int i = 0, j = 0, k = 0;
    //     while(i < l1 && j < l2){
    //         if(nums1[i] < nums2[j]){
    //             res[k++] = nums1[i];
    //             i++;
    //         }else{
    //             res[k++] = nums2[j];
    //             j++;
    //         }
    //     }

    //     while(i < l1){
    //         res[k++]  = nums1[i++];
    //     }

    //     while(j < l2){
    //         res[k++]  = nums2[j++];
    //     }

    //     if((l1 + l2) % 2 == 0){
    //         int t1 = res[(l1+l2)/2 -1];
    //         int t2 = res[(l1+l2)/2];
    //         return (t1 + t2)/2.0;
    //     }else{
    //         int t2 = res[(l1+l2)/2];
    //         return t2;
    //     }
    // }
}
// @lc code=end

