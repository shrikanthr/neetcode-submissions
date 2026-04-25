class Solution {
    public int maxArea(int[] heights) {
        int l =0;
        int r = heights.length-1;
        int max = 0;
        while(l<r){
            int h = Math.min(heights[l], heights[r]);
            int w = r-l;
            max = Math.max(max, w*h);
            if(heights[l]>heights[r]){
                r--;
            }else{
                l++;
            }
        }

        return max;
    }
}
