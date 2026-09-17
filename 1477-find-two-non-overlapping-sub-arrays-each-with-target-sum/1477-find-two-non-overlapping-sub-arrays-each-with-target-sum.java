class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n + 1);

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);

        int sum = 0;
        int ans = n + 1;

        for (int i = 1; i <= n; i++) {
            sum += arr[i - 1];
            dp[i] = dp[i - 1];

            if (map.containsKey(sum - target)) {
                int start = map.get(sum - target);
                int len = i - start;

                if (dp[start] != n + 1) {
                    ans = Math.min(ans, len + dp[start]);
                }

                dp[i] = Math.min(dp[i], len);
            }

            map.put(sum, i);
        }

        return ans == n + 1 ? -1 : ans;
    }
}