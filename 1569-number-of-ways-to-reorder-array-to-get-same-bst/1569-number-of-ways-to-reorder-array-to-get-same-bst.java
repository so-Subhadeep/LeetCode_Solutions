
class Solution {
    static final int MOD = 1_000_000_007;
    long[][] comb;

    public int numOfWays(int[] nums) {
        int n = nums.length;
        comb = new long[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            comb[i][0] = comb[i][i] = 1;
            for (int j = 1; j < i; j++) {
                comb[i][j] = (comb[i - 1][j - 1]
                        + comb[i - 1][j]) % MOD;
            }
        }

        return (int) ((solve(nums) - 1 + MOD) % MOD);
    }

    private long solve(int[] nums) {
        int n = nums.length;
        if (n <= 2) return 1;

        int root = nums[0];
        int leftCount = 0;

        for (int i = 1; i < n; i++) {
            if (nums[i] < root) leftCount++;
        }

        int rightCount = n - 1 - leftCount;
        int[] left = new int[leftCount];
        int[] right = new int[rightCount];

        int l = 0, r = 0;

        for (int i = 1; i < n; i++) {
            if (nums[i] < root) {
                left[l++] = nums[i];
            } else {
                right[r++] = nums[i];
            }
        }

        long leftWays = solve(left);
        long rightWays = solve(right);

        long ways = comb[n - 1][leftCount];
        ways = ways * leftWays % MOD;
        ways = ways * rightWays % MOD;

        return ways;
    }
}
