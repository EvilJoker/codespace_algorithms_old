import java.util.List;

/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第 N 个结点
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 快慢指针
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode first = head;
        ListNode second = dummy;

        // p2 先走 k步
        for(int i=0;i<n;i++){
            first = first.next;
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }
        // 删除
        second.next= second.next.next;
        return dummy.next;
    }
}
// @lc code=end
