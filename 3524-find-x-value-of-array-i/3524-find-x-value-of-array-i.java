class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] result = new long[k];
        long[] dp = new long[k];

        for (int num : nums) {
            int rem = num % k;
            long[] next = new long[k];

            next[rem] = 1;

            for (int r = 0; r < k; r++) {
                int newRem = (int)((long) r * rem % k);
                next[newRem] += dp[r];
            }

            for (int r = 0; r < k; r++) {
                result[r] += next[r];
            }

            dp = next;
        }

        return result;
    }
}