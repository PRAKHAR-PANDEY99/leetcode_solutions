class Solution {
    public int[] arrayRankTransform(int[] arr) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int [] copy=Arrays.copyOf(arr,arr.length);
        Arrays.sort(arr);
        int c=1;
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i])){
                continue;
            }
            else{
                map.put(arr[i],c);
                c=c+1;
            }
        }
        for(int j=0;j<arr.length;j++){
            arr[j]=map.get(copy[j]);

        }
        return arr;
        

        
    }
}