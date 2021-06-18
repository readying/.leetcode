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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode result = new ListNode();
        ListNode rHead = result;
        int acc = 0;
        while(l1 != null && l2 != null){
            int temp = l1.val + l2.val + acc;
            if(temp < 10){
                acc = 0;
            }else{
                temp = temp - 10;
                acc = 1;
            };
            ListNode node1 = new ListNode(temp, null);
            result.next = node1;
            l1 = l1.next;
            l2 = l2.next;
            result = result.next;
        }

        if(l1 != null){
            // 有可能上次累加的遗留在这,可以再次累计
            while(l1 != null ){
                if(acc < 1){
                    result.next = l1;
                    break;
                }

                int temp = acc + l1.val;
                if(temp < 10){
                    acc = 0;
                }else{
                    temp = temp - 10;
                    acc = 1;
                }
                ListNode node1 = new ListNode(temp, null);
                result.next = node1;
                l1 = l1.next;
                result = result.next;
            }
          

        }else if(l2 != null){
            while(l2 != null ){
                if(acc < 1){
                    result.next = l2;
                    break;
                }
                int temp = acc + l2.val;
                if(temp < 10){
                    acc = 0;
                }else{
                    temp = temp - 10;
                    acc = 1;
                }
                ListNode node1 = new ListNode(temp, null);
                result.next = node1;
                l2 = l2.next;
                result = result.next;
            }
        }

        if(acc == 1){
            ListNode node2 = new ListNode(1, null);
            result.next = node2;
        }

        return rHead.next;
    }
}
// @lc code=end