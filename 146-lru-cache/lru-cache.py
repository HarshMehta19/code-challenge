class LRUCache:

    class Node:
        def __init__(self, key: int, val: int):
            self.key, self.val = key, val
            self.prev = self.next = None

    def __init__(self, capacity: int):
        self.capacity = capacity
        self.head = self.Node(0, 0)
        self.tail = self.Node(0, 0)
        self.cache = {} # empty cache
        self.head.next = self.tail
        self.tail.prev = self.head

    def _addNode(self, newNode):
        temp = self.head.next
        newNode.next = temp
        newNode.prev = self.head
        temp.prev = newNode
        self.head.next = newNode

    def _deleteNode(self, delNode):
        delNode.next.prev = delNode.prev
        delNode.prev.next = delNode.next


    def get(self, key: int) -> int:
        if key not in self.cache:
            return -1
        node = self.cache[key]
        self._deleteNode(node)
        self._addNode(node)
        return node.val

    def put(self, key: int, value: int) -> None:
        if key in self.cache:
            cur = self.cache[key]
            del self.cache[key]
            self._deleteNode(cur)

        if len(self.cache) == self.capacity:
            del self.cache[self.tail.prev.key]
            self._deleteNode(self.tail.prev)

        self._addNode(self.Node(key, value))
        self.cache[key] = self.head.next
        


# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)