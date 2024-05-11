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
    int maxLength = 0;
    public int longestZigZag(TreeNode root) {
        // if(root == null) return 0;
        dfs(root, 0, 0);
        dfs(root, 1, 0);
        return maxLength;
    }
    public void dfs(TreeNode root, int dir, int currentLength) {
        if(root == null) return;

        maxLength = Math.max(maxLength, currentLength);
        if(dir == 1) {
            dfs(root.left, 0, currentLength + 1);
            dfs(root.right, 1, 1);
        } else {
            dfs(root.right, 1, currentLength + 1);
            dfs(root.left, 0, 1);
        }

    }
}