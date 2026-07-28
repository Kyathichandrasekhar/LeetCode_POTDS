class Solution {
    public String smallestPalindrome(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        // Count frequency
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        StringBuilder firstHalf = new StringBuilder();
        String middle = "";

        // Process characters in sorted order
        for (char ch = 'a'; ch <= 'z'; ch++) {

            if (map.containsKey(ch)) {

                int freq = map.get(ch);

                // Add half of the characters
                for (int i = 0; i < freq / 2; i++) {
                    firstHalf.append(ch);
                }

                // Store middle character if frequency is odd
                if (freq % 2 == 1) {
                    middle = String.valueOf(ch);
                }
            }
        }

        String secondHalf = new StringBuilder(firstHalf).reverse().toString();

        return firstHalf.toString() + middle + secondHalf;
    }
}