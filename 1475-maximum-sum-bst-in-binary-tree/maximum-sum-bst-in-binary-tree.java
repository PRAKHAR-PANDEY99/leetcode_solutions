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

    class NodeValue {
        int min;
        int max;
        int sum;

        NodeValue(int min, int max, int sum) {
            this.min = min;
            this.max = max;
            this.sum = sum;
        }
    }

    int ans = 0;

    public int maxSumBST(TreeNode root) {
        helper(root);
        return ans;
    }

    private NodeValue helper(TreeNode root) {

        // Empty tree is a BST
        if (root == null) {
            return new NodeValue(
                Integer.MAX_VALUE,
                Integer.MIN_VALUE,
                0
            );
        }

        NodeValue left = helper(root.left);
        NodeValue right = helper(root.right);

        // Current subtree is BST
        if (left.max < root.val && root.val < right.min) {

            int currSum = left.sum + right.sum + root.val;

            ans = Math.max(ans, currSum);

            return new NodeValue(
                Math.min(left.min, root.val),
                Math.max(right.max, root.val),
                currSum
            );
        }

        // Not a BST
        return new NodeValue(
            Integer.MIN_VALUE,
            Integer.MAX_VALUE,
            0
        );
    }
}