
class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int s1=str1.length();
        int s2=str2.length();
        int i=s2;

        while(i>0){
            if(s1%i==0 && s2%i==0){
                break;
            }
            i--;
        }

        String s=str2.substring(0,i);
        int j=0;
        int t=i;

        while(j<str2.length()){
            if(!str2.substring(j,j+t).equals(s)) return "";
            j=j+t;
        }

        j=0;
        while(j<str1.length()){
            if(!str1.substring(j,j+t).equals(s)) return "";
            j=j+t;
        }

        return s;
    }
}
