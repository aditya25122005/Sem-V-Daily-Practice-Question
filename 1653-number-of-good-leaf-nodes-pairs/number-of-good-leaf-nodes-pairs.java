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
    int count=0; // Global variable that will store count
    public int countPairs(TreeNode root, int distance) {
        solve(root,distance);
        return count;
    }
    public List<Integer> solve(TreeNode root, int distance){
        List<Integer> ll= new ArrayList<>();
        if(root==null) return new ArrayList<>();
        if(root.left==null && root.right==null){
            ll.add(1);
            return ll;
        }
        List<Integer> left= solve(root.left,distance);
        List<Integer> right= solve(root.right,distance);
        for(int l:left){
            for(int r:right){
                if(l+r<=distance) count++;
            }
        }
        List<Integer> res= new ArrayList<>();
        for(int l:left){
            if(l+1<=distance) res.add(l+1);
        }
        for(int r:right){
            if(r+1<=distance) res.add(r+1);
        }
        return res;
    }
}