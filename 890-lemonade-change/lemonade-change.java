class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five=0;
        int ten=0;
        int fif=0;
        for(int i=0;i<bills.length;i++){
            if(bills[i]==5){
                five=five+1;
            }
            else if(bills[i]==10){
                five=five-1;
                ten=ten+1;
                if(five<0) return false;
            }
            else{
                if(ten>0){
                    ten--;
                }
                else{
                    five=five-2;
                }
                five--;
                if(ten<0 || five<0) return false;
            }

        }
        return true;
        
    }
}