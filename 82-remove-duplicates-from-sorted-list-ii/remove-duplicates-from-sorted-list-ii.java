class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp=head;
        ListNode prev=null;
        ListNode dummy=new ListNode(0,head);
        prev=dummy;

        while(temp!=null && temp.next!=null){
            if(temp.val==temp.next.val){
                while(temp.next!=null && temp.val==temp.next.val){
                    temp=temp.next;
                }
                prev.next=temp.next;
                temp=temp.next;
            }
            else{
                prev=temp;
                temp=temp.next;
            }
        }
        return dummy.next;
    }
}