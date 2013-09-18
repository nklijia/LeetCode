package SortedListToBinaryTree;


public class Solution {

	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; next = null; }
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public ListNode headNode;
	public TreeNode sortedListToBST(ListNode head) {
		// Start typing your Java solution below
		// DO NOT write main() function
		headNode = head;
		int length = 0;
		while(head!=null){
			head = head.next;
			length++;
		}
		return ListToBST(0,length-1);
	}

	public TreeNode ListToBST(int start, int end){
		if(start>end){
			return null;
		}
		int mid = (end-start)/2+start;
		TreeNode leftchild = ListToBST(start, mid-1);
		TreeNode current = new TreeNode(headNode.val);
		headNode = headNode.next;
		TreeNode rightchild = ListToBST(mid+1, end);
		current.left = leftchild;
		current.right = rightchild;
		return current;
	}
}