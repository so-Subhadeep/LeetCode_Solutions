
class Solution {
    public int minimizeSum(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;

        if (n <= 3) return 0;

        return Math.min(
            nums[n - 3] - nums[0],
            Math.min(
                nums[n - 2] - nums[1],
                nums[n - 1] - nums[2]
            )
        );
    }
}
