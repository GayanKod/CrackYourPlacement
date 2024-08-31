class Solution {
    public int maxArea(int[] height) {

        int start = 0;
        int end = height.length -1;
        int containerLength = height.length - 1;
        int maxArea = 0;
        
        while (start != end){
            int level = Math.min(height[start], height[end]);
            if (maxArea < level*containerLength) maxArea = level*containerLength;
            if (height[start] < height[end]){
                start++;
                containerLength--;
            }
            else{
                end--;
                containerLength--;
            }
        }

        return maxArea;
    }
}