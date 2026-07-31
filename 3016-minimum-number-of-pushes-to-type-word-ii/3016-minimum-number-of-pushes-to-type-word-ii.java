class Solution {
    public int minimumPushes(String word) {
        HashMap<Character,Integer> map = new HashMap<>();

        for(int i = 0;i<word.length();i++){
            char ch = word.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

         List<Integer> list = new ArrayList<>(map.values());

        Collections.sort(list, Collections.reverseOrder());

        int ans = 0;
        for (int i = 0; i < list.size(); i++) {
            int freq = list.get(i);

            int cost = (i / 8) + 1;

            ans += freq * cost;
        }
        return ans;
    }
}