# 283. Move Zeroes

[Go to the problem on Leetcode](https://leetcode.com/problems/move-zeroes/)

## Intuition
The problem asks us to move all the zeros in an array to the end while maintaining the relative order of the non-zero elements. The idea is to "snowball" the zeros as we encounter them and "push" them to the end of the array while keeping the non-zero elements in their original order.

## Approach
1. **Snowball Size:** 
   - We use a variable `snowBallSize` to keep track of how many zeros we've encountered as we loop through the array. The idea is that as the "snowball" of zeros grows, we need to move the non-zero elements forward by the size of this snowball.

2. **Iterate Through the Array:**
   - We loop through the array, and for each element:
     - **If the element is zero:** Increase the `snowBallSize` by 1. This means the snowball has grown by one zero.
     - **If the element is non-zero and there's a snowball:** Move the current non-zero element to the correct position (which is `i - snowBallSize`) and place a zero where the current non-zero element was.

3. **End Result:**
   - After the loop, all zeros will be "pushed" to the end of the array, and the relative order of the non-zero elements will remain unchanged.

## Complexity

### Time Complexity:
- **O(n):** We only make one pass through the array, so the time complexity is O(n), where n is the number of elements in the array.

### Space Complexity:
- **O(1):** The solution uses a constant amount of extra space, as only a few variables are used regardless of the input size.

## Code

```java
class Solution {
    public void moveZeroes(int[] nums) {

        // Snowball Theory
        int snowBallSize = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                snowBallSize++;
            } else if (snowBallSize > 0) {
                nums[i - snowBallSize] = nums[i];
                nums[i] = 0;
            }
        }
    }
}