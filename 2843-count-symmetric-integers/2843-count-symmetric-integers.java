class Solution {
    public int countSymmetricIntegers(int low, int high) {

        int count = 0;

        for (int i = low; i <= high; i++) {

            int digits = String.valueOf(i).length();

            // Symmetric integers must have even number of digits
            if (digits % 2 != 0) {
                continue;
            }

            int half = digits / 2;

            int divisor = (int)Math.pow(10, half);

            int firstHalf = i / divisor;
            int secondHalf = i % divisor;

            int sumFirst = 0;
            int sumSecond = 0;

            while (firstHalf > 0) {
                sumFirst += firstHalf % 10;
                firstHalf /= 10;
            }

            while (secondHalf > 0) {
                sumSecond += secondHalf % 10;
                secondHalf /= 10;
            }

            if (sumFirst == sumSecond) {
                count++;
            }
        }

        return count;
    }
}