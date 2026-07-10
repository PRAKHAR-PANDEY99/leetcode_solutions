/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Set<TreeNode> list = new HashSet<>();
        List<Integer> l=new ArrayList<>();
        Queue<TreeNode> qu=new LinkedList<>();
        HashMap<TreeNode,TreeNode> map=new HashMap<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        if(root.left==null && root.right==null) return new ArrayList<>();
        while(!q.isEmpty()){
            int s=q.size();
            for(int i=0;i<s;i++){
                TreeNode node=q.poll();
                if(node.left!=null){
                    q.add(node.left);
                    map.put(node.left,node);
                }
                if(node.right!=null){
                    q.add(node.right);
                    map.put(node.right,node);
                }   

            }   
        }
        qu.add(target);
        int dist=0;
        list.add(target);
        while(!qu.isEmpty()){
            if(dist==k) break;
            int sizeq=qu.size();
            dist++;
            for(int j=0;j<sizeq;j++){
                TreeNode n=qu.poll();

                if(map.containsKey(n)){
                    TreeNode nn=map.get(n);
                    if(!list.contains(nn)){
                    list.add(nn);
                    qu.add(nn);

                    }
                    
                }
                if(n.left!=null && !list.contains(n.left)){
                    list.add(n.left);
                    qu.add(n.left);
                }
                if(n.right!=null && !list.contains(n.right)){
                    list.add(n.right);
                    qu.add(n.right);
                }

            }
        }
        for(TreeNode x:qu){
            l.add(x.val);
        }
        return l;
    }
}