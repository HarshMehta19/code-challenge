class Solution:
    def reverseWords(self, s: str) -> str:
        s = list(s)
        s.reverse()
        i, k, n = 0, 0, len(s)

        while i < n:
            while i < n and s[i] == " ": i+=1

            if i != n and k > 0:
                s[k] = " "
                k+= 1
            
            start_index = k
            while i < n and s[i] != " ":
                s[k] = s[i]
                i+=1
                k+=1

            self.reverse(s, start_index, k-1)

        s = s[:k]
        return "".join(s)

    def reverse(self, s, l, r):
        while l < r:
            s[l], s[r] = s[r], s[l]
            l+=1
            r-=1