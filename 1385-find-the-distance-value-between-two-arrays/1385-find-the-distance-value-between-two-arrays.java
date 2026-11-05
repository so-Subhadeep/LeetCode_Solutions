
class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);

        int count = 0;

        for (int num : arr1) {
            int index = Arrays.binarySearch(arr2, num);

            if (index >= 0) continue;

            index = -index - 1;

            boolean valid = true;

            if (index < arr2.length && arr2[index] - num <= d) {
                valid = false;
            }

            if (index > 0 && num - arr2[index - 1] <= d) {
                valid = false;
            }

            if (valid) count++;
        }

        return count;
    }
}
