/*
 * @lc app=leetcode.cn id=141 lang=java
 *
 * [141] 环形链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        // 如果有环，两个节点会相遇 
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast!=null && fast.next !=null){
            fast= fast.next.next;
            slow = slow.next;
            if (fast.val == slow.val){
                return true;
            }
        }
        return false;
    }
}
// @lc code=end

