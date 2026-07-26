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
    private boolean result = true;
    public boolean isBalanced(TreeNode root) {
       if(root == null){
        return result;
       }

       heights(root);
       return result;
    }

    private int heights(TreeNode root){
        if(root == null){
            return 0;
        }

        int l = heights(root.left);
        int r = heights(root.right);
        if(Math.abs(l - r) > 1){
            result = false;
        }

        return Math.max(l, r) + 1;
    }
}
