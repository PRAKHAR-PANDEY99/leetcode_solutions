class Solution {
    public int smallestNumber(int n, int t) {
        int temp=n;
        while(temp>=n && temp<=100){
            int rem=0;
            int pro=1;
            int i=temp;
            while(i>0){
                rem=i%10;
                pro=pro*rem;
                i=i/10;
            }
            if(pro%t==0){
                return temp;
            }
            else{
                temp++;
            }
        }
        return 0;
    }
}