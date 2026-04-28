class Solution {
    public int search(int[] nums, int target) {
        int l =0;
        int r = nums.length-1;
        while(r>l){
            int m = (l+r)/2;
            if(nums[m] == target){
                return m;
            }else if(nums[m] > target){
                r = m-1;
            }else{
                l = m+1;
            }
        }

        return nums[l] == target? l:-1;
    }
}
