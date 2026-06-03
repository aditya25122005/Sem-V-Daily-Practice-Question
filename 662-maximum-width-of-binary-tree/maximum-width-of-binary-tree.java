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
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        int maxW = Integer.MIN_VALUE;
        q.add(new Pair(root,1));
        while(!q.isEmpty()){
            int size = q.size();
            int first = -1;
            int last = -1;

            for(int i=0;i<size;i++){

                Pair rm = q.poll();
                if(i==0){
                    first = rm.idx;
                }
                if(i==size-1){
                    last = rm.idx;
                }
                if(rm.root.left!=null){
                    q.add(new Pair(rm.root.left, rm.idx*2));
                }
                if(rm.root.right!=null){
                    q.add(new Pair(rm.root.right,rm.idx*2 +1));
                }

            }
            maxW = Math.max(maxW, last-first+1);
        }
        return maxW;

    }
    class Pair{
        TreeNode root;
        int idx;
        public Pair(TreeNode root,int idx){
            this.root = root;
            this.idx = idx;
        }
    }
}