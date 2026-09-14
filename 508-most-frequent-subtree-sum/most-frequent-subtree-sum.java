class Solution {
    int max = Integer.MIN_VALUE;

    int dfs(TreeNode root, HashMap<Integer,Integer> map) {
        if(root == null) return 0;

        int left = dfs(root.left, map);
        int right = dfs(root.right, map);

        int sum = root.val + left + right;

        map.put(sum, map.getOrDefault(sum, 0) + 1);
        max = Math.max(max, map.get(sum));

        return sum;
    }

    public int[] findFrequentTreeSum(TreeNode root) {
        HashMap<Integer,Integer> map = new HashMap<>();

        if(root == null) return new int[]{};

        dfs(root, map);

        List<Integer> list = new ArrayList<>();

        for(int key : map.keySet()) {
            if(map.get(key) == max) {
                list.add(key);
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}