package FlattenBinaryTree;

import java.util.LinkedList;

import SumRootToLeaf.Solution.TreeNode;

public class Solution {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public void flatten(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode parent = null;
        queue.add(root);
        while(queue.size()>0){
            TreeNode current = queue.pollFirst();
            if(parent!=null){
                parent.right = current;
            }
            parent = current;
            if(current.right!=null){
                queue.addFirst(current.right);
                current.right = null;
            }
            if(current.left!=null){
                queue.addFirst(current.left);
                current.left = null;
            }
        }
    }
}
