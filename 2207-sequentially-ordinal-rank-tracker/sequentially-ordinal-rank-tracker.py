class SORTracker:

    def __init__(self):
        self.queryCount = 0
        self.storage = SortedList()
        

    def add(self, name: str, score: int) -> None:
        self.storage.add((-score, name))

    def get(self) -> str:
        ans = self.storage[self.queryCount]
        self.queryCount+=1
        # print(self.storage)
        return ans[1]
        


# Your SORTracker object will be instantiated and called as such:
# obj = SORTracker()
# obj.add(name,score)
# param_2 = obj.get()