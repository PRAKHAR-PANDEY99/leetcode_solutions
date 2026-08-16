class Solution {
    public int nearestDrone(int[][] drones, int[] target) {
        int min=Integer.MAX_VALUE;
        int ind=-1;
        for(int i=0;i<drones.length;i++){
            int dis=Math.abs(target[0]-drones[i][0])+Math.abs(target[1]-drones[i][1]);
            if(dis<=drones[i][2]){
                if(min>dis){
                    ind=i;
                    min=dis;   
                }
            }

        }
        return ind;

    }
}