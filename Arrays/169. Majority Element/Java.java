class Solution {
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }
}


//Another Solution but not efficient )(nlongn)

class Solution {
    public int majorityElement(int[] nums) {
        int length = nums.length;
        int c=0;

        if (length==0) return 0;
        if (length==1) return nums[0];

        Arrays.sort(nums);

        for(int i=0; i<length-1; i++){
            if (nums[i] == nums[i+1]){
                c = c+1;
            }else{
                c=0;
            }
            if (c >= length/2) return nums[i];
        }
        return 0;
    }
}