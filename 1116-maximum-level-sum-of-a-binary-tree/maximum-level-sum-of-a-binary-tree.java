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
    int sumResult = Integer.MIN_VALUE;
    int level = 0;
    int[] arr;
    public int maxLevelSum(TreeNode root) {
        arr = new int[10001];
        Arrays.fill(arr, Integer.MIN_VALUE);
        bfs(root, 1);

        for(int i = 1;i<10001;i++) {
            if(sumResult < arr[i]) {
                sumResult = arr[i];
                // System.out.println("sumResult: "+ sumResult + ", i is: "+ i);
                level = i;
            }
        }

        return level;

    }

    private void bfs(TreeNode root, int level) {
        if(root == null) return;
        if(arr[level] == Integer.MIN_VALUE)
            arr[level] = 0;
        arr[level] += root.val;

        bfs(root.left, level+1);
        bfs(root.right, level+1);
    }
}