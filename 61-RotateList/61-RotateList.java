// Last updated: 7/7/2026, 11:01:32 PM
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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        // Step 1: Find length and tail
        ListNode curr = head;
        int n = 1;

        while (curr.next != null) {
            curr = curr.next;
            n++;
        }

        // Step 2: Make circular
        curr.next = head;

        // Step 3: Reduce k
        k = k % n;
        int stepsToNewHead = n - k;

        // Step 4: Find new tail
        ListNode newTail = curr;
        while (stepsToNewHead-- > 0) {
            newTail = newTail.next;
        }

        // Step 5: Break cycle
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}