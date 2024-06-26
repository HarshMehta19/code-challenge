class Solution {
    private int[] res;
    private int[] count;
    private List<HashSet<Integer>> tree;
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        tree = new ArrayList<>();
        res = new int[n];
        count = new int[n];

        for(int i = 0;i<n;i++) {
            tree.add(new HashSet<>());
        }

        for(int[] e : edges) {
            tree.get(e[0]).add(e[1]);
            tree.get(e[1]).add(e[0]);
        }
        postOrder(0, -1);
        preOrder(0, -1);
        return res;
    }

    private void postOrder(int root, int parent) {
        for(int i : tree.get(root)) {
            if(i == parent) continue;
            postOrder(i, root);
            count[root] += count[i];
            res[root] += res[i] + count[i];

        }
        count[root]++;
    }

    private void preOrder(int root, int parent) {
        for(int i : tree.get(root)) {
            if(parent == i) continue;
            res[i] = res[root] - count[i] + count.length - count[i];
            
            preOrder(i, root);
        }
    }
}