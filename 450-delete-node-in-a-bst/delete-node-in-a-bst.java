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
            return root;
        }

        if(key<root.val){
            root.left= deleteNode(root.left,key);
        }
        else if(key>root.val){
            root.right= deleteNode(root.right,key);
        }
        else{// root hi key hai
            if(root.left==null){
                return root.right;
            }
            if(root.right==null){
                return root.left;
            }
            // Both childs are there
            int maxV=findMax(root.left);
            root.left= deleteNode(root.left,maxV);
            root.val=maxV;
            // int minV= findMin(root.right);
            // root.right= deleteNode(root.right,minV);
            // root.val=minV;
        }
        return root;
    }
    public static int findMax(TreeNode root){
        if(root==null){
            return Integer.MIN_VALUE;
        }
        int value=findMax(root.right);
        value=Math.max(value,root.val);
        return value;
    }
    public static int findMin(TreeNode root){
        if(root==null){
            return Integer.MAX_VALUE;
        }
        int value= findMin(root.left);
        value=Math.min(value,root.val);
        return value;
    }
}