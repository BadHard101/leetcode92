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
class MySol {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode fakeHead = new ListNode(0, head);

        Stack<ListNode> reverse = new Stack<>();

        ListNode fromNode, toNode, cur = fakeHead;
        for (int i = 0; i < left - 1; i++) {
            cur = cur.next;
        }
        fromNode = cur;

        cur = cur.next;
        for (int i = left - 1; i < right; i++) {
            reverse.push(cur);
            cur = cur.next;
        }
        boolean isLast = false;
        if (cur == null) {
            isLast = true;
        }
        toNode = cur;

        cur = fromNode;
        while (!reverse.isEmpty()) {
            cur.next = reverse.pop();
            cur = cur.next;
        }
        if (isLast) cur.next = null;
        else cur.next = toNode;

        return fakeHead.next;
    }
}