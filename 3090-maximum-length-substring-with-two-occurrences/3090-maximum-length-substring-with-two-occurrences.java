class Solution {
    public int maximumLengthSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        int l = 0;
        int maxLen = 0;

        for (int r = 0; r < s.length(); r++) {

            // Add current character
            map.put(s.charAt(r), 
                    map.getOrDefault(s.charAt(r), 0) + 1);

            // If any character occurs more than 2 times
            while (map.get(s.charAt(r)) > 2) {
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                l++;
            }

            // Current window is valid
            maxLen = Math.max(maxLen, r - l + 1);
        }

        return maxLen;
    }
}