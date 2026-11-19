class Solution {
    public String intToRoman(int num) {
        String s=String.valueOf(num);
        String rev=new StringBuilder(s).reverse().toString();
        int size=s.length();
        int i=0;
        String ans="";
        while(i<size){
            int digit=rev.charAt(i)-'0';
            if(i==0){
                if(digit==4) ans="IV"+ans;
                else if(digit==9) ans="IX"+ans;
                else if(digit>=5) ans="V"+"I".repeat(digit-5)+ans;
                else ans="I".repeat(digit)+ans;
            }
            else if(i==1){
                if(digit==4) ans="XL"+ans;
                else if(digit==9) ans="XC"+ans;
                else if(digit>=5) ans="L"+"X".repeat(digit-5)+ans;
                else ans="X".repeat(digit)+ans;
            }
            else if(i==2){
                if(digit==4) ans="CD"+ans;
                else if(digit==9) ans="CM"+ans;
                else if(digit>=5) ans="D"+"C".repeat(digit-5)+ans;
                else ans="C".repeat(digit)+ans;
            }
            else if(i==3){
                ans="M".repeat(digit)+ans;
            }

            i++;
        }

        return ans;
    }
}