class Solution {
    public boolean canJump(int[] nums) {
        
        int flag = nums.length -1;

        //let's find from last element can we reach the flag
        for (int i = flag-1; i>=0; i--){
            
            if (i + nums[i] >= flag){
                flag = i;
            }
        }

        if (flag==0) return true;
        else return false;
    }
}