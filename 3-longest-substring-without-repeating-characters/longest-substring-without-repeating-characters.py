class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        # character set to check character is included
        seen = set()
        longest, left = 0, 0

        for right in range(len(s)):
            while seen and s[right] in seen:
                seen.remove(s[left])
                left+=1

            seen.add(s[right])
            longest = max(longest, right - left + 1)

        return longest