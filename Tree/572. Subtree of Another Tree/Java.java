/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
    if (root == null) {
        return false;
    }

    if (root.val == subRoot.val) {
        boolean found = isEqual(root, subRoot);
        if (found) {
            return true;
        }
    }

    return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
}

private boolean isEqual(TreeNode node1, TreeNode node2) {
    if (node1 == null && node2 == null) {
        return true;
    }
    if (node1 == null || node2 == null) {
        return false;
    }
    if (node1.val != node2.val) {
        return false;
    }

    boolean isEqual = isEqual(node1.left, node2.left);
    if (!isEqual) {
        return false;
    }
    return isEqual(node1.right, node2.right);
}

}

//Another Answer but not efficient than above

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return preOrderTraversal(root).contains(preOrderTraversal(subRoot));
    }

    public String preOrderTraversal(TreeNode node){
        if (node == null) return "null";

        StringBuilder sb = new StringBuilder("-");
        sb.append(node.val);
        sb.append(preOrderTraversal(node.left));
        sb.append(preOrderTraversal(node.right));

        return sb.toString();
    }
}