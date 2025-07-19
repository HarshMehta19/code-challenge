class Solution:
    def maxOperations(self, nums: List[int], k: int) -> int:
        hash_map = {}
        res = 0
        for num in nums:
            remain = k - num
            if hash_map.get(remain, 0) > 0:
                hash_map[remain] -= 1
                res+=1
            else:
                hash_map[num] = hash_map.get(num, 0) + 1

        return res