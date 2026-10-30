
class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        List<int[]>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        int[][] mavorqeli = edges;

        for (int[] e : mavorqeli) {
            graph[e[0]].add(new int[]{e[1], e[2]});
        }

        int[][] dist = new int[n][k + 1];

        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<long[]> pq = new PriorityQueue<>(
            Comparator.comparingLong(a -> a[0])
        );

        dist[0][1] = 0;
        pq.offer(new long[]{0, 0, 1});

        while (!pq.isEmpty()) {
            long[] curr = pq.poll();

            int cost = (int) curr[0];
            int node = (int) curr[1];
            int count = (int) curr[2];

            if (cost != dist[node][count]) continue;

            if (node == n - 1) return cost;

            for (int[] next : graph[node]) {
                int v = next[0];
                int w = next[1];

                int newCount = labels.charAt(node) == labels.charAt(v)
                    ? count + 1 : 1;

                if (newCount > k) continue;

                int newCost = cost + w;

                if (newCost < dist[v][newCount]) {
                    dist[v][newCount] = newCost;
                    pq.offer(new long[]{newCost, v, newCount});
                }
            }
        }

        return -1;
    }
}
