## Valid Palindrome II

[Go to the problem on Leetcode](https://leetcode.com/problems/valid-palindrome-ii)

### Intuition
A palindrome is a string that reads the same backward as forward. The problem asks if you can make a given string a palindrome by removing at most one character. This means that even if the string is not a palindrome initially, you may be able to make it one by skipping a single mismatched character.

### Approach
1. **Two Pointers Technique**:
   - Use two pointers: one starting at the beginning (`left`) and the other at the end (`right`) of the string.
   - Move both pointers towards the center, comparing characters at these positions.

2. **Check for Mismatch**:
   - If the characters at the `left` and `right` pointers are the same, continue moving inward.
   - If the characters do not match, it means that the string is not currently a palindrome. However, you still have the option to remove one character.

3. **Two Possibilities**:
   - At the point of mismatch, you have two choices: remove the character at the `left` pointer or the character at the `right` pointer.
   - To check if removing one of these characters results in a palindrome, use a helper function (`IsPalindrome`) to verify if the substring formed after removing one character is a palindrome.

4. **Final Check**:
   - If no mismatches are found, or if removing one character makes the string a palindrome, return `true`.
   - If neither option results in a palindrome, return `false`.

### Complexity
- **Time complexity**: `O(N)`  
  The algorithm checks each character in the string, so the time complexity is linear in terms of the length of the string `N`.
  
- **Space complexity**: `O(1)`  
  The space complexity is constant because we only use a few variables to keep track of the pointers and perform the checks.

### Code

```csharp
public class Solution {
    public bool ValidPalindrome(string s) {
        int left = 0;
        int right = s.Length - 1;
        
        while (left < right) {
            if (s[left] != s[right]) {
                // Check the two possibilities: removing one character from either end
                return IsPalindrome(s, left + 1, right) || IsPalindrome(s, left, right - 1);
            }
            left++;
            right--;
        }
        
        return true;
    }
    
    private bool IsPalindrome(string s, int left, int right) {
        while (left < right) {
            if (s[left] != s[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}