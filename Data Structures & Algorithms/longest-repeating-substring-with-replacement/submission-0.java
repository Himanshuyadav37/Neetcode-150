class Solution {
    public int characterReplacement(String s, int k) {

        // Frequency of each character (A-Z)
        int[] freq = new int[26];

        // Left pointer of sliding window
        int left = 0;

        // Maximum frequency of any single character
        // inside the current window
        int maxFreq = 0;

        // Maximum valid window length found so far
        int maxWindow = 0;

        // Expand the window using right pointer
        for(int right = 0; right < s.length(); right++){

            // Add current character to frequency array
            freq[s.charAt(right) - 'A']++;

            // Update maximum frequency in current window
            maxFreq = Math.max(
                maxFreq,
                freq[s.charAt(right) - 'A']
            );

            // Current window length
            int windowLength = right - left + 1;

            // Number of characters that need to be replaced
            // = total characters - most frequent character
            //
            // If replacements > k, window is invalid
            if(windowLength - maxFreq > k){

                // Remove the leftmost character
                // from the current window
                freq[s.charAt(left) - 'A']--;

                // Shrink the window
                left++;
            }

            // Calculate window length after shrinking
            windowLength = right - left + 1;

            // Store the maximum valid window length
            maxWindow = Math.max(maxWindow, windowLength);
        }

        // Return the longest possible substring length
        return maxWindow;
    }
}