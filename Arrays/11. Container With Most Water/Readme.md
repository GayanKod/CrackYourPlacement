# 11. Container With Most Water

[Go to the problem on Leetcode](https://leetcode.com/problems/container-with-most-water/)

## Problem Description
Given an array `height` where each element represents the height of a vertical line, you are tasked with finding two lines that, together with the x-axis, form a container. The goal is to maximize the amount of water the container can hold.

## Intuition
The goal is to maximize the area formed between any two vertical lines. The area is determined by the shorter line of the two because water cannot overflow beyond the shorter line. Additionally, the area is also dependent on the distance between the two lines. Therefore, the challenge is to find the pair of lines that gives the largest possible area.

## Approach
1. **Two-Pointer Technique**:  
   - Start by placing two pointers: one at the beginning (`start`) and one at the end (`end`) of the array.
   - Calculate the area formed by the lines at these two pointers.
   - Move the pointer that is at the shorter line towards the other pointer because the only way to potentially increase the area is to find a taller line.
   - Repeat this process until the two pointers meet.

2. **Calculate the Area**:
   - For each pair of lines pointed to by the two pointers, calculate the area as the product of the distance between the pointers (which is `end - start`) and the height of the shorter line (i.e., `Math.min(height[start], height[end])`).
   - Keep track of the maximum area encountered during this process.

3. **End the Loop**:
   - The loop terminates when the two pointers meet, meaning all possible pairs have been considered.

## Complexity

- **Time Complexity**:  
  The algorithm runs in O(n) time because each pointer only moves towards the other, and each element is processed only once.

- **Space Complexity**:  
  The algorithm uses O(1) space, as it only requires a few extra variables for storing indices and the maximum area.

## Code

```java
class Solution {
    public int maxArea(int[] height) {

        int start = 0;
        int end = height.length - 1;
        int containerLength = height.length - 1;
        int maxArea = 0;
        
        while (start != end) {
            // Calculate the minimum height between the two lines
            int level = Math.min(height[start], height[end]);
            
            // Calculate the area and update maxArea if this area is larger
            if (maxArea < level * containerLength) 
                maxArea = level * containerLength;
            
            // Move the pointer pointing to the shorter line
            if (height[start] < height[end]) {
                start++;
            } else {
                end--;
            }
            
            // Reduce the container length as we move the pointers
            containerLength--;
        }

        return maxArea;
    }
}