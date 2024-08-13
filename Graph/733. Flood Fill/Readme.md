# **Flood Fill Solution Explained**

[Go to the problem on Leetcode](https://leetcode.com/problems/flood-fill/)

### **Intuition**
Imagine you have a picture made up of small squares, each with a certain color. You want to change the color of a particular square and all the squares connected to it (up, down, left, right) that have the same color. This is like using a paint bucket tool in a drawing program, where you click on a spot, and it fills the entire area with a new color.

### **Approach**
1. **Check if Already Filled**: First, we check if the starting square (`sr`, `sc`) already has the target color. If it does, we don't need to do anything and can return the image as it is.
2. **Recursive Filling (Depth-First Search)**: If the square doesn't have the target color, we start "painting" from that square. We use a technique called Depth-First Search (DFS), where we:
   - Change the color of the current square to the new color.
   - Move to the neighboring squares (up, down, left, right) and do the same, but only if the neighbor has the original color.
3. **Continue Until Done**: This process continues until all connected squares with the original color are changed to the new color.

### **Complexity**

- **Time complexity**: The algorithm visits each square once, so the time it takes depends on the number of squares in the image. If there are `n` squares and `m` rows, the time complexity is **O(n * m)**.
- **Space complexity**: The space complexity is also **O(n * m)** in the worst case, due to the recursion stack used by the DFS.

### **Code**
```python
from typing import List

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        if (image[sr][sc] == color): return image
        
        self.fill(image, sr, sc, color, image[sr][sc])
        return image

    # Depth First Search (DFS)
    def fill(self, image: List[List[int]], sr: int, sc: int, color: int, oldColor: int):
        if (sr < 0 or sc < 0 or sc >= len(image[0]) or sr >= len(image) or image[sr][sc] != oldColor):
            return
        
        image[sr][sc] = color
        self.fill(image, sr-1, sc, color, oldColor)
        self.fill(image, sr+1, sc, color, oldColor)
        self.fill(image, sr, sc-1, color, oldColor)
        self.fill(image, sr, sc+1, color, oldColor)