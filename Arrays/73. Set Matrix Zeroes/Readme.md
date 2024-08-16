# 73. Set Matrix Zeroes

[Go to the problem on Leetcode](https://leetcode.com/problems/set-matrix-zeroes/)

## Problem
Given a matrix, if an element is 0, set its entire row and column to 0. Do it in-place.

## Intuition
The problem asks us to find all the 0s in the matrix and then set the entire row and column containing that 0 to 0. However, doing this directly might require extra space. The key idea here is to use the matrix itself to store information about the rows and columns that need to be zeroed out, minimizing the extra space needed.

## Approach
1. **Marker Technique**: 
   - We'll use the first row and the first column of the matrix as markers to remember which rows and columns should be zeroed.
   - We'll also use two boolean variables, `x` and `y`, to track whether the first row and first column themselves should be zeroed.

2. **Steps**:
   - **Step 1**: Check if the first row contains any zeroes. If it does, set `x = true`.
   - **Step 2**: Check if the first column contains any zeroes. If it does, set `y = true`.
   - **Step 3**: Use the first row and the first column as markers:
     - For each element in the matrix (excluding the first row and column), if it's zero, mark its corresponding row and column by setting the element in the first row and first column to 0.
   - **Step 4**: Use these markers to set entire rows and columns to zero:
     - For each element in the first row, if it's 0, set the entire column to 0.
     - For each element in the first column, if it's 0, set the entire row to 0.
   - **Step 5**: Finally, if `x` is true, set the entire first row to 0. If `y` is true, set the entire first column to 0.

## Complexity

- **Time Complexity**: 
  - The algorithm makes a few passes over the matrix, so it runs in `O(M * N)` time, where `M` is the number of rows and `N` is the number of columns in the matrix.

- **Space Complexity**: 
  - The space complexity is `O(1)` since we aren't using any additional space that grows with the size of the matrix, only a few extra variables.

## Code
```java
class Solution {
    public void setZeroes(int[][] matrix) {
        // Marker Technique
        // Let's take the first row and column as a marker
        boolean x = false;
        boolean y = false;

        // Check if the first row has any 0s
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                x = true;
            }
        }

        // Check if the first column has any 0s
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                y = true;
            }
        }

        // Markers: Use the first row and column to mark zero rows and columns
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        // Set columns to zero based on the markers
        for (int i = 1; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 1; j < matrix.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }

        // Set rows to zero based on the markers
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < matrix[i].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Set the first row and column to zero if needed
        if (x) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }

        if (y) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}