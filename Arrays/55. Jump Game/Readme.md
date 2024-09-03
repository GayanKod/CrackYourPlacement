# 55. Jump Game 

[Go to the problem on Leetcode](https://leetcode.com/problems/jump-game/)

The "Jump Game" problem asks you to determine if you can reach the last index of an array, starting from the first index. Each element in the array represents the maximum jump length you can make from that position.

## Intuition

The main idea is to start from the end of the array and work backward to see if you can reach the beginning. Instead of trying to jump forward, you check if it's possible to reach the end by starting from any earlier position. If you can "reach" the last index from a certain position, then that position becomes the new target (flag) that you need to reach from the start.

## Approach

1. **Initialize the Target (Flag)**: 
   - Start by setting a "flag" at the last index of the array. This flag represents the position you need to reach or exceed.

2. **Work Backward**:
   - Iterate from the second last element of the array to the first element.
   - For each element, check if you can jump from this position to or beyond the current flag.
   - If you can, move the flag to this position. This means you can reach the end from here.

3. **Check the Start**:
   - After iterating through the array, check if the flag has moved to the start (index 0).
   - If the flag is at index 0, it means you can reach the last index from the first index, so return `true`.
   - Otherwise, return `false`.

## Complexity

- **Time complexity**:
  - The time complexity is `O(N)`, where `N` is the length of the array.
  - This is because we only make one pass through the array, checking each element once.

- **Space complexity**:
  - The space complexity is `O(1)` because we are only using a constant amount of extra space (the `flag` variable).

## Code

```java
class Solution {
    public boolean canJump(int[] nums) {
        
        int flag = nums.length - 1;

        // Let's find out if we can reach the flag from the last element
        for (int i = flag - 1; i >= 0; i--) {
            
            // Check if the current position can jump to or beyond the flag
            if (i + nums[i] >= flag) {
                flag = i;
            }
        }

        // If the flag has moved to the start, return true; otherwise, false
        return flag == 0;
    }
}
```