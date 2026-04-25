class Solution {
    private final List<List<Integer>> result = new ArrayList<List<Integer>>();    
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        dfs(0, new ArrayList(), 0, nums, target);
        return result;
    }

    private void dfs(int i, List<Integer> current, int total, final int[] nums, final int target){
        if(i >= nums.length || total > target){
            return;
        }

        List<Integer> copy = new ArrayList(current);
        if(total == target){
            result.add(copy);
            return;
        }
        copy.add(nums[i]);
        dfs(i, copy, total+nums[i], nums, target);
        dfs(i+1, current, total, nums, target);
    }
}
