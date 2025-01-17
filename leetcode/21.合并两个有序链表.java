/*
 * @lc app=leetcode.cn id=21 lang=java
 *
 * [21] 合并两个有序链表
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode p = head;
        ListNode p1 = list1,  p2 = list2
        // 边界： p1,p2 不等 null
        while(p1!=null && p2!=null){

            if (p1.val > p2.val){
                p.next = p2;
                p2 = p2.next;
            }else{
                p.next = p1;
                p1 = p1.next;
            }
            p = p.next;
        }
        // 有一个结束了，可以直接加未完的
        if (p1 != null){
            p.next = p1;
        }
        if (p2 !=null){
            p.next = p2;
        }

        return head.next;
    }
}
// @lc code=end

