class Solution {
    public int numberOfSets(int n, int k) {
        long MOD = 1_000_000_007;
        int N = n + k - 1;
        int R = 2 * k;

        long[] fact = new long[N + 1];
        long[] invFact = new long[N + 1];

        fact[0] = 1;

        for (int i = 1; i <= N; i++) {
            fact[i] = fact[i - 1] * i % MOD;
        }

        invFact[N] = power(fact[N], MOD - 2, MOD);

        for (int i = N - 1; i >= 0; i--) {
            invFact[i] = invFact[i + 1] * (i + 1) % MOD;
        }

        return (int) (fact[N] * invFact[R] % MOD * invFact[N - R] % MOD);
    }

    private long power(long a, long b, long mod) {
        long result = 1;

        while (b > 0) {
            if ((b & 1) == 1) {
                result = result * a % mod;
            }

            a = a * a % mod;
            b >>= 1;
        }

        return result;
    }
}