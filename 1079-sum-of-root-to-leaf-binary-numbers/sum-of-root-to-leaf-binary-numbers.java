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
    public int sumRootToLeaf(TreeNode root) {
        sum=0;
        List<Integer> ll= new ArrayList<>();
        Solve(root,ll);
        return sum;
    }
   static int sum=0;
    public static void Solve(TreeNode root, List<Integer> ll){
        if(root==null){
            return;
        }
        ll.add(root.val);
        if(root.left==null && root.right==null){
            sum+= eval(ll);
        }
        else{
            Solve(root.left,ll);
            Solve(root.right,ll);
        }
        ll.remove(ll.size()-1);

    }
    public static int eval(List<Integer> arr){
        int p= arr.size()-1;
        int sum=0;
        for(int i=0;i<arr.size();i++){
            
            sum+= ((int)Math.pow(2,p) * arr.get(i));
            p--;
         }
         return sum;
    }

}