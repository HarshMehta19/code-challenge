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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1) return new TreeNode(val, root, null);
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int count = 1;

        while(!q.isEmpty() && count < depth) {
            int size = q.size();

            for(int i=0;i<size;i++) {
                TreeNode node = q.poll();
                if(count == depth - 1) {
                    node.left = new TreeNode(val, node.left, null);
                    node.right = new TreeNode(val, null, node.right);
                } else {
                    if(node.left != null) q.offer(node.left);
                    if(node.right != null) q.offer(node.right);
                }
            }
            count++;
        }
        return root;
    }
}