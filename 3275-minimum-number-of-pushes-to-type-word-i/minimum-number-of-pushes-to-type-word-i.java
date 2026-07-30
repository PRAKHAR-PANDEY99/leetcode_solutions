class Solution {
    public int minimumPushes(String word) {
        int len=word.length();
        if(len<=8) return len;
        int a=len/8;
        int rem=len%8;
        int ans=0;
        // for(int i=1;i<=a;i++){
        //     ans=ans+(8*i);
        // }
        // ans=ans+(rem*(a+1));
        // return ans;  
        ans=(8*a*(a+1))/2;
        ans=ans+(rem*(a+1));
        return ans;
    }
}