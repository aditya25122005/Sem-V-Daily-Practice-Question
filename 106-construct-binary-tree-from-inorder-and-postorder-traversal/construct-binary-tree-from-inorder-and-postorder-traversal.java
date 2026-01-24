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
    public TreeNode buildTree(int[] in, int[] post) {
        return Solve(in,post,0,in.length-1,0,post.length-1);
    }
    public static TreeNode Solve(int []in, int [] post, int ilo, int ihi, int plo, int phi){
        if(ilo>ihi || plo>phi){
            return null;
        }
        TreeNode root= new TreeNode(post[phi]);
        int idx=search(in, ilo, ihi, root.val);
        int ne=ihi-idx; // net element in right subtree
        root.right= Solve(in,post,idx+1,ihi,phi-ne,phi-1);
        root.left= Solve(in,post,ilo,idx-1,plo,phi-ne-1);
        return root;
    }
    public static int search(int[] in, int ilo, int ihi, int v)
    {
        for(int i=ilo;i<=ihi;i++)
        {
            if(in[i]==v)
            {
                return i;
            }
        }
        return -1;
    }
}