public class Solution {
    public string AddBinary(string a, string b) {
        StringBuilder result = new StringBuilder();
        int i = a.Length - 1;
        int j = b.Length - 1;
        int carry = 0;
        
        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;
            if (i >= 0) sum += a[i--] - '0';
            if (j >= 0) sum += b[j--] - '0';

            result.Append(sum % 2);
            carry = sum / 2;
        }
        
        // Reverse the result since we've been appending the digits in reverse order
        char[] charArray = result.ToString().ToCharArray();
        Array.Reverse(charArray);
        return new string(charArray);
    }
}

//Alternative one with Insert function, but it's bit inefficient
public class Solution {
    public string AddBinary(string a, string b) {
        StringBuilder result = new StringBuilder();
        int i = a.Length - 1;
        int j = b.Length - 1;
        int carry = 0;
        
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) sum += a[i--] - '0';
            if (j >= 0) sum += b[j--] - '0';
            //- '0': This converts the character at a[i] (which is '0' or '1') into its integer equivalent. In C#, the character '0' has an ASCII value of 48, and '1' has an ASCII value of 49. By subtracting '0', you get the integer 0 or 1 corresponding to the binary digit.
            result.Insert(0, sum % 2); 
            //result.Insert(IndexOfPlacetoInsert, Value)
            carry = sum / 2;
        }
 
        if (carry > 0) {
            result.Insert(0, carry);
        }
        
        return result.ToString();
    }
}