public class Solution {
    public bool IsValid(string s) {
        //create a new empty stack
        Stack<char> stack = new Stack<char>();

        foreach (char c in s.ToCharArray()){
            if (c == '(')
                stack.Push(')');
            else if (c == '[')
                stack.Push(']');
            else if (c == '{')
                stack.Push('}');
            else if (stack.Count == 0 || stack.Pop() != c)
                return false;
            // stack.isEmpty means there are no opening brackets in the string, or the stack is empty.
            // stack.pop checks whether the closing bracket matches the current c   
        }
        return stack.Count == 0;
        //Here why we return stack.isEmpty() 
        //Because if the stack is empty, that means all opening brackets matched with their corresponding closing brackets
        //Otherwise sometimes, there are some unmatched opening brackets , so then return false
    }
}