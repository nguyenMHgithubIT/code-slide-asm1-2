import java.util.*;
public class PrimJarnikAlgorithm {
    public static void prim(int[][] graph) {
    int n = graph.length;
    int[] key = new int[n];
    int[] parent = new int[n];
    boolean[] mstSet = new boolean[n];
    Arrays.fill(key, Integer.MAX_VALUE);
    key[0] = 0;
    parent[0] = -1;

    for (int i = 0; i < n - 1; i++) {
        int u = selectMinVertex(key, mstSet);
        mstSet[u] = true;

        for (int v = 0; v < n; v++) {
            if (graph[u][v] != 0 && !mstSet[v] && graph[u][v] < key[v]) {
                parent[v] = u;
                key[v] = graph[u][v];
            }
        }
    }

    printMST(parent, graph);
}

    private static int selectMinVertex(int[] key, boolean[] mstSet) {
        int min = Integer.MAX_VALUE, minIndex = -1;
        for (int i = 0; i < key.length; i++) {
            if (!mstSet[i] && key[i] < min) {
                min = key[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    private static void printMST(int[] parent, int[][] graph) {
        System.out.println("Edge\tWeight");
        for (int i = 1; i < graph.length; i++) {
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 4, 2, 0, 0},
                {4, 0, 5, 10, 0},
                {2, 5, 0, 3, 0},
                {0, 10, 3, 0, 1},
                {0, 0, 0, 1, 0}
        };
        prim(graph);
    }
}
