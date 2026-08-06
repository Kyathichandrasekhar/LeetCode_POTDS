class Solution {
    public int smallestNumber(int n, int t) {

        while (true) {
            int temp = n;
            int product = 1;

            // Calculate the product of digits
            while (temp > 0) {
                int digit = temp % 10;
                product *= digit;
                temp /= 10;
            }

            // Check if divisible by t
            if (product % t == 0) {
                return n;
            }

            n++;
        }
    }
}