class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        sum(nums, target, 0, 0, new ArrayList<>());
        return result;
    }

    private void sum(int[] nums, int target, int i, int sum, List<Integer> curr){
        if(target == sum){
            result.add(new ArrayList<>(curr));
            return;
        }

        if(i == nums.length || target < sum){
            return;
        }

        curr.add(nums[i]);
        sum(nums, target, i, sum+nums[i], curr);
        curr.remove(curr.size()-1);

        sum(nums, target, i+1, sum, curr);
    }
}
