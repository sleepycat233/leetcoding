import java.util.Arrays;
import java.util.stream.IntStream;

class RedundantConnection {
    int[] parent;

    public int[] findRedundantConnection(int[][] edges) {
        this.parent = IntStream
                        .iterate(-1, a -> a)
                        .limit(edges.length+1)
                        .toArray();

        int[] ans = new int[2];
        for(int[] edge : edges) {
            if(union(edge[0], edge[1]) == false) {
                ans = edge;
            }
        }

        return ans;
    }

    /* private int find(int v) {
        if(parent[v] < 0)
            return v;
        else
            return find(parent[v]);
    } */

    private int find(int v) {
        if(parent[v] < 0) {
            return v;
        }
        else {
            parent[v] = find(parent[v]);
            return parent[v];
        }
    }

/*     private boolean union(int a, int b) {
        int p1, p2;
        if((p1 = find(a)) != (p2 = find(b))) {
            parent[p2] = p1;
            return true;
        }

        return false;
    } */

    // union by rank
    private boolean union(int a, int b) {
        int p1 = find(a);
        int p2 = find(b);

        if(p1 != p2) {
            if(-parent[p1] < -parent[p2]) {
                int tmp = p1;
                p1 = p2;
                p2 = tmp;
            }
            parent[p1] += parent[p2];
            parent[p2] = p1;

            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        RedundantConnection sol = new RedundantConnection();
        int[][] edges = new int[][]{{1,2},{2,3},{3,4},{1,4},{1,5}};
        System.out.println(Arrays.toString(sol.findRedundantConnection(edges)));
    }
}