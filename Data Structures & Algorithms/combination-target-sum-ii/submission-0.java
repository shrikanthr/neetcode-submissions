class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        sum(candidates, 0, target, 0, new ArrayList<>());
        return result;
    }

    private void sum(int[] candidates, int i, int target, int total, List<Integer> curr){
        if(target == total){
            result.add(new ArrayList<>(curr));
            return;
        }        
        if(i == candidates.length || total > target){
            return;
        }
        curr.add(candidates[i]);
        sum(candidates, i+1, target, total+candidates[i], curr);
        curr.remove(curr.size()-1);        

        while(i+1 < candidates.length && candidates[i] == candidates[i+1]){
            i++;
        }

        sum(candidates, i+1, target, total, curr);
    }
}
