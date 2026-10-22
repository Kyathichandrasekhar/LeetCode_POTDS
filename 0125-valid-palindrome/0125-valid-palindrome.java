class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();

        if(s.length()<=1){
            return true;
        }

        StringBuilder sb = new StringBuilder();

        for(int i =0;i<s.length();i++){
            char ch = s.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                sb.append(ch);
            }
        }

        int l =0;
        int r = sb.length()-1;

        while(l<r){
            if(sb.charAt(l)!=sb.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
