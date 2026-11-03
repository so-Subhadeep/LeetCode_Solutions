
class Solution {
    public int minMoves(int[] nums) {
        int max = 0;
        int sum = 0;

        for (int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }

        return max * nums.length - sum;
    }
}
