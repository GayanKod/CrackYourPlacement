class Solution {
    public boolean backspaceCompare(String s, String t) {
        
        s = write(s);
        t = write(t);

        return s.equals(t);

    }

    String write(String s){
        StringBuilder result = new StringBuilder();

        for(int i=0; i<s.length(); i++){

            if (s.charAt(i) == '#'){
                if (result.length() > 0) {
                    // Remove the last character from the result
                    result.deleteCharAt(result.length() - 1);
                }
            }else{
                result.append(s.charAt(i));
            }

        }

        return result.toString();
    }
}