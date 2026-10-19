class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==target){
                result.add(i);
            }
        }

        return result;
    }
}