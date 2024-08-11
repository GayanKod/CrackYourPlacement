public class Solution {
    public string LongestCommonPrefix(string[] strs) {
        StringBuilder ans = new StringBuilder();
        Array.Sort(strs);
        string first = strs[0];
        string last = strs[strs.Length - 1];

        for (int i = 0; i < Math.Min(first.Length, last.Length); i++) {
            if (first[i] != last[i]){ //Because of we sorted the string array, we only need to compare the first and last elements/words
                return ans.ToString();
            }
            ans.Append(first[i]);
        }

        return ans.ToString();
    }
}