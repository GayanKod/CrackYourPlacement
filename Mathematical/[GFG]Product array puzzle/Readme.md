# **Product Array Puzzle**

## **Intuition**

Given an array, the task is to create a new array where each element at index `i` is the product of all the elements in the original array except the one at `i`. This problem can be solved by considering the products of elements to the left and right of each index, without including the element itself.

## **Approach**

1. **Create Two Arrays:**
   - **Left Array:** Stores the cumulative product of all elements to the left of index `i`.
   - **Right Array:** Stores the cumulative product of all elements to the right of index `i`.

2. **Compute Left Products:**
   - Initialize the first element of the `left` array as 1 because there are no elements to the left of the first element.
   - For each index `i`, multiply the `left[i-1]` with the element at index `i-1` of the original array to get the left product.

3. **Compute Right Products:**
   - Initialize the last element of the `right` array as 1 because there are no elements to the right of the last element.
   - For each index `i` from the end of the array to the beginning, multiply the `right[i+1]` with the element at index `i+1` of the original array to get the right product.

4. **Construct the Result Array:**
   - For each index `i`, the product at index `i` in the result array is obtained by multiplying `left[i]` and `right[i]`.

5. **Return the Result:**
   - The result array now contains the product of all elements except the one at index `i`.

## **Complexity**

- **Time Complexity:** `O(n)` where `n` is the number of elements in the array. We make three passes through the array to calculate the left products, right products, and the final result.
  
- **Space Complexity:** `O(n)` for storing the `left` and `right` arrays, and the result array.

## **Code**

```java
class Solution {
    public static long[] productExceptSelf(int nums[]) {
         int size = nums.length; 
        long[] product_array = new long[size];
        
        // Initialize the first element of 'product_array' to 1
        product_array[0] = 1;
        
        // Calculate left products for each element
        for (int i = 1; i < size; ++i) {
            product_array[i] = product_array[i - 1] * nums[i - 1];
        }
        
        long right_product = 1;  // Initialize the right product
        
        // Calculate right products for each element and multiply with the left product
        for (int i = size - 1; i >= 0; --i) {
            product_array[i] *= right_product;
            right_product *= nums[i];
        }
        
        return product_array;
    }
}