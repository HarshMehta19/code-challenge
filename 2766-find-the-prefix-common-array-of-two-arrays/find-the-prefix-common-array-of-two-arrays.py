class Solution:
    def findThePrefixCommonArray(self, A: List[int], B: List[int]) -> List[int]:
        map = {}

        ans = [0] * len(A)
        cnt=0
        for i in range(len(A)):
            map[A[i]] = map.get(A[i], 0) + 1

            if map[A[i]] == 2:
                cnt+=1
            
            map[B[i]] = map.get(B[i], 0) + 1
            if map[B[i]] == 2:
                cnt+=1

            ans[i] = cnt

        return ans