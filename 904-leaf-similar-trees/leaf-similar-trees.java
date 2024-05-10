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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        helper(root1, left);
        helper(root2, right);

        if(left.size() != right.size()) return false;

        // for(int i=0;i<left.size();i++) {
            
        //     if(left.get(i) != right.get(i)) 
        //     {
        //         System.out.println("left: "+ left.get(i));
        //         System.out.println("right: "+ right.get(i));
        //         return false;
        //     }
        // }
        if(left.equals(right)) return true;
        return false;
    }

    void helper(TreeNode root, List<Integer> list) {
        if(root == null) return;

        if(root.left == null && root.right == null) {

            list.add(root.val);
            // return;
        }

        helper(root.left, list);
        helper(root.right, list);
    }
}