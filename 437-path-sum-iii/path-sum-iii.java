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
    // int counter = 0;
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return 0;

        // return pathSum(root.left, targetSum) + pathSumHelper(root, 0, targetSum) + 
        //     pathSum(root.right, targetSum);

        return pathSumHelper(root, targetSum, 0 ) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);

        // return getSum(root, targetSum, 0) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);



    }

    
    

    private int pathSumHelper(TreeNode root, int targetSum, long sum) {
        int res = 0;
        if(root == null) return res;

        sum += root.val;
        if(sum == targetSum) res++;
        
        res += pathSumHelper(root.left, targetSum, sum);
        res += pathSumHelper(root.right, targetSum, sum);
        // System.out.println("res: "+ res);
        return res;

        

        
        // pathSumHelper(root.left, targetSum, currentSum);
        // pathSumHelper(root.right, targetSum, currentSum);
    }

    
}
