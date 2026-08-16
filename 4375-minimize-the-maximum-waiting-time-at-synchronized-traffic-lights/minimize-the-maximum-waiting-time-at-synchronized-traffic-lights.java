class Solution {
    public int minPenalty(int period, int[] lights, int[] arrivalTime) {
        int max=0;
        int ans=0;
        for(int i=0;i<lights.length;i++){
            if(max<lights[i]){
                max=lights[i];
            }
        }
        for(int i=0;i<arrivalTime.length;i++){
            int time=arrivalTime[i]%period;
            if(time<max){
                continue;
            }
            else{
                ans=Math.max(ans,period-time);
            }

        }
        return ans;
        
    }
}