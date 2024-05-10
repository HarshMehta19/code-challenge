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
    public int maxDepth(TreeNode root) {
        return bfs(root, 0);
    }

    int bfs(TreeNode root, int count) {
        if(root == null) return 0;

        int left = 0, right = 0;
        if(root.left == null && root.right == null) return 1;
        if(root.left != null)
            left = 1 + bfs(root.left, count+1);
        
        if(root.right != null)
            right = 1+bfs(root.right, count+1);
        
        return Math.max(left, right);
    }
}