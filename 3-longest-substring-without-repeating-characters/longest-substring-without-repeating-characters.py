class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        # ------- Memory Optimized -------#
        memory = {}
        res = 0
        l = 0
        for r in range(len(s)):
            if s[r] in memory:
                l = max(memory[s[r]] + 1, l)
            memory[s[r]] = r
            res = max(res, r - l + 1)
        return res

        # character set to check character is included
        # visitedCharacters = set()
        # res,l = 0, 0
        # for right in range(len(s)):
        #     while visitedCharacters and s[right] in visitedCharacters:
        #         visitedCharacters.remove(s[l])
        #         l+=1
            
        #     visitedCharacters.add(s[right])
        #     res = max(res, right - l + 1)

        # return res
            
        