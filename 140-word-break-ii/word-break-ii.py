class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> List[str]:
        wordDict = set(wordDict)
        memo = {}
        def backtrack(i: int):
            if i == len(s):
                return [""]

            if i in memo:
                return memo[i]
            res = []
            for j in range(i,len(s)):
                w = s[i:j+1]

                if w not in wordDict:
                    continue
                
                strings = backtrack(j+1)
                if not strings:
                    continue
                
                for substr in strings:
                    sentence = w
                    if substr:
                        sentence += " " + substr
                    res.append(sentence)
            memo[i] = res
            return res

        # cur = []
        # res = []
        return backtrack(0)
        # return res
