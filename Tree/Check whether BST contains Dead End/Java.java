class Solution {
    public static boolean isDeadEnd(Node root) {
        // We start checking from the root with an initial valid range (1, infinity)
        return checkDeadEnd(root, 1, Integer.MAX_VALUE);
    }
    
    // Helper function to recursively check for dead ends
    private static boolean checkDeadEnd(Node node, int minLimit, int maxLimit) {
        // Base case: If node is null, return false (no dead end in this path)
        if (node == null) {
            return false;
        }
        
        // If the current node's range has only one value left, it's a dead end
        if (minLimit == maxLimit) {
            return true;
        }
        
        // Recursively check the left and right subtrees
        // Left subtree: Values less than node's value, update the max limit
        // Right subtree: Values greater than node's value, update the min limit
        return checkDeadEnd(node.left, minLimit, node.data - 1) ||
               checkDeadEnd(node.right, node.data + 1, maxLimit);
    }
}