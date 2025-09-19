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
        if(root==null){
            return null;
        }
        if(root.val>key){
            root.left=deleteNode(root.left,key);
        }
        else if(root.val<key){
            root.right=deleteNode(root.right,key);
        }
        else{
            //root is key
            if(root.left==null){
                return root.right;
            }
            else if(root.right==null){
                return root.left;
            }
            else{// Both childs are there
                int minnv=find(root.right);
                root.right=deleteNode(root.right,minnv); // Remove the min from right subtree
                root.val=minnv; // place the val in root
            }
        }
        return root;
    }
    public int find(TreeNode root){
        if(root==null){
            return Integer.MAX_VALUE;
        }
        int val=find(root.left);
        val=Math.min(val,root.val);
        return val;
    }
}