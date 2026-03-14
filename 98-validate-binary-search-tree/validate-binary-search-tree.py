# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        def isValid(node, minimum, maximum):
            if not node:
                return True
            if not (node.val > minimum and node.val < maximum):
                return False
            return isValid(node.left, minimum, node.val) and isValid(node.right, node.val, maximum)
        
        return isValid(root, float('-inf'), float('inf'))