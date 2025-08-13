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
        return create(pre,in,0,in.length-1,0,pre.length-1);
    }
    public TreeNode create(int[] pre, int [] in, int ilo, int ihi,int plo, int phi){
        if(ilo>ihi || plo>phi){
            return null;
        }
        TreeNode root= new TreeNode(pre[plo]);
        int idx= search(in, ilo,ihi,pre[plo]);
        int ne=idx-ilo;
        root.left=create(pre,in,ilo,idx-1,plo+1,plo+ne);
        root.right=create(pre,in,idx+1,ihi,plo+ne+1,phi);
        return root;

    }
    public int search(int[] in, int si, int ei, int item){
        for(int i=si;i<=ei;i++){
            if(in[i]==item){
                return i;
            }
        }
        return -1;  //Not used ; written for compiler only
    }
}