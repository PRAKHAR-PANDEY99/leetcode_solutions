class Solution {
    ListNode fn(ListNode root){
        if(root==null){
            return null;
        }
        if(root.next==null){
            return root;
        }
        ListNode temp=root.next.next;
        ListNode second=root.next;
        second.next=root;
        root.next=fn(temp);
        return second;
    }

    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        return fn(head);
    }
}