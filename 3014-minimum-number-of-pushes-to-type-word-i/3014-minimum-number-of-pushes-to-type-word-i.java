class Solution {
    public int minimumPushes(String word) {

        if (word.length() <= 8) {
            return word.length();
        }

        int n = word.length();
        int ans = 0;
        int currentPush = 1;

        while (n > 8) {
            ans += 8 * currentPush;
            n -= 8;
            currentPush++;
        }

        ans += n * currentPush;

        return ans;
    }
}