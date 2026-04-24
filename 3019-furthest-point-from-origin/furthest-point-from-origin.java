class Solution {
    public int furthestDistanceFromOrigin(String moves) {
          int sum1=0;
          int sum=0;
          for(int i=0;i<moves.length();i++){
            if(moves.charAt(i)=='L' || moves.charAt(i)=='_'){
                sum=sum-1;
            }
            else{
                sum=sum+1;
            }
            if(moves.charAt(i)=='R' || moves.charAt(i)=='_'){
                sum1=sum1+1;
            }
            else{
                sum1=sum1-1;
            }
          }
        return Math.max(Math.abs(sum),Math.abs(sum1));

    }
}