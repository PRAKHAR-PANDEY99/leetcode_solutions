/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    void dfs(TreeNode root,List<Integer> list){
        if(root == null) return;
        dfs(root.left,list);
        list.add(root.val);
        dfs(root.right,list);
        return;
    }
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1=new ArrayList<>();
        List<Integer> list2=new ArrayList<>();
        dfs(root1,list1);
        dfs(root2,list2);
        int i=0;
        int j=0;
        List<Integer> list=new ArrayList<>();
        while(i<list1.size() && j<list2.size()){
            if(list1.get(i)<list2.get(j)){
                list.add(list1.get(i));
                i++;
            }
            else if(list1.get(i)>list2.get(j)){
                list.add(list2.get(j));
                j++;
            }
            else{
                list.add(list1.get(i));
                list.add(list1.get(i));
                i++;
                j++;
            }
        }
        while(i<list1.size()){
            list.add(list1.get(i));
            i++;
        }
        while(j<list2.size()){
            list.add(list2.get(j));
            j++;
        }
        return list;



        
    }
}