class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int low = 1;
        int high = 0;

        // Find maximum pile
        for (int i = 0; i < piles.length; i++) {
            high = Math.max(high, piles[i]);
        }

        while (low <= high) {

            int mid = low + (high - low) / 2;

            int hours = 0;

            // Calculate total hours
            for (int i = 0; i < piles.length; i++) {
                hours += (piles[i] + mid - 1) / mid;
            }

            // mid is a possible answer
            if (hours <= h) {
                high = mid - 1;
            } 
            // mid is too slow
            else {
                low = mid + 1;
            }
        }

        return low;
    }
}