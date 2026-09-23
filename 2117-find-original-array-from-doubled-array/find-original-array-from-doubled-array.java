class Solution {
    public int[] findOriginalArray(int[] changed) {
        if (changed.length == 1 || changed.length % 2 != 0) {
            return new int[]{};
        }

        Arrays.sort(changed);

        HashMap<Integer, Integer> set = new HashMap<>();

        for (int i = 0; i < changed.length; i++) {
            set.put(changed[i], set.getOrDefault(changed[i], 0) + 1);
        }

        int j = 0;
        int[] arr = new int[changed.length / 2];

        for (int i = 0; i < changed.length; i++) {
            int x = changed[i];

            if (!set.containsKey(x) || set.get(x) == 0) {
                continue;
            }

            if (set.containsKey(x * 2) && set.get(x * 2) > 0) {
                set.put(x, set.get(x) - 1);
                set.put(x * 2, set.get(x * 2) - 1);

                arr[j] = x;
                j++;
            } else {
                return new int[]{};
            }
        }

        return arr;
    }
}