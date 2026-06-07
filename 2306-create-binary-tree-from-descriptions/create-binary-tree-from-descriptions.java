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
    public TreeNode createBinaryTree(int[][] desc) {
        HashMap<Integer,TreeNode> map = new HashMap<>();
        HashSet<Integer> childs = new HashSet<>();
        for(int[] A : desc){
            int parent = A[0];
            int child = A[1];
            int status = A[2];
            childs.add(child);
            TreeNode parentNode=null;
            TreeNode childNode = null;
            if(!map.containsKey(parent)){
                TreeNode nn = new TreeNode(parent);
                map.put(parent,nn);
                parentNode = nn;
            }
            else{
                parentNode = map.get(parent);
            }
            if(!map.containsKey(child)){
                TreeNode nn = new TreeNode(child);
                map.put(child,nn);
                childNode = nn;
            }
            else{
                childNode = map.get(child);
            }
            if(status==1){
                parentNode.left = childNode;
            }
            else{
                parentNode.right = childNode;
            }
        }
        for(int key: map.keySet()){
            if(!childs.contains(key)){
                return map.get(key);
            }
        }
        return null;
        
    }
    // class TreeNode{
    //     int val;
    //     TreeNode left;
    //     TreeNode right;
    //     TreeNode(int val) { this.val = val; }
    //     public TreeNode(int val, TreeNode left, TreeNode right){
    //         this.val = val;
    //         this.left = left;
    //         this.right =  right;
    //     }
    // }
}