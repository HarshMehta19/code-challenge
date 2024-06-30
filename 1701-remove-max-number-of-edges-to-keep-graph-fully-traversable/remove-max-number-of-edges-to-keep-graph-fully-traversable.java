class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        UnionFind alice = new UnionFind(n);
        UnionFind bob = new UnionFind(n);

        int requiredEdges = 0;
        for(int[] edge : edges) {
            if(edge[0] == 3)
                requiredEdges+= (alice.union(edge[1], edge[2]) | bob.union(edge[1], edge[2]));
        }

        for(int[] edge: edges) {
            if(edge[0] == 2)
                requiredEdges += bob.union(edge[1], edge[2]);
            else if(edge[0] == 1)
                requiredEdges += alice.union(edge[1], edge[2]);

        }

        if(alice.isConnected() && bob.isConnected())
            return edges.length - requiredEdges;
        
        return -1;
    }
}

class UnionFind{
    int edges;
    int[] rep;
    // int[] comp;

    UnionFind(int n) {
        edges = n;
        rep = new int[n+1];
        // comp = new int[n+1];

        for(int i=0;i<=n;i++) {
            rep[i] = i;
            // comp[i] = i;
        }
    }

    int find(int x) {
        if(rep[x] == x)
            return x;

        return rep[x] = find(rep[x]);
    }

    int union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x==y) return 0;

        if(x>y){
            // comp[x] += comp[y];
            rep[y] = x;
        } else {
            // comp[y] += comp[x];
            rep[x] = y;
        }
        edges --;
        return 1;
    }

    boolean isConnected(){
        return edges == 1;
    }
}