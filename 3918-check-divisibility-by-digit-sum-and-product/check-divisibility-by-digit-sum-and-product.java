class Solution {
    int sum(int n){
        int su=0;
        while(n>0){
            int rem=n%10;
            n=n/10;
            su=su+rem;
        }
        return su;
    }
    long mul(int n){
        long mul=1;
        while(n>0){
            int rem=n%10;
            n=n/10;
            mul=mul*rem;
        }
        return mul;
    }
    public boolean checkDivisibility(int n) {
        int an=sum(n);
        long s=mul(n);
        long suu=an+s;
        if((n%suu)==0){
            return true;
        }
        return false;
        
        
    }
}