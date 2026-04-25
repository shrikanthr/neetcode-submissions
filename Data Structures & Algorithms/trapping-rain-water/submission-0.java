class Solution {
    public int trap(int[] height) {
        int l = 0;
        int r = height.length-1;
        int left = height[l];
        int right = height[r];
        int result = 0;
        while(r>l){
            if(left < right){
                l++;
                left = Math.max(height[l], left);
                result+=left - height[l];
            }else{
                r--;
                right = Math.max(height[r], right);
                result+=right - height[r];
            }
        }

        return result;
    }
}
