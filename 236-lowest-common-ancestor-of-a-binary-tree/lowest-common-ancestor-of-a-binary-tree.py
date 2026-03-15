# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        # ---------------------DFS------------------------
        if not root or root is p or root is q:
            return root

        left = self.lowestCommonAncestor(root.left, p, q)
        right = self.lowestCommonAncestor(root.right, p, q)

        if left and right:
            return root

        return left if left else right

        # ---------------------BFS------------------------
        # parent = {root: None}
        # queue = deque([root])

        # while p not in parent or q not in parent:
        #     node = queue.popleft()
        #     if node.left:
        #         parent[node.left] = node
        #         queue.append(node.left)

        #     if node.right:
        #         parent[node.right] = node
        #         queue.append(node.right)

        # ancestors = set()

        # while p:
        #     ancestors.add(p)
        #     p = parent[p]

        # while q not in ancestors:
        #     q = parent[q]

        # return q