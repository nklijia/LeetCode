package MaxPathSum;


public class Solution {


	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public int max;

	public int maxPathSum(TreeNode root) {
		max = Integer.MIN_VALUE;
		search(root);
		return max;
	}
	
	public int search(TreeNode node){
		if(node==null){
			return 0;
		}
		int left = search(node.left);
		int right = search(node.right);
		
		int partLength = node.val;
		int totalLength = node.val;
		
		if(left>0){
			totalLength+=left;
		}
		if(right>0){
			totalLength+=right;
		}
		
		if(left>=right && left>0){
			partLength+=left;
		}else if(left<right && right>0){
			partLength+=right;
		}
		
		if(totalLength>max){
			max = totalLength;
		}
		
		return partLength;
		
	}
}
