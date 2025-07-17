class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        map = {}

        for i in range(len(nums)):
            num = nums[i]
            if target - num in map:
                return [map[target - num], i]

            map[num] = i

        return None