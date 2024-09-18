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