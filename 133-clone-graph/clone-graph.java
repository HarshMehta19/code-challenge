/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    private Node clone(Map<Integer, Node> map, Node node) {
        if(node == null) return null;
        if(map.containsKey(node.val)) return map.get(node.val);

        Node newNode = new Node(node.val);
        map.put(node.val, newNode);
        for(var n: node.neighbors) {
            newNode.neighbors.add(clone(map, n));
        }
        return newNode;
    }
    public Node cloneGraph(Node node) {
        // ----------------- Recursive --------------
        Map<Integer, Node> map = new HashMap<>();
        return clone(map, node);
        // ------------------Iterative------------
    //     if(node == null) return null;

    //     Node newNode = new Node(node.val);
    //     Queue<Node> q = new LinkedList<>();
    //     HashMap<Node, Node> memory = new HashMap<>();
    //     memory.put(node, newNode);
    //     q.add(node);
    //     while(!q.isEmpty()) {
    //         var tempNode = q.poll();
    //         if(tempNode!= null) {
    //             for(var child : tempNode.neighbors) {
    //                 if(!memory.containsKey(child)){
    //                     var childNode = new Node(child.val);
    //                     memory.put(child, childNode);
    //                     q.add(child);
    //                 }
    //                 memory.get(tempNode).neighbors.add(memory.get(child));
    //             }
    //         }
    //     }
    //     return newNode;
    }
}