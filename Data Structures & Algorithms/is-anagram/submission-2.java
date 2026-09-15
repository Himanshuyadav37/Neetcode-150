class Solution {
    public boolean isAnagram(String s, String t) {
        int[] freq = new int[26];

        // length
        if(s.length() != t.length()){
            return false;
        }

        for(char ch : s.toCharArray()){
            freq[ch-'a']++;
        }

        for(char ch : t.toCharArray()){
            freq[ch-'a']--;
        }

        for(int count : freq){
            if(count != 0){
                return false;
            }
        }
        return true;
    }
}
