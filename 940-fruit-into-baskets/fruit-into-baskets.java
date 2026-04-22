class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer,Integer> freq=new HashMap<>();
        int l=0;
        int r=0;
        int max=0;
        int len=0;
        while(r<fruits.length){
            if (freq.containsKey(fruits[r])) {
                freq.put(fruits[r], freq.get(fruits[r]) + 1);
            } else {
                freq.put(fruits[r], 1);
            }
            if(freq.size()>2){
                freq.put(fruits[l],freq.get(fruits[l])-1);
                if(freq.get(fruits[l])==0) freq.remove(fruits[l]);
                l++;      
            }
            else{
                len=r-l+1;
                max=Math.max(max,len);
            }
            r++;
        }
        return max;
        
    }
}