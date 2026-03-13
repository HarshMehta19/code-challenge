class Solution:
    def minWindow(self, s: str, t: str) -> str:
        #handle case where s and t are same
        if s == t: return s

        # 1. create a count of t
        count_of_t, window = {}, {}

        for c in t:
            count_of_t[c] = count_of_t.get(c, 0) + 1
        
        # 2. have =0, need = len(t)
        have, need = 0, len(count_of_t)
        # 3. resCorrd [x, y], resLen - to keep the track of min result length
        res, resLen = [-1, -1], float("inf")
        l = 0
        # 4. Iterate over s, check frequency of character on update have if the frequency of s[i] in window = s[i] in t
        for r in range(len(s)):
            c = s[r]
            window[c] = 1+ window.get(c, 0)
            # 5. once have == need, compare window and update result [left, right], resLen
            if c in count_of_t and count_of_t[c] == window[c]:
                have+=1
        # 6. Narrow down the sequence til have == need by increasing right left side pointer
            while have == need:
                if (r - l + 1) < resLen:
                    resLen = r- l + 1
                    res = [l, r]

                window[s[l]]-=1
                if s[l] in count_of_t and window[s[l]] < count_of_t[s[l]]:
                    have-=1
                l+=1
        return s[res[0]: res[1] + 1] if resLen != float("inf") else ""
