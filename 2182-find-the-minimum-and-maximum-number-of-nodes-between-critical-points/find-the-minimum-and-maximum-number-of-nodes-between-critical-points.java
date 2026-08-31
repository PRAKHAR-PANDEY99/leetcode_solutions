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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if(head.next==null || head.next.next==null) return new int[]{-1,-1};
        ListNode prev=head;
        ListNode temp=head.next;
        int i=2;
        List<Integer> list=new ArrayList<>();
        while(temp!=null){
            if(temp.next!=null){
                if(prev.val>temp.val && temp.next.val>temp.val){
                    list.add(i);
                }
                else if(prev.val<temp.val && temp.next.val<temp.val){
                    list.add(i);
                }
            }
            i=i+1;
            prev=temp;
            temp=temp.next;
        }
        Collections.sort(list);
        if(list.size()<2){
            return new int[]{-1,-1};
        }
        int large=list.get(list.size()-1)-list.get(0);
        int small=Integer.MAX_VALUE;
        for(int j=1;j<list.size();j++){
            small=Math.min((list.get(j)-list.get(j-1)),small);
        }
        return new int[]{small,large};
        
    }
}