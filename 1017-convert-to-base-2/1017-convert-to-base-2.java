class Solution {
    public String baseNeg2(int n) {

        if (n == 0) {
            return "0";
        }

        StringBuilder ans = new StringBuilder();

        while (n != 0) {

            int remainder = n % -2;

            if (remainder < 0) {
                remainder += 2;
            }

            ans.append(remainder);

            n = (n - remainder) / -2;
        }

        return ans.reverse().toString();
    }
}