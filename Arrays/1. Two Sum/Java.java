//Best Solution
class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

        for (int i=0; i<nums.length; i++){
            if (hm.containsKey(target - nums[i])){
                return new int[] {i, hm.get(target - nums[i])};
            }else{
                hm.put(nums[i], i);
            }
        }
        return new int[] {};
    }
}

//Solution 2 less efficient
class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        int[] out = new int[2];

        for (int i=0; i<nums.length; i++){
            for (int j = i+1; j<nums.length; j++){
                if (nums[i] + nums[j] == target){
                    out[0] = i;
                    out[1] = j;
                    return out;
                }
            }
        }
        return out;
    }
}