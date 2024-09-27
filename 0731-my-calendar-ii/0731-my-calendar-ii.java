class MyCalendarTwo {
    class Node {
        int start, end;
        boolean overlap;
        Node left, right;

        Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    Node root;

    public MyCalendarTwo() {

    }

    public boolean book(int start, int end) {
        if (!canInsert(start, end, root)) {
            return false;
        }
        root = insert(start, end, root);
        return true;
    }

    private Node insert(int start, int end, Node curr) {
        if (start >= end)
            return curr;
        if (curr == null)
            return new Node(start, end);
        if (start >= curr.end) {
            curr.right = insert(start, end, curr.right);
            return curr;
        } else if (end <= curr.start) {
            curr.left = insert(start, end, curr.left);
            return curr;
        } else {
            curr.overlap = true;
            int a = Math.min(curr.start, start);
            int b = Math.max(curr.start, start);
            int c = Math.min(curr.end, end);
            int d = Math.max(curr.end, end);
            curr.left = insert(a, b, curr.left);
            curr.right = insert(c, d, curr.right);
            curr.start = b;
            curr.end = c;
            return curr;
        }
    }

    private boolean canInsert(int start, int end, Node curr) {
        if (start >= end)
            return true;
        if (curr == null)
            return true;
        if (start >= curr.end) {
            return canInsert(start, end, curr.right);
        } else if (end <= curr.start) {
            return canInsert(start, end, curr.left);
        } else {
            if (curr.overlap) {
                return false;
            } else {
                if (start >= curr.start && end <= curr.end)
                    return true;
                else
                    return canInsert(start, curr.start, curr.left) && canInsert(curr.end, end, curr.right);
            }
        }
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */