class Solution {
    class Pair{
        char c;
        int fr;
        Pair(char c,int fr ){
            this.c=c;
            this.fr=fr;
        }
    }
    public String reorganizeString(String s) {
        PriorityQueue<Pair> q=new PriorityQueue<>((x,y)->Integer.compare(y.fr,x.fr));
        StringBuilder ss=new StringBuilder();
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        for(Character c:map.keySet()){
            q.offer(new Pair(c,map.get(c)));
        }
        while(!q.isEmpty()){
            Pair p=q.poll();
            if(ss.length()>=1 && p.c==ss.charAt(ss.length()-1) && !q.isEmpty()){
                Pair pp=q.poll();
                ss.append(pp.c);
                if(pp.fr-1>=1){
                    q.offer(new Pair(pp.c,pp.fr-1));
                }
                q.offer(new Pair(p.c,p.fr));
                
            }
            else{
                ss.append(p.c);
                if(p.fr-1>=1){
                q.offer(new Pair(p.c,p.fr-1));
            }

            }
          
            
        }
        String sss=ss.toString();
        for(int i=1;i<sss.length();i++){
            if(sss.charAt(i)==sss.charAt(i-1)){
                return "";
            }

        }
        if(sss.length()!=s.length()) return "";
        return sss;
        
    }
}