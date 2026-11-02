class Solution {
    public String countAndSay(int n) {
        if(n==1) return "1";
        String str=countAndSay(n-1);
        StringBuilder sb=new StringBuilder();
        int i=0;
        while(i<str.length()){
            char ch=str.charAt(i);
            int cnt=0;
            while(i<str.length() && str.charAt(i)==ch){
                cnt++;
                i++;
            }
            sb.append(cnt);
            sb.append(ch);
        }
        return sb.toString();
    }
}