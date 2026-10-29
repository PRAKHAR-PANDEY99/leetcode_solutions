class Solution {
    public int bulbSwitch(int n) {
        if(n==0) return 0;
        int c=1;
        for(int i=2;i<=n;i++){
            int x=(int)Math.sqrt(i);
            if((x*x)==i){
                c=c+1;
            }
            else{
                int a=1;
            }

        }
       
        return c;
        //return (int)Math.sqrt(n);
    }
}