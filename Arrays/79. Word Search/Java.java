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