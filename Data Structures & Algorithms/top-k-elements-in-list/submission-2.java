class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Frequency count
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Buckets
        List<Integer>[] bucket = new ArrayList[nums.length + 1];

        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new ArrayList<>();
        }

        // Put numbers according to frequency
        for (int num : map.keySet()) {
            int freq = map.get(num);
            bucket[freq].add(num);
        }

        // Get top K
        int[] result = new int[k];
        int index = 0;

        for (int i = bucket.length - 1; i >= 0 && index < k; i--) {

            for (int num : bucket[i]) {
                result[index] = num;
                index++;

                if (index == k) {
                    break;
                }
            }
        }

        return result;
    }
}