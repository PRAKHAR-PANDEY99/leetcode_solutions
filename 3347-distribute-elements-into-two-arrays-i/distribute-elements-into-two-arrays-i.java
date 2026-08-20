class Solution {
    public int[] resultArray(int[] nums) {
        if(nums.length<=2){
            return nums;
        }
        int[] arr1=new int[nums.length];
        int[] arr2=new int[nums.length];
        int idx1=0;
        int idx2=0;
        arr1[idx1]=nums[0];
        arr2[idx2]=nums[1];
        for(int i=2;i<nums.length;i++){
            if(arr1[idx1]>arr2[idx2]){
                idx1=idx1+1;
                arr1[idx1]=nums[i];
            }
            else{
                idx2=idx2+1;
                arr2[idx2]=nums[i];
            }

        }
        int [] a=new int[nums.length];
        int k=0;
        for(int i=0;i<=idx1;i++){
            a[k]=arr1[i];
            k++;
        }
        for(int i=0;i<=idx2;i++){
            a[k]=arr2[i];
            k++;
        }
        return a;
    }
}