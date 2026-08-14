class Solution {
    public int maximumLengthSubstring(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        int max=0;
        char[] sc=s.toCharArray();
        int i=0;
        int j=0;
        while(i<sc.length && j<sc.length){
            map.put(sc[i],map.getOrDefault(sc[i],0)+1);
            if(map.get(sc[i])>2){
                while(map.get(sc[i])>2){
                    map.put(sc[j],map.get(sc[j])-1);
                    j++;
                }
            }
            max=Math.max(i-j+1,max);
            i++;
        }

        return max;
        
    }
}