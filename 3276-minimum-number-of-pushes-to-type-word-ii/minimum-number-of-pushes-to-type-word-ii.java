class Solution {

    public int minimumPushes(String word) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<word.length();i++){
            if(map.containsKey(word.charAt(i))){
                map.put(word.charAt(i),map.get(word.charAt(i))+1);
            }
            else{
                map.put(word.charAt(i),1);

            }
        }
       List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a, b) -> b.getValue() - a.getValue());
        int sum=0;
        int c=1;
        for(int i=0;i<list.size();i++){
            if(i!=0 && i%8==0){
                c=c+1;
            }
            sum=sum+list.get(i).getValue()*c;
            

        }
        return sum;



        
        
    }
}