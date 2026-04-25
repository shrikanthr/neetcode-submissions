class Solution {
    public int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        if(nums.length==1)
        {
            return nums[0];
        }
        int l = 0;
        int r = nums.length - 1;
        while(l<r){
            int m = l+(r - l)/2;
            if(nums[m] < nums[r]){
                r = m;            
            } else {
                l = m+1;
            }
        }

        return nums[l];
    }
}
