class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int i, int[] nums,
                           List<Integer> subset,
                           List<List<Integer>> result) {

        // Base case
        if (i == nums.length) {
            result.add(new ArrayList<>(subset));
            return;
        }

        // Include nums[i]
        subset.add(nums[i]);
        backtrack(i + 1, nums, subset, result);

        // Backtrack
        subset.remove(subset.size() - 1);

        // Don't include nums[i]
        backtrack(i + 1, nums, subset, result);
    }
}