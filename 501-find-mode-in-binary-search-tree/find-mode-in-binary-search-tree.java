class Solution {
    void dfs(TreeNode root, HashMap<Integer, Integer> map) {
        if (root == null) return;
        dfs(root.left, map);
        if (!map.containsKey(root.val)) {
            map.put(root.val, 1);
        } else {
            map.put(root.val, map.get(root.val) + 1);
        }
        dfs(root.right, map);
    }
    public int[] findMode(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();
        dfs(root, map);
        int max = 0;
        for (int key : map.keySet()) {
            max = Math.max(max, map.get(key));
        }
        int count = 0;
        for (int key : map.keySet()) {
            if (map.get(key) == max) {
                count++;
            }
        }
        int[] ans = new int[count];
        int i = 0;
        for (int key : map.keySet()) {
            if (map.get(key) == max) {
                ans[i++] = key;
            }
        }
        return ans;
    }
}