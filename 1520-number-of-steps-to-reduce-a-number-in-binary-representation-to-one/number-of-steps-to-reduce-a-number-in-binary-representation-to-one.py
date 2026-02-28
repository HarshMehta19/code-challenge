class Solution:
    def numSteps(self, s: str) -> int:
        # # print(int(s, 2))
        # Approach 
        s = int(s, 2)
        count = 0

        while s > 1:
            if s % 2 != 0:
                count +=1
                s+=1
            s = s//2
            count+=1
        return count

        # Approach 1
        # res = 0
        # car = 0
        # for i in reversed(range(1, len(s))):
        #     digit = (int(s[i]) + car) % 2

        #     if digit == 0:
        #         res +=1
        #     else:
        #         car = 1
        #         res+=2

        # return res + car
        
        # TLD
        # def addOne(s):
        #     i = len(s) - 1
        #     s = list(s)
        #     while i >= 0 and s[i] == "1":
        #         s[i] == "0"
        #         i-=1
            
        #     if i == -1:
        #         s = ["1"] + s
        #     else:
        #         s[i] == "1"
        #     return "".join(s)

        # res = 0
        # while s != "1":
        #     if s[-1] == "0":
        #         s = s[:-1]
        #     else:
        #         s = addOne(s)
        #     res +=1
        # return res