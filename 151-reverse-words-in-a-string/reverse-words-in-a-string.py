class Solution:
    def reverseWords(self, s: str) -> str:
        result = s.split()[::-1]
        return ' '.join(result)