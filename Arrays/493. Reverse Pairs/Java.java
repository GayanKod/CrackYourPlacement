class Solution {
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        
        return mergeSortAndCount(nums, 0, nums.length - 1);
    }
    
    private int mergeSortAndCount(int[] nums, int start, int end) {
        if (start >= end) {
            return 0;
        }
        
        int mid = (start + end) / 2;
        int count = mergeSortAndCount(nums, start, mid) + mergeSortAndCount(nums, mid + 1, end);
        
        // Count reverse pairs
        int j = mid + 1;
        for (int i = start; i <= mid; i++) {
            while (j <= end && nums[i] > 2L * nums[j]) {
                j++;
            }
            count += (j - (mid + 1)); // Count the number of valid j's
        }
        
        // Merge the two halves
        int[] temp = new int[end - start + 1];
        int left = start, right = mid + 1, k = 0;
        
        while (left <= mid && right <= end) {
            if (nums[left] <= nums[right]) {
                temp[k++] = nums[left++];
            } else {
                temp[k++] = nums[right++];
            }
        }
        
        while (left <= mid) {
            temp[k++] = nums[left++];
        }
        
        while (right <= end) {
            temp[k++] = nums[right++];
        }
        
        // Copy sorted elements back to the original array
        for (int i = 0; i < temp.length; i++) {
            nums[start + i] = temp[i];
        }
        
        return count;
    }
}