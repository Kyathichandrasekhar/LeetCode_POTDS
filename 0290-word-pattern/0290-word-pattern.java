class Solution {
    public boolean wordPattern(String pattern, String s) {
        char[] ch = pattern.toCharArray();
        String[] arr = s.split(" ");

        if (ch.length != arr.length) {
            return false;
        }

        HashMap<Character, String> map = new HashMap<>();
        HashMap<String, Character> map1 = new HashMap<>();

        for (int i = 0; i < ch.length; i++) {
            char c = ch[i];
            String word = arr[i];

            if (map.containsKey(c) && !map.get(c).equals(word)) {
                return false;
            }

            if (map1.containsKey(word) && map1.get(word) != c) {
                return false;
            }

            map.put(c, word);
            map1.put(word, c);
        }

        return true;
    }
}
