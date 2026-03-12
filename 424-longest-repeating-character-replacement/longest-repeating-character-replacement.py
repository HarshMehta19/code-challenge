class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        map = {}
        left, max_freq, res = 0, 0, 0
        for idx, value in enumerate(s):
            map[value] = map.get(value, 0) + 1
            max_freq = max(max_freq, map[value])

            if (idx - left + 1) - max_freq > k:
                map[s[left]]-=1
                left+=1

            res = max(res, idx - left + 1)

        return res
