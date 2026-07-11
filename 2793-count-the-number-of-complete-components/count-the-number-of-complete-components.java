class Solution {

    ArrayList<Integer>[] graph;
    boolean[] visited;
    int vertices;
    int edgeCount;

    public int countCompleteComponents(int n, int[][] edges) {

        graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // Build adjacency list
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph[u].add(v);
            graph[v].add(u);
        }

        visited = new boolean[n];

        int count = 0;

        // Find every connected component
        for (int i = 0; i < n; i++) {

            if (!visited[i]) {

                vertices = 0;
                edgeCount = 0;

                dfs(i);

                // Every edge is counted twice
                edgeCount /= 2;

                if (edgeCount == vertices * (vertices - 1) / 2) {
                    count++;
                }
            }
        }

        return count;
    }

    void dfs(int node) {

        visited[node] = true;

        vertices++;

        // Degree of current node
        edgeCount += graph[node].size();

        for (int next : graph[node]) {

            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}