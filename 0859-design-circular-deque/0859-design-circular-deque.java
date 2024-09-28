class Node {
    public int value;
    public Node prev, next;
    public Node(int val) {
        this.value = val;
        this.prev = null;
        this.next = null;
    }
}
class MyCircularDeque {
    Node head = new Node(-1);
    Node tail = new Node(-1);
    int size;
    int currentSize;

    public MyCircularDeque(int k) {
        this.head.next = tail;
        this.tail.prev = head;
        this.size = k;
        this.currentSize = 0;
    }
    
    public boolean insertFront(int value) {
        if(currentSize == size)
            return false;
        addNode(head, value);

        currentSize++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if(currentSize == size)
            return false;
        addNode(tail.prev, value);
        currentSize++;
        return true;
    }
    
    public boolean deleteFront() {
        if(currentSize == 0)
            return false;
        deleteNode(head.next);
        currentSize--;
        return true;
    }
    
    public boolean deleteLast() {
        if(currentSize == 0)
            return false;
        deleteNode(tail.prev);
        currentSize--;
        return true;
    }
    
    public int getFront() {
        if(currentSize == 0)
            return -1;
        return head.next.value;
    }
    
    public int getRear() {
        if(currentSize == 0)
            return -1;
        return tail.prev.value;
    }
    
    public boolean isEmpty() {
        return currentSize == 0;
    }
    
    public boolean isFull() {
        return currentSize == size;
    }

    private void addNode(Node head, int value){
        Node after = head.next;
        Node temp = new Node(value);
        head.next = temp;
        temp.prev = head;
        temp.next = after;
        after.prev = temp;
    }

    private void deleteNode(Node node) {
        Node after = node.next;
        Node before = node.prev;
        before.next = after;
        after.prev = before;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */