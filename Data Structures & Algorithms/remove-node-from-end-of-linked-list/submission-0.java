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
    int[] c = new int[1];
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null){
            c[0]=1;
            return head;
        }

        ListNode node = removeNthFromEnd(head.next, n);
        if(c[0] == n){
            c[0]++;
            return head.next;
        }

        head.next = node;
        c[0]++;
        return head;
    }
}
