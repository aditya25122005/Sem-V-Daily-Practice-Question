
class Solution {

    public TreeNode balanceBST(TreeNode root) {
        List<TreeNode> ll= new ArrayList<>();
        convert(root,ll);
        return Solve( 0,  ll.size()-1,ll);

    }

    public static TreeNode Solve(int i, int j,List<TreeNode> ll){
        if(i>j){
            return null;
        }
        int mid = (i+j)/2;
        TreeNode nn = new TreeNode(ll.get(mid).val);
        nn.left = Solve(i,mid-1,ll);
        nn.right = Solve(mid+1,j,ll);

        return nn;
    }

    public static void convert(TreeNode root, List<TreeNode> ll){
        if(root==null){
            return;
        }
        
        convert(root.left,ll);
        ll.add(root);
        convert(root.right,ll);
    }
}