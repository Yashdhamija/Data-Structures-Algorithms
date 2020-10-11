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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root;
        
        TreeNode sentinel = new TreeNode(Integer.MIN_VALUE);
        sentinel.left = root;
        
        TreeNode[] nodes = search(root, key);
        TreeNode parent = nodes[0];
        TreeNode delete = nodes[1];
             
        if (delete == null) return root; // not present
        if (parent == null) parent = sentinel;
        
        if (delete.left == null || delete.right == null) {
            TreeNode replacement = null;
            if (delete.left != null) replacement = delete.left;
            else if (delete.right != null) replacement = delete.right;
            
            if (parent.left == delete) parent.left = replacement;
            else parent.right = replacement;
        } else {
            TreeNode replacement = predecessor(delete.left);
            delete.val = replacement.val;
            if (delete.left == replacement) {
                delete.left = delete.left.left;
            }
        }

        return sentinel.left;
    }
    
    private TreeNode[] search(TreeNode root, int val) {
        if (root == null) return null; // not required in context
        TreeNode prev = null;
        while (root != null && root.val != val) {
            prev = root;
            if (root.val > val)
                root = root.left;
            else
                root = root.right;  
        }
        return new TreeNode[] {prev, root};
    }
    
    private TreeNode predecessor(TreeNode root) {
        if (root == null) return null; // not required in context
        TreeNode parent = null;
        while (root.right != null) {
            parent = root;
            root = root.right;
        } 
        if (parent != null)
            parent.right = root.left;   
        
        return root;
    }
}
