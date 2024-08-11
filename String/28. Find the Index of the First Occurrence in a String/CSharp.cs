public class Solution{
    public int StrStr(string haystack, string needle){
        int hLen = haystack.Length;
        int nLen = needle.Length;
        int nIndex = 0;

        for (int i = 0; i < hLen; i++){
            // As long as the characters are equal, increment needleIndex
            if (haystack[i] == needle[nIndex]){
                nIndex++;
            }
            else{
                // Start from the next index of previous start index
                i = i - nIndex;
                // Needle should start from index 0
                nIndex = 0;
            }

            // Check if needleIndex reached needle length
            if (nIndex == nLen){
                // Return the first index
                return i - nLen + 1;
            }
        }
        return -1;
    }
}