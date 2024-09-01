# **1423. Maximum Points You Can Obtain from Cards**

[Go to the problem on Leetcode](https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/)

## **Intuition**
Imagine you have a row of cards, each with a certain number of points. You can pick exactly `k` cards, but they must be picked from either the start or the end of the row. The goal is to find the maximum score you can get by choosing `k` cards.

The problem requires you to balance between picking cards from the start and the end. Instead of picking all `k` cards from one side, you need to consider different combinations of picking some cards from the start and some from the end.

## **Approach**
1. **Initial Sum Calculation**:
   - Start by calculating the sum of the first `k` cards. This will represent the score if you took all `k` cards from the start.

2. **Sliding Window Technique**:
   - To explore other combinations, use a sliding window approach. For each step, remove one card from the start of the initial sum and add one card from the end.
   - By doing this for `k` steps, you consider all possible ways of splitting `k` cards between the start and the end.
   - After each adjustment, update the maximum score if the current sum is higher.

3. **Final Maximum Score**:
   - The highest sum encountered during this process is the maximum score you can achieve by picking exactly `k` cards.

## **Complexity**

- **Time Complexity**: `O(k)`
  - The algorithm runs in linear time relative to `k`. It first calculates the sum of the first `k` cards, which takes `O(k)`. Then, it iterates `k` times to adjust the sum using the sliding window technique.

- **Space Complexity**: `O(1)`
  - The algorithm uses a constant amount of additional space, regardless of the input size. Only a few integer variables are used to store the current sum and maximum score.

## **Code**

```java
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