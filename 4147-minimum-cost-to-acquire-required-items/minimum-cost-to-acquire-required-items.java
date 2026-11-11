class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long sum=0;
        long chk1=0;
        long chk2=0;
        chk1=(long)need1*cost1;
        chk2=(long)need2*cost2;
        sum=chk1+chk2;
        long chk3=0;
        long chk4=0;
        if(need1<need2){
            chk3=(long)need1*costBoth;
            chk4=(long)need2*costBoth;
        }
        else{
            chk3=(long)need2*costBoth;
            chk4=(long)need1*costBoth;
        }
        long chk5=0;
        long chk6=0;
        if(sum>chk3){
            if(need1<need2){
                chk5=(long)(need2-need1)*cost2;
                chk6=chk3+chk5;
            }
            else{
                chk5=(long)(need1-need2)*cost1;
                chk6=chk3+chk5;
            }
        }
        if(sum>chk6 && chk6!=0){
            sum=chk6;
        }
        if(sum>chk4){
            sum=chk4;
        }
        return sum;
    }
}
