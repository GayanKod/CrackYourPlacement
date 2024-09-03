# 79. Word Search 

[Go to the problem on Leetcode](https://leetcode.com/problems/word-search/)

This problem involves searching for a given word in a 2D board of letters, where the word must be constructed by sequentially adjacent cells, either horizontally or vertically.

## Intuition

The main intuition behind this problem is that you need to explore the grid to find if the word exists by starting from each cell. Since the word can start from any cell and can go in any of the four possible directions (up, down, left, right), a depth-first search (DFS) is a natural fit for this problem. DFS allows us to explore all possible paths for the word starting from a specific cell. 

To ensure that a cell is not reused in the same word path, we temporarily mark it as visited.

## Approach

1. **Start the Search**: We begin by iterating through each cell of the board. For each cell, we start a depth-first search (DFS) to explore all possible paths that could form the word.

2. **Depth-First Search (DFS)**: 
    - If the current cell matches the character in the word at the current position (`currentLetter`), we continue searching the next character in all four possible directions (up, down, left, right).
    - If we reach a point where the entire word is matched, we return `true`.
    - If a direction does not lead to a solution, we backtrack by unmarking the cell (restoring its original character) and continue with other directions.

3. **Backtracking**: During DFS, we mark the current cell as visited by changing its value to a temporary character (e.g., `'#'`). After exploring, we unmark the cell (backtrack) to allow other paths to use it.

4. **Return the Result**: If any of the DFS calls return `true`, we know the word exists on the board and return `true`. If we exhaust all possibilities and none lead to a solution, we return `false`.

## Complexity

- **Time complexity**: 
  - The time complexity is `O(N * 4^L)`, where `N` is the total number of cells on the board, and `L` is the length of the word. 
  - This is because in the worst case, you might start DFS from every cell, and each DFS can have up to four recursive calls (one for each direction).

- **Space complexity**: 
  - The space complexity is `O(L)` where `L` is the length of the word.
  - This accounts for the recursion stack used by DFS, which can go as deep as the length of the word.

## Code

```java
class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean dfs(char[][] board, String word, int row, int col, int currentLetter) {
        // Check if all characters are matched
        if (currentLetter == word.length()) return true;

        // Check boundary conditions and character match
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length ||
            board[row][col] != word.charAt(currentLetter)) {
            return false;
        }

        // Mark the current cell as visited by temporarily changing its value
        char temp = board[row][col];
        board[row][col] = '#';

        // Explore all possible directions
        boolean res = dfs(board, word, row + 1, col, currentLetter + 1) ||
                      dfs(board, word, row - 1, col, currentLetter + 1) ||
                      dfs(board, word, row, col + 1, currentLetter + 1) ||
                      dfs(board, word, row, col - 1, currentLetter + 1);

        // Unmark the cell (backtracking)
        board[row][col] = temp;

        return res;
    }
}
```

### Example
- **Board**:
  ```
  A B C E
  S F C S
  A D E E
  ```
- **Word**: `"ABCCED"`

### Step-by-Step Visualization

1. **Initialization**:
   - The `exist` method starts by iterating over each cell in the board to find the starting character of the word `"ABCCED"`.

2. **First Match at (0, 0)**:
   - The first match occurs at cell `(0, 0)` where `board[0][0] = 'A'`.
   - `dfs(board, word, 0, 0, 0)` is called with `currentLetter = 0`.

3. **DFS at (0, 0)**:
   - The `dfs` method checks the character at `(0, 0)` and matches `'A'` with `word.charAt(0)`.
   - The board is updated to mark this cell as visited:
     ```
     # B C E
     S F C S
     A D E E
     ```
   - The method then recursively checks the adjacent cells.

4. **Move to (0, 1)**:
   - The method checks `(0, 1)` for the next letter `'B'`.
   - `dfs(board, word, 0, 1, 1)` is called with `currentLetter = 1`.
   - The character matches, and the board is updated:
     ```
     # # C E
     S F C S
     A D E E
     ```
   - The method then recursively checks adjacent cells.

5. **Move to (0, 2)**:
   - The method checks `(0, 2)` for the next letter `'C'`.
   - `dfs(board, word, 0, 2, 2)` is called with `currentLetter = 2`.
   - The character matches, and the board is updated:
     ```
     # # # E
     S F C S
     A D E E
     ```
   - The method then recursively checks adjacent cells.

6. **Move to (1, 2)**:
   - The method checks `(1, 2)` for the next letter `'C'`.
   - `dfs(board, word, 1, 2, 3)` is called with `currentLetter = 3`.
   - The character matches, and the board is updated:
     ```
     # # # E
     S F # S
     A D E E
     ```
   - The method then recursively checks adjacent cells.

7. **Move to (2, 2)**:
   - The method checks `(2, 2)` for the next letter `'E'`.
   - `dfs(board, word, 2, 2, 4)` is called with `currentLetter = 4`.
   - The character matches, and the board is updated:
     ```
     # # # E
     S F # S
     A D # E
     ```
   - The method then recursively checks adjacent cells.

8. **Move to (2, 1)**:
   - The method checks `(2, 1)` for the last letter `'D'`.
   - `dfs(board, word, 2, 1, 5)` is called with `currentLetter = 5`.
   - The character matches, and the board is updated:
     ```
     # # # E
     S F # S
     A # # E
     ```
   - Now, `currentLetter = 6` which equals the length of the word, so the method returns `true`.

9. **Backtracking and Return**:
   - As the method returns `true`, all recursive calls unwind, and the final result is `true`, indicating that the word `"ABCCED"` is found in the board.

### Summary of Recursion:

- The recursion explores one direction fully before backtracking when necessary.
- In this case, it found a successful path on the first try from the start at `(0, 0)`.
- The cells are temporarily marked as visited by replacing their values with `'#'`, ensuring that the same cell is not revisited within the same path.
- Once a match is found, the recursive calls unwind and return the final result.

### Visualization of Recursive Calls:
1. **Initial Call**:
   ```
   dfs(0, 0, 0) -> match 'A'
   ```
2. **Second Call**:
   ```
   dfs(0, 1, 1) -> match 'B'
   ```
3. **Third Call**:
   ```
   dfs(0, 2, 2) -> match 'C'
   ```
4. **Fourth Call**:
   ```
   dfs(1, 2, 3) -> match 'C'
   ```
5. **Fifth Call**:
   ```
   dfs(2, 2, 4) -> match 'E'
   ```
6. **Sixth Call**:
   ```
   dfs(2, 1, 5) -> match 'D'
   ```
7. **Final Result**:
   ```
   return true
   ```

This process shows how the depth-first search (DFS) explores possible paths in the grid to find the word.