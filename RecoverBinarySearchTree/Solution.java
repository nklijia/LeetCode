package RecoverBinarySearchTree;

import java.util.ArrayList;

import TreeNode.TreeNode;

public class Solution {
    public TreeNode before;
    public ArrayList<TreeNode> trouble;
    public int pivot;
    public void recoverTree(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        before = null;
        pivot = Integer.MIN_VALUE;
        trouble = new ArrayList<TreeNode>();
        DFS(root);
        if(trouble.size()>0){
            int temp = trouble.get(0).val;
            trouble.get(0).val = trouble.get(trouble.size()-1).val;
            trouble.get(trouble.size()-1).val = temp;
        }
    }
    
    public void DFS(TreeNode current){
        if(current==null){
            return;
        }
        DFS(current.left);
        if(current.val<pivot){
            trouble.add(before);
            trouble.add(current);
        }
        pivot= current.val;
        before=current;
        DFS(current.right);
    }
    
    public static void main(String[] args){
    	TreeNode child = new TreeNode(1);
    	TreeNode root = new TreeNode(0);
    	root.left = child;
    	Solution s = new Solution();
    	s.recoverTree(root);
    	System.out.println(root.val);
    }
}