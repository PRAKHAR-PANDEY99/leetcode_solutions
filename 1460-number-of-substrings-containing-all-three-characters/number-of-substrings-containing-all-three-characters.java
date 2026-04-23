class Solution {
    public int numberOfSubstrings(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        int r=0;
        int l=0;
        int count=0;
        int len=s.length();
        while(r<s.length()){
               if(map.containsKey(s.charAt(r))){
                map.put(s.charAt(r),map.get(s.charAt(r))+1);
               }
               else{
                map.put(s.charAt(r),1);
               }
             if(map.size()==3){
                while(map.size()==3){
                    count=count+(len-r);
                    map.put(s.charAt(l),map.get(s.charAt(l))-1);
                    if(map.get(s.charAt(l))==0) map.remove(s.charAt(l));
                    l++;
                }

            }
            r++;
        }
        return count;
        
    }
}