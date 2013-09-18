package MinimumDepth;

import java.util.LinkedList;

public class Solution {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public int minDepth(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if(root==null){
			return 0;
		}
		LinkedList<TreeNode> currentLevel = new LinkedList<TreeNode>();
		LinkedList<TreeNode> nextLevel = new LinkedList<TreeNode>();
		nextLevel.add(root);
		int depth = 1;
		while(nextLevel.size()!=0){
			currentLevel = nextLevel;
			nextLevel = new LinkedList<TreeNode>();
			while(currentLevel.size()>0){
				TreeNode current = currentLevel.pollFirst();
				if(current.left == null && current.right==null){
					return depth;
				}else{
					if(current.left!=null){
						nextLevel.add(current.left);
					}
					if(current.right!=null){
						nextLevel.add(current.right);
					}
				}
			}
			depth++;
		}
		return depth-1;
	}
}