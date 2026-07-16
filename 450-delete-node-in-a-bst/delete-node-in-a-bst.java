class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        TreeNode node = root;
        TreeNode parent = null;

        // Find the node
        while (node != null && node.val != key) {
            parent = node;
            if (key < node.val)
                node = node.left;
            else
                node = node.right;
        }

        // Key not found
        if (node == null) return root;

        // Case 1 & 2 : Node has 0 or 1 child
        if (node.left == null || node.right == null) {

            TreeNode child;

            if (node.left != null)
                child = node.left;
            else
                child = node.right;

            // Deleting root
            if (parent == null)
                return child;

            if (parent.left == node)
                parent.left = child;
            else
                parent.right = child;

            return root;
        }

        // Case 3 : Node has two children
        TreeNode predParent = node;
        TreeNode pred = node.left;

        // Find maximum in left subtree
        while (pred.right != null) {
            predParent = pred;
            pred = pred.right;
        }

        // Copy predecessor value
        node.val = pred.val;

        // Delete predecessor
        if (predParent == node)
            predParent.left = pred.left;
        else
            predParent.right = pred.left;

        return root;
    }
}