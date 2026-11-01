
class Solution {
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        int sum = 0;

        for (int num : nums) {
            min = Math.min(min, num);
            sum += num;
        }

        return sum - nums.length * min;
    }
}
