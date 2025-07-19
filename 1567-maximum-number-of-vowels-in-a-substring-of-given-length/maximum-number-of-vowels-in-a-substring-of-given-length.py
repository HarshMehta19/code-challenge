class Solution:
    def maxVowels(self, s: str, k: int) -> int:
        res = 0
        left = 0
        count = 0
        vowels = ['a', 'e', 'i', 'o', 'u'] 
        for right in range(len(s)):
            if s[right] in vowels:
                count+=1
            if right - left == k - 1:
                res = max(count, res)
                if s[left] in vowels:
                    count-=1
                left+=1            

        return res