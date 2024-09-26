class Node {
    int start, end;
    Node left, right;

    public Node(int start, int end) {
        this.start = start;
        this.end = end;

    }
}

class MyCalendar {
    Node root;

    public MyCalendar() {
        this.root = null;
    }

    public boolean book(int start, int end) {
        if(root == null){
            root = new Node(start, end);
            return true;
        } else {
            return add(root, start, end);
        }
    }

    public boolean add(Node parent, int start, int end) {
        if(parent.start >= end){
            if(parent.left == null) {
                parent.left = new Node(start, end);
                return true;
            } else
                return add(parent.left, start, end);
        }
        else if(parent.end<=start) {
            if(parent.right == null){
                parent.right = new Node(start,end);
                return true;
            }else
                return add(parent.right, start, end);
            
        }
        return false;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */