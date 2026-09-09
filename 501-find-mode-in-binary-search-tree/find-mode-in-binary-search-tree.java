class Solution {
    int prev = Integer.MAX_VALUE;
int count = 0;
int maxFreq = 0;
    void dfs(TreeNode root, List<Integer> list) {
    if (root == null) return;
    dfs(root.left, list);
    if (prev != Integer.MAX_VALUE && prev == root.val) {
        count++;
    } else {
        count = 1;
    }
    if (count > maxFreq) {
        maxFreq = count;
        list.clear();
        list.add(root.val);
    } else if (count == maxFreq) {
        list.add(root.val);
    }
    prev = root.val;
    dfs(root.right, list);
    return;
}
    public int[] findMode(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        dfs(root,list);
        int [] n=list.stream().mapToInt(Integer::intValue).toArray();
        return n;

        // HashMap<Integer, Integer> map = new HashMap<>();
        // dfs(root, map);
        // int max = 0;
        // for (int key : map.keySet()) {
        //     max = Math.max(max, map.get(key));
        // }
        // int count = 0;
        // for (int key : map.keySet()) {
        //     if (map.get(key) == max) {
        //         count++;
        //     }
        // }
        // int[] ans = new int[count];
        // int i = 0;
        // for (int key : map.keySet()) {
        //     if (map.get(key) == max) {
        //         ans[i++] = key;
        //     }
        // }
        // return ans;

    }
}