class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] matrix=new int[n][n];
        for(int i=0;i<edges.length;i++){
            int row=edges[i][0];
            int col=edges[i][1];
            int dis=edges[i][2];
            matrix[row][col]=dis;
            matrix[col][row]=dis;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j && matrix[i][j]==0){
                    matrix[i][j]=-1;
                }
                else if(i==j){
                    matrix[i][j]=0;
                }
            }
        }
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(matrix[i][k]==-1 || matrix[k][j]==-1){
                        continue;
                    }
                    if(matrix[i][j]==-1){
                        matrix[i][j]=matrix[i][k]+matrix[k][j];
                    }
                    else{
                        matrix[i][j]=Math.min(matrix[i][j],matrix[i][k]+matrix[k][j]);
                    }
                }
            }
        }
        int[] freq=new int[n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j && matrix[i][j]<=distanceThreshold && matrix[i][j]!=-1){
                    freq[i]=freq[i]+1;

                }
            }
        }
        int max=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(max>freq[i]){
                max=freq[i];
            }

        }
        int maxvar=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(freq[i]==max){
                if(maxvar<i){
                    maxvar=i;
                }
            }
        }
        return maxvar;

    }
}