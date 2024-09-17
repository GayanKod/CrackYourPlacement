class Solution {
    public static void findPreSuc(Node root, Node[] pre, Node[] suc, int key) {
        // Start by traversing the BST
        while (root != null) {
            if (root.data < key) {
                // This node could be the predecessor (as it's smaller than the key)
                pre[0] = root;
                root = root.right; // Move to the right subtree to find a closer predecessor
            } else if (root.data > key) {
                // This node could be the successor (as it's larger than the key)
                suc[0] = root;
                root = root.left; // Move to the left subtree to find a closer successor
            } else {
                // If the node is the key itself, check its left and right subtrees

                // Find the predecessor (rightmost node of the left subtree)
                if (root.left != null) {
                    Node temp = root.left;
                    while (temp.right != null) {
                        temp = temp.right;
                    }
                    pre[0] = temp; // The predecessor is the rightmost node in the left subtree
                }

                // Find the successor (leftmost node of the right subtree)
                if (root.right != null) {
                    Node temp = root.right;
                    while (temp.left != null) {
                        temp = temp.left;
                    }
                    suc[0] = temp; // The successor is the leftmost node in the right subtree
                }
                break; // Key found, no need to traverse further
            }
        }
    }
}
