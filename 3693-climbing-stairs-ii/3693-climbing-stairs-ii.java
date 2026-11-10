
class Solution {
    public int climbStairs(int n, int[] costs) {
        int a = 0, b = 0, c = 0;

        for (int i = 1; i <= n; i++) {
            int curr = costs[i - 1] + Math.min(
                a + 9,
                Math.min(b + 4, c + 1)
            );

            a = b;
            b = c;
            c = curr;
        }

        return c;
    }
}

