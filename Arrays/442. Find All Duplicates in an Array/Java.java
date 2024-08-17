class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        
        List<Integer> out = new ArrayList<Integer>();

        for (int i=0; i<nums.length; i++){                     
            if (nums[Math.abs(nums[i])-1] < 0){
                out.add(Math.abs(nums[i]));
            }else if (nums[Math.abs(nums[i])-1] > 0){
                nums[Math.abs(nums[i])-1] = nums[Math.abs(nums[i])-1]*-1;
            }  
        }

        return out;
    }
}

//solution 02 But used extra space
public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        // Create a HashSet to store seen elements
        Set<Integer> seen = new HashSet<>();
        // Create a List to store duplicates
        List<Integer> duplicates = new ArrayList<>();
        
        // Iterate through the array
        for (int num : nums) {
            // Check if the number is already in the set
            if (!seen.add(num)) {
                // If adding to the set returns false, the number is a duplicate
                duplicates.add(num);
            }
        }
        
        // Return the list of duplicates
        return duplicates;
    }
}