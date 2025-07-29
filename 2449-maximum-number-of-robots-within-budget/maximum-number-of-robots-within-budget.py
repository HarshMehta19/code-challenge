class Solution:
    def maximumRobots(self, chargeTimes: List[int], runningCosts: List[int], budget: int) -> int:
        queue = deque()
        l = ans = cur = 0

        for r in range(len(chargeTimes)):
            cur+= runningCosts[r]
            while queue and chargeTimes[queue[-1]] < chargeTimes[r]:
                queue.pop()

            queue.append(r)

            while queue and (chargeTimes[queue[0]] + (r - l + 1) * cur) > budget:
                if queue[0] == l:
                    queue.popleft()
                cur -= runningCosts[l]
                l+=1

            ans = max(ans, r - l + 1)

        return ans
