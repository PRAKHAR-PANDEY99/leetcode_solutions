/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        if(root==null) return root;
        while(!q.isEmpty()){
            int n=q.size();
            Node prev=null;
            for(int i=0;i<n;i++){
                Node p=q.poll();
                if(p.left!=null){
                    q.offer(p.left);
                }
                if(p.right!=null){
                    q.offer(p.right);
                }
                if(i==0){
                    prev=p;
                }
                else{
                    prev.next=p;
                    prev=p;
                }
            }
            prev.next=null;
        }
        return root;
    }
}