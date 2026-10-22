class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int zero = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                zero = i;
                break;
            }
        }
        
        int ans = Integer.MAX_VALUE;
        
        // Check clockwise increasing order
        if (check(nums, n, zero, 1)) {
            ans = Math.min(ans, zero);
            ans = Math.min(ans, n - zero + 2);
        }
        
        // Check counter-clockwise increasing order
        if (check(nums, n, zero, -1)) {
            ans = Math.min(ans, zero + 2);
            ans = Math.min(ans, n - zero);
        }
        
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    
    private boolean check(int[] nums, int n, int zero, int step) {
        for (int i = 1; i < n; i++) {
            int prev = (zero + (i - 1) * step) % n;
            int curr = (zero + i * step) % n;
            // Handle negative modulo correctly in Java
            prev = (prev < 0) ? prev + n : prev;
            curr = (curr < 0) ? curr + n : curr;
            
            if (nums[prev] > nums[curr]) {
                return false;
            }
        }
        return true;
    }
}