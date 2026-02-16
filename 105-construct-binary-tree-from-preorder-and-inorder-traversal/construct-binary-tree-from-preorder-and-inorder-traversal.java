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
    public TreeNode buildTree(int[] pre, int[] in) {
        return Solve(pre,0,pre.length-1, in,0, in.length-1);
    }
    public static TreeNode Solve(int [] pre ,int plo, int phi,int []in ,int ilo, int ihi){
        if(plo>phi || ilo>ihi){
            return null;
        }
        TreeNode nn= new TreeNode(pre[plo]);
        int idx= search(in, pre[plo],ilo,ihi);
        int ne = idx-ilo; // elements in left
        nn.left= Solve(pre, plo+1, plo+ne, in, ilo, idx-1);
        nn.right= Solve(pre,plo+ne+1 ,phi,in,idx+1,ihi);
        return nn;
    }
    public static int search(int[] in, int target,int ilo,int ihi){
        for(int i=ilo;i<=ihi;i++){
            if(in[i]==target){
                return i;
            }
        }
        return -1;
    }
}