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
 * 
 * [1,2,3,4,5], left = 1, right = 2
 * [2,1,3,4,5]
 */
class Solution2 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head.next == null || left == right) return head;

        Stack<ListNode> listToReverse = new Stack<>();

        ListNode temp = head;
        ListNode fromNode, toNode;
        boolean isLast = false;
        if (left == 1) {
            listToReverse.push(head);
            for (int i = 1; i < right; i++) {
                temp = temp.next;
                listToReverse.push(temp);
            }
            fromNode = temp;
            temp = temp.next;
        } else {
            for (int i = 1; i < left-1; i++) {
                temp = temp.next;
            }
            fromNode = temp;
            temp = temp.next;

            for (int i = left; i <= right; i++) {
                listToReverse.push(temp);
                temp = temp.next;
            }
        }
        toNode = temp;

        temp = fromNode;
        while(!listToReverse.isEmpty()) {
            temp.next = listToReverse.pop();
            temp = temp.next;
        }
        if (isLast) {
            temp.next = null;
        } else {
            temp.next = toNode;
        }
        
        return head;
    }
}