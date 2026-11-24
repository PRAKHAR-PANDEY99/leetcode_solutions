
class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        Queue<int[]> q=new LinkedList<>();
        Queue<int[]> q1=new LinkedList<>();
        int m=heights.length;
        int n=heights[0].length;
        int[][] vis=new int[m][n];
        int[][] vis1=new int[m][n];
        for(int i=0;i<n;i++){
            q.add(new int[]{0,i});
            q1.add(new int[]{m-1,i});
            vis[0][i]=1;
            vis1[m-1][i]=1;
        }
        for(int i=0;i<m;i++){
            q.add(new int[]{i,0});
            q1.add(new int[]{i,n-1});
            vis[i][0]=1;
            vis1[i][n-1]=1;
        }
        int[] r={-1,1,0,0};
        int[] c={0,0,-1,1};
        while(!q.isEmpty()){
            int[] p=q.poll();
            int val=heights[p[0]][p[1]];
            for(int i=0;i<4;i++){
                int nr=p[0]+r[i];
                int nc=p[1]+c[i];

                if(nr>=0 && nc>=0 && nr<m && nc<n &&
                   vis[nr][nc]==0 && val<=heights[nr][nc]){

                    vis[nr][nc]=1;
                    q.offer(new int[]{nr,nc});
                }
            }
        }

        while(!q1.isEmpty()){
            int[] p=q1.poll();
            int val=heights[p[0]][p[1]];
            for(int i=0;i<4;i++){
                int nr=p[0]+r[i];
                int nc=p[1]+c[i];
                if(nr>=0 && nc>=0 && nr<m && nc<n &&
                   vis1[nr][nc]==0 && val<=heights[nr][nc]){
                    vis1[nr][nc]=1;
                    q1.offer(new int[]{nr,nc});
                }
            }
        }
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(vis[i][j]==1 && vis1[i][j]==1){
                    ans.add(Arrays.asList(i,j));
                }
            }
        }

        return ans;
    }
}
