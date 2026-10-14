
class Solution {
    public String maxSumOfSquares(int num, int sum) {
        String s="";
        if(num==1 && sum<10){
            return String.valueOf(sum);
        }

        if(Math.ceil((double)sum/num)>9){
            return "";
        }

        if(sum>=10 && num<=1){
            return "";
        }
        if(sum<10 && num>=2){
            s=String.valueOf(sum)+"0".repeat(num-1);
        }
        if(sum>=10){
            int count=sum/9;
            int rem=sum%9;

            if(count>num){
                return "";
            }

            s="9".repeat(count);
            num=num-count;

            if(rem>0 && num>0){
                s=s+String.valueOf(rem);
                num--;
            }

            s=s+"0".repeat(num);
        }

        return s;
    }
}