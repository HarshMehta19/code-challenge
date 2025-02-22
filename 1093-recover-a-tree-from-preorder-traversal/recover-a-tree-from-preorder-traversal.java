/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    private int index;
    private char[] chars;

    public TreeNode recoverFromPreorder(String traversal) {
        if (traversal == null || traversal.length() == 0)
            return null;

        index = 0;
        chars = traversal.toCharArray();

        TreeNode root = new TreeNode(getNodeVal());
        helper(0, root);
        return root;
    }

    private int getNodeVal(){
        if(index >= chars.length) return -1;

        int count = 0, i;
        for(i = index;i<chars.length && chars[i] != '-';i++) {
            count = count * 10 + (chars[i] - '0');

        }

        index = i;
        return count;
    }

    private void helper(int level, TreeNode parent) {
        int numDashes = getDashes();

        while(numDashes == level + 1) {
            index += numDashes;
            TreeNode newNode = new TreeNode(getNodeVal());


            if(parent.left == null)
                parent.left = newNode;
            else
                parent.right = newNode;


            helper(level+1, newNode);

            numDashes = getDashes();
        }
    }

    private int getDashes() {
        if(index>= chars.length) {
            return -1;
        }

        int count = 0;
        for(int i=index;i<chars.length && chars[i] =='-';i++) {
            count++;
        }

        return count;
    }
}