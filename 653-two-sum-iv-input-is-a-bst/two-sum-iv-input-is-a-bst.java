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
    int K;
    public boolean findTarget(TreeNode root, int k) {
        K=k;
        HashMap<Integer,Integer> map = new HashMap<>();
        return Solve(root,map);

    }
    public boolean Solve(TreeNode root, HashMap<Integer,Integer> map){
        if(root==null){
            return false;
        }
        int curr = root.val;
        int target = K-curr;
        if(map.containsKey(target)){
            return true;
        }
        map.put(root.val,1);
        boolean A = Solve(root.left,map);
        boolean B =  Solve(root.right,map);

        return A || B;
    }
}