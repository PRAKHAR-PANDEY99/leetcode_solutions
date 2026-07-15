class Solution {
    int gcd(int a,int b){
         while (b != 0) {
            int rem = a % b;
            a = b;
            b = rem;
        }
        return a;
    }
    public int gcdOfOddEvenSums(int n) {
        int even=0;
        int odd=0;
        even=(n)*(2*2+(n-1)*2)/2;
        odd= (n)*(2*1+(n-1)*2)/2;
        int ans=gcd(even,odd);
        return ans;
    }
}