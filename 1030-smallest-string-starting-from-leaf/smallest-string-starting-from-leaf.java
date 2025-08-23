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
    String small="~";  // something greater than z
    public String smallestFromLeaf(TreeNode root) {
        if(root==null){
            return "";
        }
        solve(root,"");
        return small;
    }
    public void solve(TreeNode root, String curr){
        if(root==null) return;
        char ch= (char)('a'+root.val);
        curr=ch+curr;

        if(root.left==null && root.right==null){// reached leaf node
            if(curr.compareTo(small)<0){ 
                small=curr;
            }
        }

        solve(root.left,curr);
        solve(root.right,curr);
    }
}