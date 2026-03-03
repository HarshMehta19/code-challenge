class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> List[str]:
        wordDict = set(wordDict)
        memo = {}
        def backtrack(i : int):
            if i == len(s):
                return [""]

            if i in memo:
                return memo[i]
            res = []
            for j in range(i, len(s)):
                w = s[i:j+1]

                if w not in wordDict:
                    continue

                words = backtrack(j+1)

                if not words:
                    continue

                for word in words:
                    sen = w
                    if word:
                        sen += " " + word
                    res.append(sen)
                    
            memo[i] = res
            return res
        
        return backtrack(0)
                    