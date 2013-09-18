package PathSum;

import java.util.LinkedList;

public class Solution {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
    public boolean hasPathSum(TreeNode root, int sum) {
        // Start typing your Java solution below
        // DO NOT write main() function
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        LinkedList<Integer> pathSum = new LinkedList<Integer>();
        if(root==null){
            return false;
        }
        queue.add(root);
        pathSum.add(root.val);
        while(queue.size()>0){
            TreeNode current = queue.pollFirst();
            int currentSum = pathSum.pollFirst();
            if(currentSum == sum){
                if(current.left==null && current.right==null){ // leaf node
                    return true;
                }
            }
            if(current.right!=null){
                int rightSum = currentSum + current.right.val;
                queue.addFirst(current.right);
                pathSum.addFirst(rightSum);
            }
            if(current.left!=null){
                int leftSum = currentSum + current.left.val;
                queue.addFirst(current.left);
                pathSum.addFirst(leftSum);
            }
        }
        return false;
    }
}