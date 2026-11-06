
class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));

        int m = queries.length;
        int[][] q = new int[m][2];

        for (int i = 0; i < m; i++) {
            q[i][0] = queries[i];
            q[i][1] = i;
        }

        Arrays.sort(q, (a, b) -> Integer.compare(a[0], b[0]));

        int[] ans = new int[m];
        Map<Integer, Integer> map = new HashMap<>();

        int left = 0, right = 0;

        for (int[] query : q) {
            int t = query[0];
            int idx = query[1];

            while (right < logs.length && logs[right][1] <= t) {
                map.put(logs[right][0],
                    map.getOrDefault(logs[right][0], 0) + 1);
                right++;
            }

            while (left < right && logs[left][1] < t - x) {
                int server = logs[left][0];

                map.put(server, map.get(server) - 1);

                if (map.get(server) == 0) {
                    map.remove(server);
                }

                left++;
            }

            ans[idx] = n - map.size();
        }

        return ans;
    }
}
