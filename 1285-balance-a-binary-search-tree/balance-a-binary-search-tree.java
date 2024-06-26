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
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorderTraversal(root, list);
        return buildTree(list, 0, list.size() - 1);

    }

    void inorderTraversal(TreeNode root, List<Integer> list) {
        if(root != null) {
            inorderTraversal(root.left, list);
            list.add(root.val);
            inorderTraversal(root.right, list);
        }
    }

    public TreeNode buildTree(List<Integer> lst, int start, int end) {
        if(start > end) return null;
        int mid = start + (end - start) / 2;

        TreeNode root = new TreeNode(lst.get(mid));
        root.left = buildTree(lst, start, mid-1);
        root.right = buildTree(lst, mid+1, end);

        return root;
    }
}