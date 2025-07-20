class Solution:
    def decodeString(self, s: str) -> str:
        res = ""; stack = []; num = 0
        for c in s:
            if c == '[':
                stack.append(res)
                stack.append(num)
                res = ""
                num = 0
            elif c == ']':
                prev_num = stack.pop()
                prevStr = stack.pop()
                res = prevStr + prev_num * res
            elif c.isdigit():
                num = num * 10 + int(c)
            else:
                res += c
        return res
