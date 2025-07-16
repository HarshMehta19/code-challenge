class Solution:
    def carPooling(self, trips: List[List[int]], capacity: int) -> bool:

        pass_change = [0] * 1001

        for t in trips:
            numPass, start, end = t
            pass_change[start]+=numPass
            pass_change[end]-=numPass

        curPass = 0
        for i in range(1001):
            curPass += pass_change[i]
            if curPass > capacity:
                return False

        return True
        # trips.sort(key = lambda t: t[1])
        # min_heap = [] # pair of end, numPass
        # cur_pass = 0

        # for t in trips:
        #     num_pass, start, end = t
        #     while min_heap and min_heap[0][0] <= start:
        #         cur_pass -= min_heap[0][1]
        #         heapq.heappop(min_heap)

        #     cur_pass+=num_pass
        #     if cur_pass > capacity:
        #         return False
        #     heapq.heappush(min_heap, [end, num_pass])
        
        # return True
