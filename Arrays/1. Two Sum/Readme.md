# 1. Two Sum

[Go to the problem on Leetcode](https://leetcode.com/problems/two-sum/)

## Intuition
The problem is to find two numbers in an array that add up to a given target. A simple approach would be to check every possible pair of numbers to see if they sum to the target, but this would be slow. Instead, we can use a smarter approach by taking advantage of a `HashMap` to store and quickly look up values we've already seen.

## Approach
1. **Create a HashMap:** We use a `HashMap` (called `hm` in the code) to store numbers we've seen so far in the array. The key is the number itself, and the value is the index where that number appears in the array.

2. **Iterate through the array:** We loop through each number in the array. For each number `nums[i]`, we do the following:
   - **Check if the complement exists:** The complement is the number that, when added to `nums[i]`, equals the target. In other words, the complement is `target - nums[i]`. We check if this complement is already in our `HashMap`.
   - **If the complement is found:** If the complement is in the `HashMap`, it means we've already seen the number we need to pair with `nums[i]` to reach the target. We then return the indices of these two numbers.
   - **If the complement is not found:** If the complement is not in the `HashMap`, we store the current number `nums[i]` and its index `i` in the `HashMap` and move to the next number.

3. **Return the result:** If we find the two numbers that sum to the target, we return their indices as an array. If we finish the loop without finding a solution, we return an empty array (though the problem guarantees there will always be a solution, so this case won’t actually happen).

## Complexity

### Time Complexity:
- **O(n):** We only need to loop through the array once. Each lookup or insertion operation in a `HashMap` takes O(1) time on average. Therefore, the overall time complexity is O(n), where n is the number of elements in the array.

### Space Complexity:
- **O(n):** In the worst case, we might store all the elements of the array in the `HashMap`. So the space complexity is O(n), where n is the number of elements in the array.

## Code

```java
// Best Solution
class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            if (hm.containsKey(target - nums[i])) {
                return new int[] {i, hm.get(target - nums[i])};
            } else {
                hm.put(nums[i], i);
            }
        }
        return new int[] {};
    }
}