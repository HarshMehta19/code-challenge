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
    String smallestStr = null;
    public String smallestFromLeaf(TreeNode root) {
        minimumLeaf(root, new StringBuilder());
        return smallestStr;

    }

    private void minimumLeaf(TreeNode root, StringBuilder curr) {
        if(root == null) return;
        curr.insert(0, (char) ('a' + root.val));
        if(root.left == null && root.right == null) {
            updateString(curr.toString());
        } else {
            minimumLeaf(root.left, curr);
            minimumLeaf(root.right, curr);
        }

        curr.deleteCharAt(0);
    }

    void updateString(String currStr) {
        if(smallestStr == null || currStr.compareTo(smallestStr) < 0)
            smallestStr = currStr;
    }

}