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
    public int[] findMode(TreeNode root) {
        HashMap<Integer,Integer> map= new HashMap<>();
        Solve(root,map);
        int ans=0;
        int max=0;
        for(int key: map.keySet()){
            if(map.get(key)>max){
                ans=key;
                max=map.get(key);
            }
        }
        List<Integer> ll=new ArrayList<>();
        for(int key: map.keySet()){
            if(map.get(key)==max){
                ll.add(key);
            }
        }
        int [] res= new int[ll.size()];
        for(int i=0;i<ll.size();i++){
            res[i]=ll.get(i);
        }
        return res;
    }
    public static void Solve(TreeNode root,HashMap<Integer,Integer> map ){
        if(root==null){
            return;
        }
        map.put(root.val,map.getOrDefault(root.val,0)+1);
        Solve(root.left,map);
        Solve(root.right,map);
    }
}