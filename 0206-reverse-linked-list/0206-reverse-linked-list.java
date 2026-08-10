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
    public ListNode reverseList(ListNode head) {
        Stack<ListNode> st = new Stack<>();
        if(head == null) {
            return null;
        }
        ListNode node = head;
        while(node != null) {
            st.push(node);
            node = node.next;
        }
        ListNode poped = st.pop();
        ListNode newHead = poped;
        while(!st.isEmpty()) {
        newHead.next = st.pop();
        newHead = newHead.next;
        }
        newHead.next = null;
        return poped;
    }
}