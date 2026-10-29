class Solution {
    public int bulbSwitch(int n) {
        // int[] arr=new int[n+1];
        // for(int i=2;i<=n;i++){
        //     int x=(int)Math.sqrt(i);
        //     if((x*x)==i){
        //         arr[i]=0;
        //     }
        //     else{
        //         arr[i]=1;
        //     }

        // }
        // int c=0;
        // for(int i=1;i<=n;i++){
        //     if(arr[i]==0){
        //         c=c+1;
        //     }
        // }
        // return c;
        return (int)Math.sqrt(n);
    }
}