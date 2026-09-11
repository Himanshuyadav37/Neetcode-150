class Solution {

    // Checks whether both frequency arrays are exactly same
    boolean isFreqSame(int[] freq1, int[] freq2) {

        for (int i = 0; i < 26; i++) {

            if (freq1[i] != freq2[i]) {
                return false;
            }
        }

        return true;
    }

    public boolean checkInclusion(String s1, String s2) {

        // Store frequency of characters in s1
        int[] freq = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            freq[s1.charAt(i) - 'a']++;
        }

        // Size of every window we need to check
        int windSize = s1.length();

        // Try every starting position in s2
        for (int i = 0; i < s2.length(); i++) {

            int windIdx = 0;
            int idx = i;

            // Frequency of current window
            int[] windFreq = new int[26];

            // Build a window of size s1.length()
            while (windIdx < windSize && idx < s2.length()) {

                windFreq[s2.charAt(idx) - 'a']++;

                windIdx++;
                idx++;
            }

            // If current window has same frequency,
            // then it is a permutation of s1
            if (isFreqSame(freq, windFreq)) {
                return true;
            }
        }

        // No permutation found
        return false;
    }
}