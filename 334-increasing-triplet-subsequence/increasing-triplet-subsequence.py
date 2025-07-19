class Solution:
    # take 2 variables with highest value possible
    # interate over input array and update top 2 min variable
    # if the cuurent variable is higher than the 2 min variable, that's our answer
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