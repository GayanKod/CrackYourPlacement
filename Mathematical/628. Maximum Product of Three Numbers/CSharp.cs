public class Solution {
    public int MaximumProduct(int[] nums) {
        if (nums.Length==3){
            return nums[0]*nums[1]*nums[2];
        }else{
            int n = nums.Length;
            Array.Sort(nums);
            int m1 = nums[n-1]*nums[n-2]*nums[n-3];
            int m2 = nums[0]*nums[1]*nums[n-1]; //If you can produce a max positive number that would be two minus numbers and maximum positive number
            if (m1>m2){
                return m1;
            }else{
                return m2;
            }
        }
    }
}