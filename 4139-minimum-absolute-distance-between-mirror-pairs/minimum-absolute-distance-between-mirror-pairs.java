class Solution {
    public static int reverse(int x) {
    int reversed = 0;

    while (x != 0) {
        int digit = x % 10;   // get last digit
        x = x / 10;           // remove last digit

        // check overflow before multiplying
        if (reversed > Integer.MAX_VALUE / 10 || 
            reversed < Integer.MIN_VALUE / 10) {
            return 0;
        }

        reversed = reversed * 10 + digit;
    }

    return reversed;
}
    public int minMirrorPairDistance(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int min=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                int j=map.get(nums[i]);
                min=Math.min(min,Math.abs(i-j));
            }
            int rev=reverse(nums[i]);
            map.put(rev,i);
        }
        return min==Integer.MAX_VALUE? -1:min;
        
    }
}