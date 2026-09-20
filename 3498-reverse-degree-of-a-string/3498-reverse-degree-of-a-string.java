class Solution {
    public int reverseDegree(String s) {
        int prod = 0;
        for(int i =0;i<s.length();i++){
            int val = 'z' - s.charAt(i) + 1;
            prod += (i+1)*val;
        }
        return prod;
    }
}