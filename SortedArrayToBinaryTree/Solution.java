package SortedArrayToBinaryTree;

public class Solution {
	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
    public TreeNode sortedArrayToBST(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return ArrayToBST(num, 0, num.length-1);
    }
    
    public TreeNode ArrayToBST(int[] num, int start, int end){
        if(start>end){
			return null;
    	}
        int mid = (end-start+1)/2+start;
        TreeNode current = new TreeNode(num[mid]);
        current.left = ArrayToBST(num, start, mid-1);
        current.right = ArrayToBST(num, mid+1, end);
        return current;
    }
}