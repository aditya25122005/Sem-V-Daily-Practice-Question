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
    int ans=0;
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null) return 0;
        solve(root,(long)targetSum);
        pathSum(root.left,targetSum);
        pathSum(root.right,targetSum);
        return ans;
    }
    public void solve(TreeNode root, long target){
        if(root==null){
            return;
        }
        if(target==root.val){
            ans++;
        }
        solve(root.left,target-root.val);
        solve(root.right,target-root.val);


    }
}