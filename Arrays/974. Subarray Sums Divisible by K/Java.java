class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int c = 0;
        
        // Initialize with 0 remainder case (important for counting subarrays that start from index 0)
        map.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int rem = sum % k;

            // Handle negative remainders
            if (rem < 0) rem += k;

            // Check if this remainder has been seen before
            if (map.containsKey(rem)) {
                c += map.get(rem);  // Add the count of this remainder to the result
            }
            
            // Update the map with the current remainder's count
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }

        return c;
    }
}