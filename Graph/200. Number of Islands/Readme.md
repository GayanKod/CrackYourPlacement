## **200. Number of Islands**

[Go to the problem on Leetcode](https://leetcode.com/problems/number-of-islands/)

### **Intuition**
Imagine you have a map of land and water, where land is represented by `1` and water by `0`. The goal is to count how many separate pieces of land (islands) are present. An island is formed by land cells connected vertically or horizontally (but not diagonally). This problem is like finding clusters of land in the map.

### **Approach**
1. **Initialize Variables**: 
   - We start by initializing a variable `noOfLands` to zero, which will store the count of islands.
   - We also use a marker `visited` (in this case, `'2'`) to keep track of the cells we've already checked.

2. **Traverse the Grid**:
   - We iterate through each cell in the grid.
   - Whenever we encounter a cell that contains land (`'1'`), it indicates we've found a new island.
   - We increment the `noOfLands` count and then proceed to mark all the connected land cells (forming the island) as visited by calling the `markIsland` method.

3. **Mark the Island (Depth-First Search - DFS)**:
   - The `markIsland` method is a recursive function that checks all neighboring cells (up, down, left, right).
   - If a neighboring cell is part of the island (i.e., it contains `'1'`), it marks it as visited and continues to check its neighbors, effectively marking the entire island.

4. **Return the Count**:
   - After traversing the entire grid and marking all islands, the `noOfLands` will contain the total number of separate islands in the grid.

### **Complexity**

- **Time complexity**: The algorithm visits each cell in the grid exactly once, so the time complexity is **O(n * m)**, where `n` is the number of rows and `m` is the number of columns in the grid.

- **Space complexity**: The space complexity is also **O(n * m)** in the worst case due to the recursion stack used by the DFS.

### **Code**
```python
from typing import List

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        visited = '2'
        noOfLands = 0
        for i in range(len(grid)):
            for j in range(len(grid[i])):
                if grid[i][j] == '1':
                    noOfLands += 1
                    self.markIsland(grid, i, j, '1', visited)
        return noOfLands
    
    # Depth First Search (DFS)
    def markIsland(self, grid: List[List[str]], r, c, land, visited):
        if r < 0 or c < 0 or r >= len(grid) or c >= len(grid[0]) or grid[r][c] != land:
            return
        grid[r][c] = visited
        self.markIsland(grid, r-1, c, land, visited)
        self.markIsland(grid, r+1, c, land, visited)
        self.markIsland(grid, r, c-1, land, visited)
        self.markIsland(grid, r, c+1, land, visited)