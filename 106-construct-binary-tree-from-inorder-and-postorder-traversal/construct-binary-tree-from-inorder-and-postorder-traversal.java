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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }
    public TreeNode build(int[] in, int ilo, int ihi, int[] pos, int plo, int phi){
        if(ilo>ihi || plo>phi){
            return null;
        }
        TreeNode root= new TreeNode(pos[phi]);
        int idx=search(in,pos[phi],ilo,ihi);
        int ne= ihi-idx; // element in right subtree
        root.left=build(in,ilo,idx-1,pos,plo,plo+(idx-ilo-1));
        root.right=build(in,idx+1,ihi,pos,phi-ne,phi-1);
        return root;
    }
    public static int search(int[]in, int item , int si, int ei){
        for(int i=si;i<=ei;i++){
            if(in[i]==item){
                return i;
            }
        }
        return -1;
    }
}