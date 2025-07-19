class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        # check total number of zeroes and ones till the position
        # set difference of ones and zeroes in the map with their index
        # at any step, if ones and zeroes are same, set the result
        # If difference is already exists in map that means prefix is not required
        zero = one = 0
        res = 0

        diff_index = {} # count[1] - count[0] diff -> index

        for i,n in enumerate(nums):
            if n == 1:
                one+=1
            else:
                zero+=1

            if one - zero not in diff_index:
                diff_index[one - zero] = i

            if zero == one:
                res = zero * 2
            else:
                index = diff_index[one - zero]
                res = max(res, i - index)

        return res