class Solution {
    public String intToRoman(int num) {
        // Define arrays of Roman numerals and their corresponding values
        String[] romanSymbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        // Initialize an empty StringBuilder to store the resulting Roman numeral
        StringBuilder result = new StringBuilder();

        // Loop through each Roman numeral, starting with the largest
        for (int i = 0; i < values.length; i++) {
            // While the current value can be subtracted from num
            while (num >= values[i]) {
                // Subtract the value from num
                num -= values[i];
                // Append the corresponding Roman numeral to the result
                result.append(romanSymbols[i]);
            }
        }
        
        // Convert the StringBuilder to a string and return the result
        return result.toString();
    }
}