class Solution {
    void dfs(String s,List<String> dict,int i,List<String> list,List<String> ans){
      if(i==s.length()){
    ans.add(String.join(" ",list));
    return;
}
        for(int j=0;j<dict.size();j++){
            if(s.length()>=i+dict.get(j).length()){
             if(s.substring(i,i+dict.get(j).length()).equals(dict.get(j))){
                list.add(dict.get(j));
                dfs(s,dict,i+dict.get(j).length(),list,ans);
                list.remove(list.size()-1);
                }
            }
        }
        return;
 
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> ans=new ArrayList<>();
        dfs(s,wordDict,0,new ArrayList<>(),ans);
        return ans;
        
    }
}