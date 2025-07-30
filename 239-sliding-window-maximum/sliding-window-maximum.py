class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        res = []
        q = collections.deque() # index
        l = r = 0
        while r<len(nums):
            
            while q and nums[q[-1]] < nums[r]:
                q.pop()

            if q and l > q[0]:
                q.popleft()
                
            q.append(r)
            if r+1 >= k:
                res.append(nums[q[0]])
                l+=1
            r+=1

        return res