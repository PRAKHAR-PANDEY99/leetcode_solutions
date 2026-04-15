import java.util.*;

class Solution {

    static int[] pre(int[] arr, int index, Stack<Integer> st1, int[] nums) {
        for (int i = 0; i < index; i++) {
            while (!st1.isEmpty() && arr[st1.peek()] > arr[i]) {
                st1.pop();
            }
            if (st1.isEmpty()) {
                nums[i] = -1;
            } else {
                nums[i] = st1.peek();
            }
            st1.push(i);
        }
        return nums;
    }

    static int[] nes(int[] arr, int index, Stack<Integer> st2, int[] nums2) {
        int n = arr.length;
        for (int i = index; i >= 0; i--) {
            while (!st2.isEmpty() && arr[st2.peek()] >= arr[i]) {
                st2.pop();
            }
            if (st2.isEmpty()) {
                nums2[i] = n; 
            } else {
                nums2[i] = st2.peek();
            }
            st2.push(i);
        }
        return nums2;
    }

    public int sumSubarrayMins(int[] arr) {
        int[] nums = new int[arr.length];
        int[] nums2 = new int[arr.length];

        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();

        nums = pre(arr, arr.length, st1, nums);
        nums2 = nes(arr, arr.length - 1, st2, nums2);

        long sum = 0;
        int mod = 1000000007;

        for (int j = 0; j < nums.length; j++) {
            long left = j - nums[j];
            long right = nums2[j] - j;
            sum = (sum + (left * right % mod) * arr[j] % mod) % mod;
        }

        return (int) sum;
    }
}