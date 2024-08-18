# Best Time to Buy and Sell Stock II

[Go to the problem on Leetcode](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/)

## Problem
You are given an array `prices` where `prices[i]` is the price of a given stock on the `i`th day. You want to maximize your profit by buying and selling the stock as many times as you like. However, you must sell the stock before you buy it again.

## Intuition
The goal is to maximize your profit by capturing all the profitable "uphill" moves in the price array. Essentially, whenever there is a price increase from one day to the next, that difference represents a potential profit. By summing up all these profitable differences, you can calculate the maximum profit you can achieve.

## Approach
1. **Iterate Through the Array**: Start from the second day and compare the price with the previous day.
2. **Check for Profit**: If the price on the current day is higher than the price on the previous day, add the difference to the `maxProfit`. This is because buying on the previous day and selling on the current day would yield a profit.
3. **Sum the Profits**: Continue this process for the entire array, summing up all the profitable differences.
4. **Return the Total Profit**: At the end, the `maxProfit` variable contains the maximum profit achievable by buying and selling multiple times.

## Complexity
- **Time Complexity**: `O(n)`  
  We only make one pass through the `prices` array, where `n` is the number of days. This makes the time complexity linear.
  
- **Space Complexity**: `O(1)`  
  We use a constant amount of extra space (just the `maxProfit` variable), so the space complexity is constant.

## Code
```java
class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            // If the price on day i is higher than the price on day i-1,
            // it means we should have bought on day i-1 and sold on day i.
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }

        return maxProfit;
    }
}