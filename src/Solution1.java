import java.util.Stack;

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
class Solution1 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head.next == null) return head;

        Stack<ListNode> listToReverse = new Stack<>();

        ListNode temp = head;
        for (int i = 1; i < left-1; i++) {
            temp = temp.next;
        }
        ListNode fromNode = temp;
        temp = temp.next;

        for (int i = left; i <= right; i++) {
            listToReverse.push(temp);
            temp = temp.next;
        }
        ListNode toNode = temp;

        temp = fromNode;
        for (int i = 0; i < listToReverse.size(); i++) {
            temp.next = listToReverse.pop();
            temp = temp.next;
        }
        temp.next = toNode;
        return head;
    }
}