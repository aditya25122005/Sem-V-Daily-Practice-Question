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
        return Solve(pre,in,0,pre.length-1,0,in.length-1);
    }
    public TreeNode Solve(int []pre, int []in,int plo,int phi,int ilo,int ihi){
        if(ilo>ihi || plo>phi){
            return null;
        }
        TreeNode root= new TreeNode(pre[plo]);
        int idx= search(in,ilo,ihi,root.val);
        int ne= idx-ilo; // net elements in left tree
        root.left= Solve(pre,in,plo+1,plo+ne,ilo,idx-1);
        root.right= Solve(pre,in,plo+ne+1, phi,idx+1,ihi);
        return root;
    }
    public static int search(int []in, int ilo, int ihi, int v){
        for(int i=ilo;i<=ihi;i++){
            if(in[i]==v) return i;
        }
        return -1;
    }
}