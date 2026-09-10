class Solution {
    public int longestConsecutive(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int maxLength = 0;
        int length = 0;
        int currNum;

        for (int i = 0; i < nums.length; i++) {

            if (!set.contains(nums[i] - 1)) {

                currNum = nums[i];
                length = 1;

                while (set.contains(currNum + 1)) {
                    currNum = currNum + 1;
                    length = length + 1;
                }

                maxLength = Math.max(maxLength, length);
            }
        }

        return maxLength;
    }
}
