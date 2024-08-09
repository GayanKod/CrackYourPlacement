public class Solution {
    public int FindDuplicate(int[] nums) {
        
        //To solve with O(n) and space complexity only a constant 
        //We have to udr Floyd’s Tortoise and Hare (Cycle Detection) Algorithm

        int tortoise = nums[0];
        int hare = nums[0];

        // We have to find intersection point of in the cycle where identify the cycle
        do {
            tortoise = nums[tortoise]; //one step - slow
            hare = nums[nums[hare]]; //one step ahead - fast
        } while (tortoise != hare);
    
        // Phase 2: Finding the entrance of the cycle (the duplicate number)
        tortoise = nums[0];
        while (tortoise != hare) {
            tortoise = nums[tortoise];
            hare = nums[hare];
        }
    
        return hare; // Return the duplicate number

    }
}