class Solution:
    def reverse(self, x: int) -> int:
        res = 0
        if x < 0:
            res = int(str(x)[1:][::-1]) * -1
        else:
            res = int(str(x)[::-1])

        if res > 2 ** 31-1 or res < -2 ** 31:
            return 0

        return res
        # MIN = -2 ** 31
        # MAX = 2 ** 31 -1
        # res = 0
        # while x:
        #     digit = int(math.fmod(x, 10))
        #     x = int(x/10)

        #     if (res > MAX // 10 or (res == MAX // 10 and digit >= MAX % 10)):
        #         return 0
            
        #     if (res < MIN // 10 or (res == MIN // 10 and digit <= MIN % 10)):
        #         return 0

        #     res = (res * 10) + digit
        # return res