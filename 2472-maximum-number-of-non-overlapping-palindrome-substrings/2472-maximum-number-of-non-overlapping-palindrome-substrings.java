class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        boolean[][] palindrome = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) &&
                    (j - i <= 2 || palindrome[i + 1][j - 1])) {
                    palindrome[i][j] = true;
                }
            }
        }

        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1];

            for (int start = 0; start <= i - k; start++) {
                if (palindrome[start][i - 1]) {
                    dp[i] = Math.max(dp[i], dp[start] + 1);
                }
            }
        }

        return dp[n];
    }
}