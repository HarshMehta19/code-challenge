class Solution:
    # def lis_dp_sequence(nums):
    def lengthOfLIS(self, nums: List[int]) -> int:
        lst = [nums[0]]
        max_len = 1

        for num in nums[1:]:
            if num > lst[-1]:
                lst.append(num)
                max_len +=1

            else:
                left, right = 0, len(lst) - 1
                while left < right:
                    mid = left + (right - left) // 2
                    if lst[mid] < num:
                        left = mid + 1
                    else:
                        right = mid
                lst[left] = num

        return max_len
        # n = len(nums)
        # if n == 0:
        #     return []

        # dp = [1] * n
        # next_idx = [-1] * n  # store where to go next in the subsequence

        # for i in range(n - 1, -1, -1):
        #     for j in range(i + 1, n):
        #         if nums[i] < nums[j] and dp[i] < 1 + dp[j]:
        #             dp[i] = 1 + dp[j]
        #             next_idx[i] = j

        # # Reconstruct: start from the index with max dp
        # start = max(range(n), key=lambda k: dp[k])
        # # print(start)
        # seq = [] # This will hold the largest increasing subsequence
        # while start != -1:
        #     seq.append(nums[start])
        #     start = next_idx[start]
        #     # print(start)

        # # print(seq)
        
        # return max(dp)

    # def lengthOfLIS(self, nums: List[int]) -> int:
    #     LIS = [1] * len(nums)

    #     for i in range(len(nums) - 1, -1, -1):
    #         for j in range(i+1, len(nums)):
    #             if nums[i] < nums[j]:
    #                 LIS[i] = max(LIS[i], 1 + LIS[j])

    #     return max(LIS)