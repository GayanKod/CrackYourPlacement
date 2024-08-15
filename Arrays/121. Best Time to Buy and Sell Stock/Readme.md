# 121. Best Time to Buy and Sell Stock 

[Go to the problem on Leetcode](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)

## Intuition
The problem is about finding the maximum profit you can achieve by buying and selling a stock on different days. The key idea here is that you want to buy the stock at the lowest possible price and then sell it at the highest price that comes after the buying day. To achieve this, you can keep track of the minimum price encountered so far and calculate the profit if you were to sell on the current day.

## Approach
1. **Initialize Variables:**
   - `maxProfit`: This variable will store the maximum profit you can achieve. Initially, it is set to `0` because if no transaction is made, the profit is zero.
   - `minValue`: This variable will store the minimum price encountered so far. It is initialized to `Integer.MAX_VALUE`, which is the largest possible value, to ensure that any price in the array will be smaller.

2. **Iterate Through the Prices:**
   - Loop through each price in the `prices` array.
   - For each price, do the following:
     - **Update the Minimum Price:** If the current price is lower than `minValue`, update `minValue` to the current price.
     - **Calculate the Profit:** If selling at the current price would yield a higher profit than the current `maxProfit`, update `maxProfit` with this new profit. The profit is calculated as `current price - minValue`.

3. **Return the Result:**
   - After looping through all the prices, `maxProfit` will contain the maximum possible profit. Return this value.

## Complexity

### Time Complexity:
- **O(n):** The solution involves a single pass through the `prices` array, making the time complexity O(n), where n is the number of prices.

### Space Complexity:
- **O(1):** The solution uses a constant amount of extra space, as only a few variables are used regardless of the input size.

## Code

```java
class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minValue = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minValue) {
                minValue = prices[i];
            } else if (prices[i] - minValue > maxProfit) {
                maxProfit = prices[i] - minValue;
            }
        }
        return maxProfit;
    }
}