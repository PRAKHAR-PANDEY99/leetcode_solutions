class Solution {
    class DisjointSet{
        List<Integer> size=new ArrayList<>();
        List<Integer> parent=new ArrayList<>();
        DisjointSet(int n){
            for(int i=0;i<n;i++){
                parent.add(i);
                size.add(1);
            }
        }
        public int findpair(int u){
            if(parent.get(u)==u){
                return u;
            }
            int par=findpair(parent.get(u));
            parent.set(u,par);
            return parent.get(u);
        }
        public void unionBysize(int u,int v){
            int uu=findpair(u);
            int vv=findpair(v);
            if(uu==vv) return;
            else if(size.get(uu)<size.get(vv)){
                parent.set(uu,vv);
                size.set(vv, size.get(vv) + size.get(uu));
            }
            else if(size.get(uu)>=size.get(vv)){
                parent.set(vv,uu);
                size.set(uu, size.get(uu) + size.get(vv));
            }

        }
    }
    public int makeConnected(int n, int[][] connections) {
         DisjointSet ds = new DisjointSet(n);
         int ex=0;
         for(int i=0;i<connections.length;i++){
            int u=connections[i][0];
            int v=connections[i][1];
            if(ds.findpair(u)==ds.findpair(v)){
                ex++;
            }
            ds.unionBysize(u,v);
         }
         int comp=0;
         for(int i=0;i<n;i++){
            if(ds.findpair(i)==i){
                comp++;
            }
         }
         if (ex >= comp - 1){
                return comp - 1;
         }
        else{                
            return -1;
        }
        
    }
}