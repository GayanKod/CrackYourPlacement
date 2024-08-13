class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        visited = '2'
        noOfLands = 0
        for i in range (len(grid)):
            for j in range (len(grid[i])):
                if (grid[i][j] == '1'):
                    noOfLands += 1
                    self.markIsland(grid, i, j, '1', visited)
        return noOfLands
    
    #BFS
    def markIsland(self, grid: List[List[str]], r, c, land, visited):
        if (r < 0 or c < 0 or r >= len(grid) or c >= len(grid[0]) or grid[r][c] != land):
            return
        grid[r][c] = visited
        self.markIsland(grid, r-1, c, land, visited)
        self.markIsland(grid, r+1, c, land, visited)
        self.markIsland(grid, r, c-1, land, visited)
        self.markIsland(grid, r, c+1, land, visited)
