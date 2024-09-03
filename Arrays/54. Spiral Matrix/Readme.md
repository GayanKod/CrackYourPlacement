# 54. Spiral Matrix

The "Spiral Matrix" problem requires you to traverse a 2D matrix in a spiral order, starting from the top-left corner and moving in a clockwise direction. The task is to return all the elements of the matrix in this spiral order.

## Intuition

To solve this problem, imagine "peeling" the matrix layer by layer, starting from the outermost layer and moving inward. We start by traversing the top row, then the right column, then the bottom row, and finally the left column. After completing one full cycle, we move inward and repeat the process until we have processed all elements of the matrix.

## Approach

1. **Initialize Boundaries**:
   - Set four boundaries: `top`, `bottom`, `left`, and `right` to define the current layer of the matrix that we are traversing.
   - Initially, `top` is 0, `bottom` is the last row, `left` is 0, and `right` is the last column.

2. **Traverse in Spiral Order**:
   - **Left to Right**: Traverse the `top` row from the `left` boundary to the `right` boundary, then move the `top` boundary downwards.
   - **Top to Bottom**: Traverse the `right` column from the `top` boundary to the `bottom` boundary, then move the `right` boundary leftwards.
   - **Right to Left**: If the `top` boundary is still below or equal to the `bottom`, traverse the `bottom` row from the `right` boundary to the `left` boundary, then move the `bottom` boundary upwards.
   - **Bottom to Top**: If the `left` boundary is still to the left of or equal to the `right`, traverse the `left` column from the `bottom` boundary to the `top` boundary, then move the `left` boundary rightwards.

3. **Repeat** the above steps until the boundaries overlap, indicating that all elements have been visited.

4. **Return the Result**:
   - Once all elements have been added to the result list, return it.

## Complexity

- **Time complexity**:
  - The time complexity is `O(M * N)`, where `M` is the number of rows and `N` is the number of columns.
  - This is because we visit each element of the matrix exactly once.

- **Space complexity**:
  - The space complexity is `O(1)` if we disregard the space required for the output list.
  - The only extra space used is for the result list, which is proportional to the number of elements in the matrix.

## Code

```java
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        
        if (matrix == null || matrix.length == 0) {
            return result;
        }
        
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            // Traverse from left to right along the top row
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;

            // Traverse from top to bottom along the right column
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            // Traverse from right to left along the bottom row, if still within bounds
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }

            // Traverse from bottom to top along the left column, if still within bounds
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }

        return result;
    }
}
```
