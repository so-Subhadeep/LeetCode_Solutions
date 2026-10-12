
import java.util.*;

class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int[] bits = new int[31];

        for (int num : nums) {
            for (int i = 0; i < 31; i++) {
                if (((num >> i) & 1) == 1) {
                    bits[i]++;
                }
            }
        }

        long ans = 0;
        long MOD = 1_000_000_007L;

        for (int j = 0; j < k; j++) {
            long num = 0;

            for (int i = 30; i >= 0; i--) {
                if (bits[i] > 0) {
                    num |= (1L << i);
                    bits[i]--;
                }
            }

            ans = (ans + num * num) % MOD;
        }

        return (int) ans;
    }
}
