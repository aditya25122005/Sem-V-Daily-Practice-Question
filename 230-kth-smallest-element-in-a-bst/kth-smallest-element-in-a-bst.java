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
    public int kthSmallest(TreeNode root, int k) {
        ans=0;
        Solve(root,k,new ArrayList<>());
        return ans;
    }
    static int ans;
    public static void Solve(TreeNode root, int k, List<Integer> ll){
        if(root==null){
            return; 
        }
        Solve(root.left,k,ll);
        ll.add(root.val);
        if(ll.size()==k){
            ans = ll.get(ll.size()-1);
            return;
        } 
        Solve(root.right,k,ll);
        
    }
}