public class Solution {
    public int RemoveDuplicates(int[] nums) {

        int temp = nums[0];
        int k = 1;

        for (int i =1; i<nums.Length; i++){
            if (temp != nums[i]){
                k++;
                temp = nums[i];

                nums[k-1] = nums[i];
            }
        }

        return k;
    }
}