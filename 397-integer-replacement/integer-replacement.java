
import java.util.*;
class Solution {
    int fn(int n,HashMap<Integer,Integer> dp){
        if(n==1){
            return 0;
        }
        if(dp.containsKey(n)){
            return dp.get(n);
        }
        int ans;
        if(n%2==0){
            ans=1+fn(n/2,dp);
        }
        else{
            ans=1+Math.min(fn(n-1,dp),fn(n/2+1,dp)+1);
        }
        dp.put(n,ans);
        return ans;
    }
    public int integerReplacement(int n) {
        HashMap<Integer,Integer> dp=new HashMap<>();
        return fn(n,dp);
    }
}
