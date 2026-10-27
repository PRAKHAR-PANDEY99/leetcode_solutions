class Solution {
    public String[] createGrid(int m, int n) {
        if(m==1 || n==1){
            if(m>n){
                String[] s=new String[m];
                Arrays.fill(s,".");
                return s;
            }
            else if(m<n){
                String s=".".repeat(n);
                return new String[]{s};
            }
            else{
                return new String[]{"."};
            }
        }
        String[] s=new String[m];
        s[0]=".".repeat(n);
        for(int i=1;i<m;i++){
            String ss="#".repeat(n-1);
            s[i]=ss+".";
        }
        return s;
        
    }
}