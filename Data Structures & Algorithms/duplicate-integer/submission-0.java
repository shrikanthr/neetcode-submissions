class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> occurrences = new HashSet<Integer>();
        for(int i =0;i<nums.length;i++){
            if(occurrences.contains(nums[i])){
                return true;
            }

            occurrences.add(nums[i]);
        }

        return false;
    }
}