class Solution {
    public int maxArea(int[] height) {
        int i=0;
        int j=height.length-1;
        int max=Integer.MIN_VALUE;
        int area=1;
        while(i<j){
            if(height[i]<height[j]){
                area=height[i]*(j-i);
                max=Math.max(max,area);
                i++;
            }
            else if(height[i]>height[j]){
                area=height[j]*(j-i);
                max=Math.max(max,area);
                j--;
            }
            else{
                area=height[j]*(j-i);
                max=Math.max(max,area);
                i++;
                j--;
                
            }

        }
        return max;
        
    }
}