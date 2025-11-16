class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        count = {}
        l = max_freq = res = 0

        for idx, value in enumerate(s):
            count[value] = count.get(value, 0) + 1
            max_freq = max(count[value], max_freq)

            if (idx - l + 1) - max_freq > k:
                count[s[l]]-=1
                l+=1

            res = max(res, (idx - l + 1))

        return res