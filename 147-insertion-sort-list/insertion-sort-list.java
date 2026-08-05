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
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy= new ListNode(0);
        dummy.next=null;
        ListNode curr=head;
        ListNode prev=dummy;
        while(curr!=null){
            prev=dummy;
            while(prev.next!=null && prev.next.val<curr.val){
                prev=prev.next;    
            }
            ListNode temp=curr.next;
            curr.next=prev.next;
            prev.next=curr;
            curr=temp; 
        }
        return dummy.next;
        
    }
}