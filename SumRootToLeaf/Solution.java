package SumRootToLeaf;

import java.util.LinkedList;

public class Solution {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public int sumNumbers(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if(root==null){
			return 0;
		}
		LinkedList<TreeNode> waitingNode = new LinkedList<TreeNode>();
		LinkedList<Integer> waitingNumber = new LinkedList<Integer>();
		waitingNode.add(root);
		waitingNumber.add(root.val);
		int sum = 0;
		while(waitingNode.size()>0){
			TreeNode currentNode = waitingNode.poll();
			int currentNumber = waitingNumber.poll();
			if(currentNode.left!=null){
				waitingNode.add(currentNode.left);
				waitingNumber.add(currentNumber*10+currentNode.left.val);
			}
			if(currentNode.right!=null){
				waitingNode.add(currentNode.right);
				waitingNumber.add(currentNumber*10+currentNode.right.val);
			}
			if(currentNode.left==null && currentNode.right==null){
				sum+=currentNumber;
			}
		}
		return sum;
		
	}
}