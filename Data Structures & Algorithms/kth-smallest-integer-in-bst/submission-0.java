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
    public int kthSmallest(TreeNode root, int k) {
        int[] tmp = new int[2];
        tmp[0] = k;
        dfs(root, tmp);
        return tmp[1];
    }

    private void dfs(TreeNode node, int[] result){
        if(node == null){
            return;
        }

        dfs(node.left, result);
        if(result[0] == 0){
            return;
        }
        
        result[0]--;
        if(result[0] == 0){
            result[1] = node.val;
            return;
        }

        dfs(node.right, result);
    }
}
