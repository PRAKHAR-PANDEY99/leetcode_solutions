class Solution {
    public void wiggleSort(int[] nums) {
        int n=nums.length;
        int[] copy=nums.clone();
        Arrays.sort(copy);

        int i=(n-1)/2;
        int j=n-1;
        int k=0;

        while(i>=0 && k<n){
            nums[k]=copy[i];
            i--;
            k+=2;
        }

        while(j>(n-1)/2 && k<n){
            nums[k]=copy[j];
            j--;
            k+=2;
        }

        i=(n-1)/2;
        j=n-1;
        k=1;

        while(j>(n-1)/2 && k<n){
            nums[k]=copy[j];
            j--;
            k+=2;
        }
    }
}