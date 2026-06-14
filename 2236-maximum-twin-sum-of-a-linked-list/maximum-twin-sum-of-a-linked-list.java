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
    static ListNode[] reverseN(ListNode head, int n) {
    ListNode prev = null;
    ListNode curr = head;

    while (curr != null && n > 0) {
        ListNode next = curr.next;

        curr.next = prev;
        prev = curr;
        curr = next;

        n--;
    }
    return new ListNode[]{prev, curr};
}
    public int pairSum(ListNode head) {
        ListNode temp=head;
        int size=0;
        while(temp!=null){
            size=size+1;
            temp=temp.next;
        }
        int h=size/2;
ListNode[] ans = reverseN(head, h);

ListNode reversedHead = ans[0];
ListNode remainingHead = ans[1];
        int max=Integer.MIN_VALUE;
        int sum=0;
        while(remainingHead!=null && reversedHead!=null){
            sum=remainingHead.val+reversedHead.val;
            max=Math.max(max,sum);
            remainingHead=remainingHead.next;
            reversedHead=reversedHead.next;
        } 
        return max;

    }

}