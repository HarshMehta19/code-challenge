class Solution:
    def minOperations(self, s: str) -> int:
        count, count1 = 0, 0

        for i, c in enumerate(s):
            if i % 2 == 0:
                if c == "1":
                    count+=1
                if c == "0":
                    count1+=1
            else:
                if c == "0":
                    count+=1
                if c == "1":
                    count1+=1
        return min(count, count1)
        # if not s or len(s) == 0:
        #     return 0

        # a, b = 0, 0

        # for i,c in enumerate(s):
        #     if last == s[idx]:
        #         res+=1
        #         last = "1" if s[idx] == "0" else "0"
        #     else:
        #         last = s[idx]
            

        # return res


