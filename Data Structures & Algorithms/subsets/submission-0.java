class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        subsets(nums, 0, new ArrayList<>());
        return result;
    }

    private void subsets(int[] nums, int start, List<Integer> curr){
        result.add(new ArrayList<>(curr));
        while(start<nums.length){
            curr.add(nums[start]);
            start++;
            subsets(nums, start, curr);
            curr.remove(curr.size()-1);
        }
    }
}