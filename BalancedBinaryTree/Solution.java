package BalancedBinaryTree;


public class Solution {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
    boolean balanced;
    public boolean isBalanced(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        balanced = true;
        getDepth(root);
        return balanced;
    }
    
    public int getDepth(TreeNode current){
        if(current==null){
            return 0;
        }else{
            int leftDepth = getDepth(current.left);
            int rightDepth = getDepth(current.right);
            if(Math.abs(leftDepth-rightDepth)>=2){
                balanced = false;
            }
            if(leftDepth>=rightDepth){
                return leftDepth+1;
            }else{
                return rightDepth+1;
            }
        }
    }
}