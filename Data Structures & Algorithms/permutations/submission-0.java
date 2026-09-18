class Solution {

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void backtrack(int[] nums, int idx, List<List<Integer>> ans) {

        // permutation complete
        if (idx == nums.length) {
            List<Integer> permutation = new ArrayList<>();

            for (int num : nums) {
                permutation.add(num);
            }

            ans.add(permutation);
            return;
        }

        // try every element at current position
        for (int i = idx; i < nums.length; i++) {

            // choose
            swap(nums, idx, i);

            // explore
            backtrack(nums, idx + 1, ans);

            // undo choice
            swap(nums, idx, i);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        backtrack(nums, 0, ans);

        return ans;
    }
}