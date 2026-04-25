class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        Set<Integer> ints = new HashSet<>();
        for(int num:nums){
            ints.add(num);
        }

        int max = 1;
        for(int num: nums){
            if(ints.contains(num-1)){
                continue;
            }

            int currLen = 1;
            int next = num+1;
            while(ints.contains(next)){
                currLen++;
                max = Math.max(max, currLen);
                next++;
            }
        }

        return max;
    }
}
