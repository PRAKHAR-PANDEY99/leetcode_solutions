class Solution {
    public int numberOfSubstrings(String s) {
        int r=0;
        int count=0;
        int lastseen=-1;
        HashMap<Character,Integer> map=new HashMap<>();
        while(r<s.length()){
            map.put(s.charAt(r),r);
            if(map.size()==3){
                int a=Math.min(map.get('a'),map.get('b'));
                count=count+1+Math.min(a,map.get('c'));
            }
            r++;
        }
    
        return count;
        
    }
}