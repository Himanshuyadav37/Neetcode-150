
class Solution {

    private void getAllSubsets(
        int[] nums,
        List<Integer> ans,
        int idx,
        List<List<Integer>> allSubsets
    ) {

        // Base case
        if (idx == nums.length) {
            allSubsets.add(new ArrayList<>(ans));
            return;
        }

        // Include
        ans.add(nums[idx]);

        getAllSubsets(nums, ans, idx + 1, allSubsets);

        ans.remove(ans.size() - 1);

        // Skip duplicates
        int i = idx + 1;

        while (i < nums.length && nums[i] == nums[i - 1]) {
            i++;
        }

        // Exclude
        getAllSubsets(nums, ans, i, allSubsets);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> allSubsets = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();

        Arrays.sort(nums);

        getAllSubsets(nums, ans, 0, allSubsets);

        return allSubsets;
    }
}