class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // 1. Frequency count
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 2. Create buckets
        // bucket[i] = elements having frequency i
        List<Integer>[] bucket = new ArrayList[nums.length + 1];

        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new ArrayList<>();
        }

        // 3. Put elements into buckets
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();

            bucket[freq].add(num);
        }

        // 4. Collect top k elements
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