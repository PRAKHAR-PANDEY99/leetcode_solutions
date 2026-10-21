import java.util.Arrays;
class Solution {
    public int minOperations(String s) {
        int n=s.length();
        char[] a=s.toCharArray();
        Arrays.sort(a);
        String rev=new String(a);
        if(rev.equals(s)){
            return 0;
        }
        if(n==2){
            return -1;
        }
        if(s.charAt(0)==rev.charAt(0) || 
           s.charAt(n-1)==rev.charAt(n-1)){
            return 1;
        }
        for(int i=1;i<n-1;i++){
    if(s.charAt(i)==rev.charAt(0) ||
       s.charAt(i)==rev.charAt(n-1)){
        return 2;
    }
}
return 3;
    }
}