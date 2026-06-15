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
    public ListNode deleteMiddle(ListNode head) {
        if(head==null || head.next==null){
            return head.next;
        }
        ListNode s=head;
        ListNode f=head;
        ListNode prev=head;
        while(f!=null){
            prev=s;
            s=s.next;
            f=f.next.next;
            if(f==null){
                break;
            }
            else if(f.next==null){
                break;
            }
        }
        prev.next=s.next;
        return head;
        
    }
}