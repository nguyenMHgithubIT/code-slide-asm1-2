import java.util.*;
public class DijkstraAlgorithm {
    public static void dijkstra(int[][] graph, int src) {
        int n = graph.length;
        int[] dist = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for (int i = 0; i < n - 1; i++) {
            int u = selectMinVertex(dist, visited);
            visited[u] = true;

            for (int v = 0; v < n; v++) {
                if (!visited[v] && graph[u][v] != 0 &&
                        dist[u] != Integer.MAX_VALUE &&
                        dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        System.out.println("Shortest distances: " + Arrays.toString(dist));
    }

    private static int selectMinVertex(int[] dist, boolean[] visited) {
        int min = Integer.MAX_VALUE, minIndex = -1;
        for (int i = 0; i < dist.length; i++) {
            if (!visited[i] && dist[i] < min) {
                min = dist[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 4, 2, 0, 0},
                {4, 0, 5, 10, 0},
                {2, 5, 0, 3, 0},
                {0, 10, 3, 0, 1},
                {0, 0, 0, 1, 0}
        };
        dijkstra(graph, 0);
    }
}
