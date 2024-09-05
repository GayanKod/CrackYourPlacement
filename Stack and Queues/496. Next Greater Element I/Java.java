
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        // Stack to store elements and map to store next greater element for each element in nums2
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        int[] out = new int[nums1.length];

        // Traverse nums2 from right to left
        for (int i = nums2.length - 1; i >= 0; i--) {
            int num = nums2[i];

            // Maintain stack where top of the stack is the next greater element
            while (!stack.isEmpty() && stack.peek() <= num) {
                stack.pop();  // Pop elements smaller than or equal to current number
            }

            // If stack is empty, no greater element; otherwise, the top is the next greater element
            if (stack.isEmpty()) {
                map.put(num, -1);
            } else {
                map.put(num, stack.peek());
            }

            // Push the current element onto the stack
            stack.push(num);
        }

        // Now, for each element in nums1, look up its next greater element in the map
        for (int i = 0; i < nums1.length; i++) {
            out[i] = map.get(nums1[i]);
        }

        return out;
    }
}