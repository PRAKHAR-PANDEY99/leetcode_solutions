
import java.util.*;
class Solution {
    public int minSwaps(int[] nums) {
        int n=nums.length;
        int[][] arr=new int[n][3];
        for(int i=0;i<n;i++){
            int x=nums[i],sum=0;
            while(x>0){
                sum+=x%10;
                x/=10;
            }
            arr[i][0]=nums[i];
            arr[i][1]=sum;
            arr[i][2]=i;
        }
        Arrays.sort(arr,(a,b)->{
            if(a[1]!=b[1]) return a[1]-b[1];
            return a[0]-b[0];
        });
        int[] curr=new int[n];
        HashMap<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<n;i++){
            curr[i]=nums[i];
            map.put(nums[i],i);
        }
        int swaps=0;
        for(int i=0;i<n;i++){
            int target=arr[i][0];
            if(curr[i]==target) continue;
            int j=map.get(target);
            int val=curr[i];
            curr[i]=curr[j];
            curr[j]=val;
            map.put(curr[i],i);
            map.put(curr[j],j);
            swaps++;
        }
        return swaps;
    }
}
