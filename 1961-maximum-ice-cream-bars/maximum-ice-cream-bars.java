class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int n=0;
        for(int i=0;i<costs.length;i++){
            if(costs[i]<=coins){
                coins=coins-costs[i];
                n=n+1;  
            }
            else{
                break;
            }
        }
        return n;    
    }
}