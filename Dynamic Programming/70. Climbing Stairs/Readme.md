# 70. Climbing Stairs

[Go to the problem on Leetcode](https://leetcode.com/problems/climbing-stairs/)

## Intuition

Imagine you are climbing a staircase with `n` steps. Each time you can either take 1 step or 2 steps. The problem is to find out how many different ways you can reach the top of the staircase.

For example, if there are 3 steps, you can reach the top in the following ways:
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step

So, there are 3 different ways to climb 3 steps.

## Approach

To solve this problem, you can use a simple technique based on the observation that the number of ways to reach the `i`-th step is the sum of the number of ways to reach the `(i-1)`-th step and the `(i-2)`-th step. This is because to get to step `i`, you could either:
- Come from step `i-1` with a single step.
- Come from step `i-2` with a double step.

This is similar to how the Fibonacci sequence is defined.

## Complexity

### Time Complexity

The time complexity is `O(n)`. This is because we use a loop that iterates from `3` to `n`, which is linear in terms of the size of `n`.

### Space Complexity

The space complexity is `O(n)`. This is because we use an array `arr` of size `n + 1` to store the number of ways to reach each step.

## Code

Here is the Java code that implements this approach:

```java
class Solution {
    public int climbStairs(int n) {

        if (n == 1) return 1;
        
        int[] arr = new int[n + 1];
        arr[1] = 1; // There is only one way to reach the first step
        arr[2] = 2; // There are two ways to reach the second step (1+1 or 2)

        for (int i = 3; i <= n; i++) {
            // The number of ways to reach the i-th step is the sum of the ways to reach (i-1) and (i-2) steps
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        return arr[n];
    }
}