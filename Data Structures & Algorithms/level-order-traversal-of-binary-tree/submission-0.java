/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Map<Integer, List<Integer>> levels = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i =0;i<size;i++){
                TreeNode node = q.poll();
                List<Integer> vals = levels.getOrDefault(level, new ArrayList<>());
                vals.add(node.val);
                levels.put(level,vals);
                if(node.left!=null){
                    q.offer(node.left);
                }
                if(node.right !=null){
                    q.offer(node.right);
                }
            }

            level++;
        }

        for(int i = 0;i<level;i++){
            result.add(levels.get(i));
        }

        return result;
    }
}
