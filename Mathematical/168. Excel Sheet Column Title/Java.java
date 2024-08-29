class Solution {
    public String convertToTitle(int columnNumber) {
        
        StringBuilder output = new StringBuilder();

        while (columnNumber > 0){
            int index = (columnNumber - 1)%26;
            output.insert(0, (char)('A' + index));
            columnNumber = (columnNumber-1)/26;
        }

        return output.toString();

    }
}