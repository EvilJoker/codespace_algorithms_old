/*
 * @lc app=leetcode.cn id=234 lang=java
 *
 * [234] 回文链表
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
    public boolean isPalindrome(ListNode head) {
        // 快慢指针
        
        ListNode left = head;
        ListNode right = head;
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        // 奇数
        if (fast != null){
            slow = slow.next;
        }
        right = reverse(slow);
        
        while(right !=null){
            // 比值
            if (left.val != right.val){
                return false;
            }
            left =left.next;
            right =right.next;
        }
        return true;


    }

    public ListNode reverse(ListNode head){
        ListNode pre, cur, nxt;
        pre = null;
        cur = head;
        nxt = head;
        while (cur !=null){
            nxt = cur.next;
            cur.next = pre;

            pre = cur;
            cur = nxt;

        }
        return pre;
    }
}
// @lc code=end

