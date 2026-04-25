class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        Set<Integer> occ = new HashSet<Integer>();
        for(int i=0;i<nums.length;i++){
            occ.add(nums[i]);
        }

        int maxLength = 1;
        for(int i =0;i<nums.length;i++){
            if(occ.contains(nums[i]-1)){
                continue;
            }

            int length = 1;
            int next = nums[i]+length;
            
            while(occ.contains(next)){
                length =length+1;
                maxLength = Math.max(maxLength,length);
                next = nums[i]+length;
            }
        }

        return maxLength;
    }
}
