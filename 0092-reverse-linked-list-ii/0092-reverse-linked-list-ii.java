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
    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode temp = head;
        ListNode temp1 = null;
        ListNode temp2 = null;

        int pos = 1;

        while (temp != null) {

            if (pos == left) {
                temp1 = temp;
            }

            if (pos == right) {
                temp2 = temp;
                break;
            }

            temp = temp.next;
            pos++;
        }

        while (left < right) {

            int value = temp1.val;
            temp1.val = temp2.val;
            temp2.val = value;

            // Move temp1 forward
            temp1 = temp1.next;

            // Find the node just before temp2
            ListNode t = head;
            for (int i = 1; i < right - 1; i++) {
                t = t.next;
            }

            temp2 = t;

            left++;
            right--;
        }

        return head;
    }
}