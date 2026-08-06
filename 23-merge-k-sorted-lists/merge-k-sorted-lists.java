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
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> q =
            new PriorityQueue<>((a, b) -> a.val - b.val);

        for (int i = 0; i < lists.length; i++) {
            ListNode curr = lists[i];
            while (curr != null) {
                q.offer(curr);
                curr = curr.next;
            }
        }

        if (q.isEmpty()) {
            return null;
        }

        ListNode n = q.poll();
        ListNode dummy = n;

        while (!q.isEmpty()) {
            dummy.next = q.poll();
            dummy = dummy.next;
        }

        dummy.next = null;

        return n;
    }
}