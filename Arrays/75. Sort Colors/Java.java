class Solution {
    public void sortColors(int[] nums) {
        //3Pointer Solution
        int start = 0;
        int middle = 0;
        int end = nums.length-1;

        while (middle <= end){

            if (nums[middle] == 0){
                swap(start, middle, nums);
                start++;
                middle++;
            }
            else if (nums[middle] == 1){
                middle++;
            }
            else if (nums[middle] == 2){
                swap(middle, end, nums);
                end--;
            }
        }
    }

    public void swap(int one, int two, int[] nums){
        int t = nums[one];
        nums[one] = nums[two];
        nums[two] = t;
    }
}