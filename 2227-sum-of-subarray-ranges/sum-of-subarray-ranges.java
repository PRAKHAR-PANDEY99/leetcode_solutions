import java.util.*;

class Solution {

    public long subArrayRanges(int[] nums) {

        int n = nums.length;

        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        Stack<Integer> st3 = new Stack<>();
        Stack<Integer> st4 = new Stack<>();

        int[] leftMin = new int[n];
        int[] rightMin = new int[n];
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        // previous smaller
        for (int i = 0; i < n; i++) {
            while (!st1.isEmpty() && nums[st1.peek()] > nums[i]) {
                st1.pop();
            }
            leftMin[i] = st1.isEmpty() ? -1 : st1.peek();
            st1.push(i);
        }

        // next smaller
        for (int i = n - 1; i >= 0; i--) {
            while (!st2.isEmpty() && nums[st2.peek()] >= nums[i]) {
                st2.pop();
            }
            rightMin[i] = st2.isEmpty() ? n : st2.peek();
            st2.push(i);
        }

        // previous greater
        for (int i = 0; i < n; i++) {
            while (!st3.isEmpty() && nums[st3.peek()] < nums[i]) {
                st3.pop();
            }
            leftMax[i] = st3.isEmpty() ? -1 : st3.peek();
            st3.push(i);
        }

        // next greater
        for (int i = n - 1; i >= 0; i--) {
            while (!st4.isEmpty() && nums[st4.peek()] <= nums[i]) {
                st4.pop();
            }
            rightMax[i] = st4.isEmpty() ? n : st4.peek();
            st4.push(i);
        }

        long minSum = 0, maxSum = 0;

        for (int i = 0; i < n; i++) {
            long leftMinCount = i - leftMin[i];
            long rightMinCount = rightMin[i] - i;
            minSum += (long) nums[i] * leftMinCount * rightMinCount;

            long leftMaxCount = i - leftMax[i];
            long rightMaxCount = rightMax[i] - i;
            maxSum += (long) nums[i] * leftMaxCount * rightMaxCount;
        }

        return maxSum - minSum;
    }
}