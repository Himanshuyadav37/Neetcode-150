public class Solution {
    public int longestConsecutive(int[] nums) {

        // Create HashSet to store unique elements
        Set<Integer> set = new HashSet<>();

        // Add all elements to the HashSet
        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;

        // Check every number
        for (int num : set) {

            // If num - 1 is not present, num is the starting point
            if (!set.contains(num - 1)) {

                int length = 1;

                // Count consecutive numbers
                while (set.contains(num + length)) {
                    length++;
                }

                // Update the longest sequence
                longest = Math.max(longest, length);
            }
        }

        return longest;
    }
}