import java.util.*;

class Solution {

    public int find(int n, List<Integer> parent) {
        if (parent.get(n) == n)
            return n;

        int par = find(parent.get(n), parent);
        parent.set(n, par);
        return par;
    }

    public void unionBySize(int u, int v, List<Integer> size, List<Integer> parent) {
        int uu = find(u, parent);
        int vv = find(v, parent);

        if (uu == vv)
            return;

        if (size.get(uu) < size.get(vv)) {
            parent.set(uu, vv);
            size.set(vv, size.get(vv) + size.get(uu));
        } else {
            parent.set(vv, uu);
            size.set(uu, size.get(uu) + size.get(vv));
        }
    }

    public int removeStones(int[][] stones) {

        List<Integer> parent = new ArrayList<>();
        List<Integer> size = new ArrayList<>();

        int n = stones.length;

        for (int i = 0; i < n; i++) {
            parent.add(i);
            size.add(1);
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                if (stones[i][0] == stones[j][0] ||
                    stones[i][1] == stones[j][1]) {

                    unionBySize(i, j, size, parent);
                }
            }
        }

        int comp = 0;

        for (int i = 0; i < n; i++) {
            if (find(i, parent) == i)
                comp++;
        }

        return n - comp;
    }
}