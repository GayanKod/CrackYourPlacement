//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = sc.nextInt();
            }
            Solution ob = new Solution();
            long[] ans = new long[n];
            ans = ob.productExceptSelf(array);

            for (int i = 0; i < n; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
            t--;
        }
    }
}

// } Driver Code Ends


// User function Template for Java

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
