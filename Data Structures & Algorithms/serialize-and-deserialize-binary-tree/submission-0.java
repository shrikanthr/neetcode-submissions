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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return "NULL";
        }

        return root.val + "#" + serialize(root.left) + "#" + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split("#")));
        return construct(queue);
    }

    private TreeNode construct(Queue<String> q){
        String stringVal = q.poll();
        if(stringVal.equals("NULL")){
            return null;
        }

        Integer val = Integer.parseInt(stringVal);
        TreeNode n = new TreeNode(val);
        n.left = construct(q);
        n.right = construct(q);

        return n;
    }
}
