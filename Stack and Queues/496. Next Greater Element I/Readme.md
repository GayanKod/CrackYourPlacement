# 496. Next Greater Element I 

[Go to the problem on Leetcode](https://leetcode.com/problems/next-greater-element-i/)

## Intuition
The task is to find the "next greater element" for each element in an array. Given two arrays, `nums1` and `nums2`, for each element in `nums1`, we want to find the first greater element that appears to its right in `nums2`. If no such element exists, we return `-1`. To efficiently solve this problem, we can use a **stack** to keep track of elements in a way that allows us to find the next greater element faster.

## Approach
1. **Stack to Track Next Greater Elements:**
   We traverse through `nums2` from right to left. At each step, we maintain a stack of elements. The stack helps in determining the next greater element in `nums2` for the current element:
   - If the stack's top element is **smaller than or equal** to the current element, it is **not** the next greater element, so we pop it from the stack.
   - If the stack is **empty**, it means there is no greater element to the right, so we store `-1` in a map for that element.
   - Otherwise, the top of the stack is the **next greater element** for the current element, and we store that in a map.

2. **Map to Store Results:**
   We store the results (the next greater elements for each element in `nums2`) in a map. After processing all elements in `nums2`, the map will contain the next greater element for each element.

3. **Mapping to `nums1`:**
   For each element in `nums1`, we simply look up its next greater element in the map and store the result in an output array. If an element has no greater element, `-1` will be returned.

## Complexity
### Time Complexity:
- **O(n)**: We traverse `nums2` only once (`O(n)` where `n` is the length of `nums2`).
- The `while` loop inside the `for` loop runs in `O(n)` in total because each element is pushed and popped from the stack at most once. So, overall, the algorithm runs in **O(n)** time.

### Space Complexity:
- **O(n)**: We use a stack to store elements and a map to store the next greater elements, both of which use `O(n)` space.

## Code
```java
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        // Stack to store elements and map to store next greater element for each element in nums2
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        int[] out = new int[nums1.length];

        // Traverse nums2 from right to left
        for (int i = nums2.length - 1; i >= 0; i--) {
            int num = nums2[i];

            // Maintain stack where top of the stack is the next greater element
            while (!stack​⬤