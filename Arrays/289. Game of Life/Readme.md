## Problem: Game of Life (LeetCode)

[Link to the problem on Leetcode](https://leetcode.com/problems/game-of-life/)

The Game of Life is a simulation where each cell on a 2D grid can either be alive (1) or dead (0). The state of each cell evolves according to specific rules based on the number of live neighbors it has. The goal is to calculate the next state of the grid based on these rules:

1. Any live cell with fewer than two live neighbors dies (underpopulation).
2. Any live cell with two or three live neighbors lives to the next generation.
3. Any live cell with more than three live neighbors dies (overpopulation).
4. Any dead cell with exactly three live neighbors becomes alive (reproduction).

---

### Intuition

The problem requires calculating the next state of the board, but you should avoid using extra memory for a separate board. One way to achieve this is by using **bit manipulation** to store both the current and next state within the same cell. By using bitwise operations, we can keep track of the state changes efficiently.

---

### Approach

The approach consists of two main passes over the board:

1. **First Pass:**
   - For each cell, count how many live neighbors it has by checking its surrounding cells (8 possible directions).
   - Based on the number of live neighbors, we apply the rules of the game. Instead of changing the state of the cell immediately, we store the next state in the second bit of the integer (using bitwise operations).
   - For example, if the cell is alive now, and it will stay alive in the next generation, we set the second bit to 1. Otherwise, if it dies, the second bit remains 0.

2. **Second Pass:**
   - In this pass, we update the board to its new state by shifting the second bit (the next state) to the first bit, which is the current state.

---

### Complexity

#### Time Complexity:
- The time complexity is **O(m \* n)** where `m` is the number of rows and `n` is the number of columns in the board. We need to iterate over every cell in the grid twice: once to calculate the next state, and once to update the current state.

#### Space Complexity:
- The space complexity is **O(1)** since we are not using any extra space. We are storing both the current state and the next state within the same board using bitwise operations.

---

### Code

```java
class Solution {
    public void gameOfLife(int[][] board) {
        int[] x = {0, 1, 1, 1, 0, -1, -1, -1};
        int[] y = {1, 1, 0, -1, -1, -1, 0, 1};
        
        int rows = board.length;
        int cols = board[0].length;

        // First pass: Calculate the next state and store it using the second bit
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int liveNeighbors = 0;

                // Count live neighbors
                for (int n = 0; n < 8; n++) {
                    int newX = i + x[n];
                    int newY = j + y[n];
                    
                    if (newX >= 0 && newY >= 0 && newX < rows && newY < cols) {
                        liveNeighbors += board[newX][newY] & 1; // Use bitwise AND to get the current state
                    }
                }

                // Apply the rules of the Game of Life
                if ((board[i][j] & 1) == 1) { // Cell is currently alive
                    if (liveNeighbors == 2 || liveNeighbors == 3) {
                        board[i][j] |= 2; // Set the second bit (next state to 1)
                    }
                } else { // Cell is currently dead
                    if (liveNeighbors == 3) {
                        board[i][j] |= 2; // Set the second bit (next state to 1)
                    }
                }
            }
        }

        // Second pass: Shift right to update the board to the next state
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] >>= 1; // Move the second bit to the first bit (update to next state)
            }
        }
    }
}