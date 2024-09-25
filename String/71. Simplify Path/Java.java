class Solution {
    public String simplifyPath(String path) {
        // Split the input path by "/" and use a stack to store valid directory names
        Stack<String> stack = new Stack<>();
        
        // Split the path by "/" and process each part
        String[] parts = path.split("/");
        
        for (String part : parts) {
            if (part.equals("") || part.equals(".")) {
                // Ignore empty parts or the current directory symbol "."
                continue;
            } else if (part.equals("..")) {
                // ".." means go back to the parent directory, so pop from the stack if not empty
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                // A valid directory name, push it to the stack
                stack.push(part);
            }
        }
        
        // Rebuild the simplified path from the stack
        StringBuilder result = new StringBuilder();
        
        for (String dir : stack) {
            result.append("/").append(dir);
        }
        
        // If the result is empty, that means the path is the root "/"
        return result.length() > 0 ? result.toString() : "/";
    }
}