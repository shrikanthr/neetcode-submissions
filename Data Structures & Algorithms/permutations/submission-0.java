class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums, new ArrayList<>());
        return result;
    }

    private void backtrack(int[] nums, List<Integer> curr){
        if(curr.size() == nums.length){
            result.add(new ArrayList<>(curr));
            return;
        }

        for(int i = 0; i<nums.length;i++){
            if(curr.contains(nums[i])){
                continue;
            }
            curr.add(nums[i]);
            backtrack(nums, curr);
            curr.remove(curr.size()-1);
        }
    }
}