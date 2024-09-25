# 71. **Simplify Path**

## Problem Description

You are given a string representing an absolute path for a file or directory in a Unix-style file system. You need to simplify this path and return the canonical path.

In Unix-style file systems:
- `/` is the root directory.
- A single dot `.` refers to the current directory.
- A double dot `..` moves up to the parent directory.
- Multiple slashes `//` are treated as a single slash `/`.

The goal is to return the shortest equivalent path.

---

## **Intuition**

The task is to simplify the given path by following Unix-style navigation rules. The idea is to process each part of the path:
- Skip the parts that refer to the current directory (`.`).
- Go back to the parent directory when we encounter `..`.
- Ignore extra slashes (`//`).
  
We can use a **stack** to help with this. When we move into a directory, we push it onto the stack. When we encounter `..`, we pop the top of the stack (if it's not empty), which means going back to the parent directory.

---

## **Approach**

1. **Split the path**: First, we split the input path using `/` as the delimiter. This gives us the individual directory names (or special symbols like `.` and `..`).

2. **Stack for directory navigation**: We use a stack to keep track of directories:
   - If we encounter a directory name (i.e., a valid directory), we push it onto the stack.
   - If we encounter `..`, we pop the stack (if it's not empty), which means going up to the parent directory.
   - If we encounter `.` or an empty string (which happens due to multiple slashes), we ignore it.

3. **Rebuild the path**: After processing all parts of the path, the stack contains the valid directory names in order. We join them together with `/` to form the simplified path.

4. **Edge Cases**: 
   - If the stack is empty after processing, return `/`, as it represents the root directory.

---

## **Complexity**

- **Time Complexity**: O(n), where `n` is the length of the path string. We process each character in the path exactly once (for splitting, stacking, and rebuilding the result).
  
- **Space Complexity**: O(n), because we use extra space to store the parts of the path in a stack.

---

### **Time complexity:**
O(n) - We traverse the entire path string once and perform stack operations in constant time.

---

### **Space complexity:**
O(n) - The space used by the stack can go up to the length of the path in the worst case.

---

## **Code**

```java
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
```

---

## **Explanation of the Code:**

1. **Splitting the Path**: We use `path.split("/")` to break the path into components using `/` as a delimiter. For example, for the path `/a/b/../c/`, this will give us `["", "a", "b", "..", "c", ""]`.

2. **Stack Operations**: 
   - We push valid directory names onto the stack.
   - We pop from the stack if we encounter `..`, which means we are moving to the parent directory.
   - We ignore empty strings or `.` since they do not affect the path.

3. **Rebuilding the Path**: After processing, we join the valid directory names from the stack to form the simplified path. Each valid directory in the stack is appended with a `/` to create the correct structure.

4. **Returning the Result**: If the stack is empty, we return `/`, which means the path is the root directory. Otherwise, we return the rebuilt path.

---