class FrequencyMinHeap:
    def __init__(self, score, name):
        self.name = name
        self.score = score

    def __lt__(self, other):
        if other.score != self.score:
            return self.score < other.score
        return self.name > other.name

    def __repr__(self):
        return f'({self.score}, {self.name})'

class SORTracker:

    def __init__(self):
        self.minHeap = []
        self.maxHeap = []
        

    def add(self, name: str, score: int) -> None:
        heapq.heappush(self.minHeap, FrequencyMinHeap(score, name))
        minValue = heapq.heappop(self.minHeap)
        heapq.heappush(self.maxHeap, (-minValue.score, minValue.name))

        # print("add", self.minHeap, "maxHeap", self.maxHeap)

    def get(self) -> str:
        if self.maxHeap:
            maxValue = heapq.heappop(self.maxHeap)
            heapq.heappush(self.minHeap, FrequencyMinHeap(-maxValue[0], maxValue[1]))
        # print(self.minHeap, self.maxHeap)
        
        return self.minHeap[0].name
        


# Your SORTracker object will be instantiated and called as such:
# obj = SORTracker()
# obj.add(name,score)
# param_2 = obj.get()