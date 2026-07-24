class Solution {
    class Pair{
        String s;
        int dis;
        Pair(String s,int dis){
            this.s=s;
            this.dis=dis;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q=new LinkedList<>();
        HashSet<String> set=new HashSet<>();
        for(int i=0;i<wordList.size();i++){
            set.add(wordList.get(i));
        }
        if(!set.contains(endWord)){
            return 0;
        }
        int count=0;
        q.offer(new Pair(beginWord,1));
        while(!q.isEmpty()){
            Pair pp=q.poll();
            String ss=pp.s;
            int d=pp.dis;
            if(ss.equals(endWord)){
                return d;
            }
            for(int i=0;i<ss.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char[] arr=ss.toCharArray();
                    arr[i]=ch;
                    String s=new String(arr);
                    if(set.contains(s)==true){
                        set.remove(s);
                        q.add(new Pair(s,d+1));
                    }
                }
            }
        }
        return 0;

    }
}