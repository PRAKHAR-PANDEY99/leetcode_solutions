class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                j = i;
                break;
            }
            else if (i != 0 && arr[i-1] < x && x < arr[i]) {
                if (x - arr[i-1] <= arr[i] - x) {
                    j = i - 1;
                } else {
                    j = i;
                }
                break;
            }
        }
        if (x <= arr[0]) {
            j = 0;
        }
        if (x > arr[arr.length - 1]) {
            j = arr.length - 1;
        }
        if (j == 0) {
            for (int i = 0; i < k; i++) {
                list.add(arr[i]);
            }
            return list;
        }

        list.add(arr[j]);
        k--;
        int i = j - 1;
        j = j + 1;

        while (i >= 0 && j < arr.length && k > 0) {
            if (x - arr[i] <= arr[j] - x) {
                list.add(arr[i]);
                i--;
            } else {
                list.add(arr[j]);
                j++;
            }
            k--;
        }

        while (k > 0 && i >= 0) {
            list.add(arr[i--]);
            k--;
        }
        while (k > 0 && j < arr.length) {
            list.add(arr[j++]);
            k--;
        }

        Collections.sort(list);
        return list;
    }
}