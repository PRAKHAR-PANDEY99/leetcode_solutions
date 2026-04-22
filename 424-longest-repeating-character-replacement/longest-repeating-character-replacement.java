class Solution {
    public int characterReplacement(String s, int k) {
        int l=0;
        int r=0;
        int maxf=0;
        int maxlen=0;
        HashMap<Character,Integer> map=new HashMap<>();
        while(r<s.length()){
            if(map.containsKey(s.charAt(r))){
                map.put(s.charAt(r),map.get(s.charAt(r))+1);
            }
            else{
                map.put(s.charAt(r),1);
            }
            maxf=Math.max(maxf,map.get(s.charAt(r)));
            if((r-l+1-maxf)>k){
                map.put(s.charAt(l),map.get(s.charAt(l))-1);
                l++;
            }
            if((r-l+1-maxf)<=k){
                maxlen=Math.max(maxlen,r-l+1);
            }
            r++;

        }  
        return maxlen;
    }
}