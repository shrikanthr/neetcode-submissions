class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while(r>l){
            int m = l+(r-l)/2;
            if(nums[r]>nums[m]){
                r= m;
            }
            else {
                l = m+1;
            }
        }

        int pivot = l;
        System.out.println(pivot);
        l = pivot;
        r= nums.length-1;
        while(l<=r){
            int m = l+(r-l)/2;
            if(nums[m]==target){
                return m;
            }
            if(nums[m] > target){
                r=m-1;
            } else{
                l=m+1;
            }
        }

        r = pivot; 
        l = 0;
        while(l<=r){
            int m = l+(r-l)/2;
            if(nums[m] == target){
                return m;
            }else if(nums[m]>target){
                r=m-1;
            }else {
                l = m+1;
            }
        }

        return -1;
    }
}
