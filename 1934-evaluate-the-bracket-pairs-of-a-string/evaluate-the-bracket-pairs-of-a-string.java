class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String,String> map=new HashMap<>();
        for(int i=0;i<knowledge.size();i++){
            map.put(knowledge.get(i).get(0),knowledge.get(i).get(1));
        }
        String ans="";
        int i=0;
        while(i<s.length()){
            if(s.charAt(i)=='('){
                i=i+1;
                String g="";
                while(s.charAt(i)!=')'){
                    g=g+s.charAt(i);
                    i++;
                }
                i++;
                if(map.containsKey(g)){
                    ans=ans+map.get(g);
                }
                else{
                    ans=ans+"?";
                }

            }
            else{
                ans=ans+s.charAt(i);
                i=i+1;
            }
        }
        return ans;

        
    }
}