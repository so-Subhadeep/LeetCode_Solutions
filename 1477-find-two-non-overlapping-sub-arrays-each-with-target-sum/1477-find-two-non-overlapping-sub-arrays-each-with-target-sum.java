class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] best = new int[n];
        Arrays.fill(best, Integer.MAX_VALUE);

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int prefix = 0;
        int ans = Integer.MAX_VALUE;
        int minLen = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            prefix += arr[i];

            if (map.containsKey(prefix - target)) {
                int start = map.get(prefix - target);
                int len = i - start;

                if (start >= 0 && best[start] != Integer.MAX_VALUE) {
                    ans = Math.min(ans, len + best[start]);
                }

                minLen = Math.min(minLen, len);
            }

            best[i] = minLen;
            map.put(prefix, i);
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}