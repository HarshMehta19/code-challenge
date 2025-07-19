class Solution:
    def increasingTriplet(self, nums: List[int]) -> bool:
        if len(nums) < 3: return False

        a = inf
        b = inf
        for n in nums:
            if n <=a:
                a = n
            elif n <=b:
                b = n
            else:
                return True
        return False