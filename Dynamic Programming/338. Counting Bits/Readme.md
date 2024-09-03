# 338. Counting Bits

[Go to the problem on Leetcode](https://leetcode.com/problems/counting-bits)

## Intuition

The problem is about counting the number of `1`s in the binary representation of each number from `0` to `n`. For example, the number `5` in binary is `101`, which has two `1`s. The goal is to find out how many `1`s are in the binary representation of each number within this range.

## Approach

To solve this problem efficiently, we can use a pattern based on the observation of how numbers are represented in binary. Specifically, if you know the number of `1`s in the binary representation of a number `i`, you can use this information to find the number of `1`s in the number `i + 1`.

Here's a simple pattern:
- If `i` is even, its binary representation is the same as `i/2` (with a `0` appended at the end).
- If `i` is odd, its binary representation is the same as `i/2` (with a `1` appended at the end).

## Complexity

### Time Complexity

The time complexity of this approach is `O(n)`. This is because we only need to iterate through the numbers from `0` to `n` once, and each operation within the loop is constant time.

### Space Complexity

The space complexity is `O(n)`. This is because we use an array of size `n+1` to store the count of `1`s for each number from `0` to `n`.

## Code

Here is the Java code that implements this approach:

```java
class Solution {
    public int[] countBits(int n) {
        
        int[] arr = new int[n+1];

        for (int i = 0; i <= n; i++) {
            if (i % 2 == 0) {
                // For even numbers, the number of 1s is the same as for i/2
                arr[i] = arr[i / 2];
            } else {
                // For odd numbers, add 1 to the number of 1s in i/2
                arr[i] = arr[i / 2] + 1;
            }
        }

        return arr;
    }
}