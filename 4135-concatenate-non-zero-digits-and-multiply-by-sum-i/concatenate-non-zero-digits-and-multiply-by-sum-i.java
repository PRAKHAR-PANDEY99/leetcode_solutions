class Solution {
    public long sumAndMultiply(int n) {
        String s=String.valueOf(n);
        String t="";
        int c=0;
        if(n==0) return 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='0'){
                continue;
            }
            else{
                t=t+s.charAt(i);
                c=c+(s.charAt(i)-'0');
            }
        }
        Long k=Long.valueOf(t);
        k=k*c;
        return k;
    }
}