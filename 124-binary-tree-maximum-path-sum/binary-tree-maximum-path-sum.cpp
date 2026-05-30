/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    int maxSum;
    int maxPathSum(TreeNode* root) {
        maxSum = INT_MIN;
        Solve(root);
        return maxSum;
    }
    int Solve(TreeNode* root){
        if(root==nullptr){
            return 0;
        }
        int left = Solve(root->left);
        int right = Solve(root->right);
        int curr = root->val + max(0,left)+ max(0,right);
        maxSum = max(maxSum,curr);

        return max(0,max(left,right))+ root->val;
    }
};