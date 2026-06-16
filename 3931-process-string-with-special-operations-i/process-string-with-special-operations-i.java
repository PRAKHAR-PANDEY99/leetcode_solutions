class Solution {
    static String lastremove(String s){
        int si=s.length();
        if(s.equals("")) return s;
        s = s.substring(0, s.length() - 1);
        return s;
    }
    static String duplicate(String e){
        return e+e;
    }
    static String reverse(String h){
        String rev = new StringBuilder(h).reverse().toString();
        return rev;
    }
    public String processStr(String s) {
        String ans="";
        for(int i=0;i<s.length();i++){
            if((s.charAt(i))=='*'){
                ans=lastremove(ans);
            }
            else if(s.charAt(i)=='#'){
                ans=duplicate(ans);
            }
            else if(s.charAt(i)=='%'){
                ans=reverse(ans);
            }
            else{
                ans=ans+s.charAt(i);
            }
        }
        return ans;
        
    }
}