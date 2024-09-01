class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int totalSum = 0;

        // Calculate the sum of the first k elements
        for (int i = 0; i < k; i++) {
            totalSum += cardPoints[i];
        }

        int maxScore = totalSum;

        // Use a sliding window to consider taking cards from the end instead of the beginning
        for (int i = 0; i < k; i++) {
            totalSum = totalSum - cardPoints[k - 1 - i] + cardPoints[n - 1 - i];
            maxScore = Math.max(maxScore, totalSum);
        }

        return maxScore;
    }
}