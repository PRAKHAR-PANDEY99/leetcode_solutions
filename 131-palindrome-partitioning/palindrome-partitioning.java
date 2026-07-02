class Solution {
    static boolean isPallindrome(String s,int index,int i){
        while(index<=i){
            if(s.charAt(index++)!=s.charAt(i--)) return false;
        }
        return true;
    }
    static void part(String s,List<String> path,List<List<String>> list,int index){
        if(index==s.length()){
            list.add(new ArrayList<>(path));
            return;
        }
        for(int i=index;i<s.length();i++){
            if(isPallindrome(s,index,i)==true){
                path.add(s.substring(index,i+1));
                part(s,path,list,i+1);
                path.remove(path.size()-1);
            }
        }

    }
    public List<List<String>> partition(String s) {
        List<List<String>> list=new ArrayList<>();
        List<String> path=new ArrayList<>();
        part(s,path,list,0);
        return list;
        
    }
}