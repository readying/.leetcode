/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    /**
     * 写法二
     * 
     * @description 此方法有效的避免了各种情况的考虑，比起
     * 合并两个有序数组，因为还需要用数据，所以可以一直遍历，
     * 合并两个有序数组也可以写成类似的。
     * 
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode result = new ListNode();
        ListNode rHead = result;
        int acc = 0;
        // 这种写法尤为关键
        while(l1 != null || l2 != null || acc != 0){
           
            int add = 0;
            int t1 = l1 == null ? 0 : l1.val;
            int t2 = l2 == null ? 0 : l2.val;

            add = t1 + t2 + acc;

            ListNode newNode = new ListNode(add % 10, null);
            result.next = newNode;
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
            result = result.next;

            acc = add / 10;
        }

        return rHead.next;
    }


    /**
     *  第一种写法，最普通的思想，跟合并两个数组的写法类似，但是用在这个题会有一定的问题
     * 
     *  这种写法的劣势很明显，很难一次想的很完善，所以这种写法不太适合此类问题的。
     * @param l1
     * @param l2
     * @return
     */
    // public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

    //     ListNode result = new ListNode();
    //     ListNode rHead = result;
    //     int acc = 0;
    //     while(l1 != null && l2 != null){
    //         int temp = l1.val + l2.val + acc;
    //         if(temp < 10){
    //             acc = 0;
    //         }else{
    //             temp = temp - 10;
    //             acc = 1;
    //         };
    //         ListNode node1 = new ListNode(temp, null);
    //         result.next = node1;
    //         l1 = l1.next;
    //         l2 = l2.next;
    //         result = result.next;
    //     }

    //     if(l1 != null){
    //         // 有可能上次累加的遗留在这,可以再次累计
    //         while(l1 != null ){
    //             if(acc < 1){
    //                 result.next = l1;
    //                 break;
    //             }

    //             int temp = acc + l1.val;
    //             if(temp < 10){
    //                 acc = 0;
    //             }else{
    //                 temp = temp - 10;
    //                 acc = 1;
    //             }
    //             ListNode node1 = new ListNode(temp, null);
    //             result.next = node1;
    //             l1 = l1.next;
    //             result = result.next;
    //         }
          

    //     }else if(l2 != null){
    //         while(l2 != null ){
    //             if(acc < 1){
    //                 result.next = l2;
    //                 break;
    //             }
    //             int temp = acc + l2.val;
    //             if(temp < 10){
    //                 acc = 0;
    //             }else{
    //                 temp = temp - 10;
    //                 acc = 1;
    //             }
    //             ListNode node1 = new ListNode(temp, null);
    //             result.next = node1;
    //             l2 = l2.next;
    //             result = result.next;
    //         }
    //     }

    //     if(acc == 1){
    //         ListNode node2 = new ListNode(1, null);
    //         result.next = node2;
    //     }

    //     return rHead.next;
    // }
}
// @lc code=end