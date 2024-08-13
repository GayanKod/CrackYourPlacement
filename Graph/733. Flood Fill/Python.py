class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        if (image[sr][sc] == color): return image
        
        self.fill(image, sr, sc, color, image[sr][sc])
        return image

    #Depth First Search (DFS)
    def fill(self, image: List[List[int]], sr: int, sc: int, color: int, oldColor: int):
        if (sr < 0 or sc < 0 or sc >= len(image[0]) or sr >= len(image) or image[sr][sc]!= oldColor):
            return
        
        image[sr][sc] = color
        self.fill(image, sr-1, sc, color, oldColor)
        self.fill(image, sr+1, sc, color, oldColor)
        self.fill(image, sr, sc-1, color, oldColor)
        self.fill(image, sr, sc+1, color, oldColor)

#Characteristics of DFS:

# 	•	Recursion: The algorithm is implemented using recursion, where the fill function calls itself for each of the neighboring pixels.
# 	•	Exploration: DFS explores as far as possible along each branch before backtracking, ensuring that all connected pixels of the same color are filled.

# Why DFS is Suitable for Flood Fill:

# 	•	Connectivity: The flood fill problem is about changing the color of a contiguous region of pixels that are connected (4-directionally) and have the same initial color.
# 	•	Recursive Nature: DFS naturally fits this problem since it can easily explore all connected pixels using recursion.


        