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
    static int count = Integer.MIN_VALUE;
    public int goodNodes(TreeNode root) {
        count = 0;
        dfs(root, Integer.MIN_VALUE);
        return count;
    }

    static void dfs(TreeNode root, int maxValueTillNow) {
        if(root == null) return;
        
        if(root.val >= maxValueTillNow){
            maxValueTillNow = root.val;
            // System.out.println(root.val);
            count++;
        }

        dfs(root.left, maxValueTillNow);
        dfs(root.right, maxValueTillNow);

    }
}