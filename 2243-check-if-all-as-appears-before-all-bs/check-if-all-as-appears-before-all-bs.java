class Solution {
    public boolean checkString(String s) {
        int c=0;
        for(int i=0;i<s.length();i++){
            if(c==1 && s.charAt(i)=='a'){
                return false;
            }
            if(s.charAt(i)=='b'){
                c=1;
            }

        }
        return true;
        
    }
}