class Solution {
    public boolean canReorderDoubled(int[] arr) {
        Arrays.sort(arr);
        HashMap<Integer,Integer> map=new HashMap<>();
        int j=0;
        boolean t=true;

        for(int i=0;i<arr.length;i++){
            if(arr[i]<0) j=i;
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        for(int i=j;i>=0;i--){
            if(map.containsKey(arr[i]) && map.get(arr[i])>0){
                if(map.containsKey(arr[i]*2) && map.get(arr[i]*2)>0){
                    map.put(arr[i]*2,map.get(arr[i]*2)-1);
                    map.put(arr[i],map.get(arr[i])-1);
                }
                else{
                    return false;
                }
            }
        }
        for(int i=j+1;i<arr.length;i++){
            if(map.containsKey(arr[i]) && map.get(arr[i])>0){
                if(map.containsKey(arr[i]*2) && map.get(arr[i]*2)>0){
                    map.put(arr[i]*2,map.get(arr[i]*2)-1);
                    map.put(arr[i],map.get(arr[i])-1);
                }
                else{
                    return false;
                }
            }
        }
        return t;

        
    }
}