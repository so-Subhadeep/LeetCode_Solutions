import java.util.*;

class Solution {
    private static final long INF = 1000000000000000L;

    private static class WindowTracker {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        long sum = 0;
        int size = 0;

        void add(int val) {
            map.merge(val, 1, Integer::sum);
            sum += val;
            size++;
        }

        void remove(int val) {
            map.merge(val, -1, Integer::sum);
            if (map.get(val) == 0) {
                map.remove(val);
            }
            sum -= val;
            size--;
        }
    }

    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;
        List<Long> minOps = getWindowCosts(nums, x);
        
        Long[][] memo = new Long[n + 1][k + 1];
        
        return dp(0, k, nums, x, minOps, memo);
    }

    private long dp(int i, int rem_k, int[] nums, int x, List<Long> minOps, Long[][] memo) {
        if (rem_k == 0) return 0;
        if (i > nums.length || nums.length - i < (long) rem_k * x) return INF;
        if (memo[i][rem_k] != null) return memo[i][rem_k];
        
        long skip = dp(i + 1, rem_k, nums, x, minOps, memo);
        
        long pick = INF;
        if (i + x <= nums.length) {
            pick = minOps.get(i) + dp(i + x, rem_k - 1, nums, x, minOps, memo);
        }
        
        return memo[i][rem_k] = Math.min(skip, pick);
    }

    private List<Long> getWindowCosts(int[] nums, int x) {
        List<Long> minOps = new ArrayList<>();
        WindowTracker lower = new WindowTracker();
        WindowTracker upper = new WindowTracker();
        
        for (int i = 0; i < nums.length; ++i) {
            if (lower.map.isEmpty() || nums[i] <= lower.map.lastKey()) {
                lower.add(nums[i]);
            } else {
                upper.add(nums[i]);
            }
            
            if (i >= x) {
                int outNum = nums[i - x];
                if (lower.map.containsKey(outNum)) {
                    lower.remove(outNum);
                } else {
                    upper.remove(outNum);
                }
            }
            
            if (lower.size < upper.size) {
                int val = upper.map.firstKey();
                upper.remove(val);
                lower.add(val);
            } else if (lower.size - upper.size > 1) {
                int val = lower.map.lastKey();
                lower.remove(val);
                upper.add(val);
            }
            
            if (i >= x - 1) {
                int median = lower.map.lastKey();
                long ops = ((long) median * lower.size - lower.sum) + (upper.sum - (long) median * upper.size);
                minOps.add(ops);
            }
        }
        return minOps;
    }
}