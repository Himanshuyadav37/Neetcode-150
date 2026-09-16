class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {

        List<List<Integer>> ans = new ArrayList<>();

        backtrack(0, nums, new ArrayList<>(), target, ans);

        return ans;
    }

    public void backtrack(
        int i,
        int[] nums,
        List<Integer> curr,
        int target,
        List<List<Integer>> ans
    ) {

        if (target == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        if (i >= nums.length || target < 0) {
            return;
        }

        // TAKE
        curr.add(nums[i]);
        backtrack(i, nums, curr, target - nums[i], ans);

        // BACKTRACK
        curr.remove(curr.size() - 1);

        // NOT TAKE
        backtrack(i + 1, nums, curr, target, ans);
    }
}