class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        int n = cardPoints.length;

        for (int i = 0; i < k; i++) {
            sum += cardPoints[i];
        }

        int maxSum = sum;

        for (int i = 1; i <= k; i++) {
            sum -= cardPoints[k - i];
            sum += cardPoints[n - i];

            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }
}