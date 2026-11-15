
class Solution {
    public int numOfSubarrays(int[] arr) {
        long odd = 0, even = 1;
        long sum = 0;
        long mod = 1_000_000_007;

        for (int num : arr) {
            sum += num;

            if (sum % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }

        return (int) (odd * even % mod);
    }
}
