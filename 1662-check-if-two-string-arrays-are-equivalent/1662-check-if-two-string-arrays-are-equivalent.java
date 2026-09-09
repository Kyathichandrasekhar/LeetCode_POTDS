class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String r1 = "";
        String r2 = "";
        for(int i = 0; i < word1.length;i++)
        {
            r1 += word1[i];
        }
        for(int i = 0; i < word2.length;i++)
        {
            r2 += word2[i];
        }
        return r1.equals(r2);
    }
}