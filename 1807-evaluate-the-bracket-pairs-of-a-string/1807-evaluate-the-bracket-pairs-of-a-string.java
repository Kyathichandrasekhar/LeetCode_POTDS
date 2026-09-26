class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {

        HashMap<String, String> map = new HashMap<>();

        // Store knowledge in HashMap
        for (int i = 0; i < knowledge.size(); i++) {
            map.put(knowledge.get(i).get(0), knowledge.get(i).get(1));
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {

                i++; // move after '('

                StringBuilder key = new StringBuilder();

                // Collect characters until ')'
                while (s.charAt(i) != ')') {
                    key.append(s.charAt(i));
                    i++;
                }

                // Get value from HashMap
                if (map.containsKey(key.toString())) {
                    result.append(map.get(key.toString()));
                } else {
                    result.append("?");
                }

            } else {
                result.append(s.charAt(i));
            }
        }

        return result.toString();
    }
}