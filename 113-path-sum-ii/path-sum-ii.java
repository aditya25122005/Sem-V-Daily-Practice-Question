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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> ll= new ArrayList<>();
        Solve(root,0,targetSum,ans,ll);
        return ans;
    }
    public static void Solve(TreeNode root, int curr, int target, List<List<Integer>> ans, List<Integer> ll){
        if(root==null){
            return;
        }

        curr+= root.val;
        ll.add(root.val);
        if(root.left==null && root.right==null){
            if(curr==target){
                ans.add(new ArrayList<>(ll));
            }
            ll.remove(ll.size()-1);
            return;
        }

        Solve(root.left,curr,target,ans,ll);
        Solve(root.right,curr,target,ans,ll);
        ll.remove(ll.size()-1);
    }
}