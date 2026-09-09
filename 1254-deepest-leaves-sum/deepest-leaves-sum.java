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
    int sum = 0;
    int c = -1;
    void dfs(TreeNode root, int counter) {
        if (root == null) return;

        if (counter > c) {
            c = counter;
            sum = root.val;
        } else if (counter == c) {
            sum += root.val;
        }

        dfs(root.left, counter + 1);
        dfs(root.right, counter + 1);
    }

    public int deepestLeavesSum(TreeNode root) {
        dfs(root, 0);
        return sum;
    }
}