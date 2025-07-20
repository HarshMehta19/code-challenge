# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxPathSum(self, root: Optional[TreeNode]) -> int:
        self.maxPathsum = root.val

        def pathSum(root):
            if not root: return 0

            left = max(0, pathSum(root.left))
            right = max(0, pathSum(root.right))

            self.maxPathsum = max(self.maxPathsum, left + right + root.val)

            return root.val + max(left, right)

        pathSum(root)
        return self.maxPathsum
            