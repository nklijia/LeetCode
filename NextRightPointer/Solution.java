package NextRightPointer;

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
	public class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;
		TreeLinkNode(int x) { val = x; }
	}
	public void connect(TreeLinkNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		TreeLinkNode begin = root;
		if(root!=null){
			root.next = null;
		}
		TreeLinkNode current = null;
		TreeLinkNode Niddle = null;
		while(begin!=null){
			current = begin;
			begin = null;
			do{
				if(current.left!=null){
					if(Niddle==null){
						begin = current.left;
						Niddle = current.left;
					}else{
						Niddle.next = current.left;
						Niddle =  Niddle.next;
					}
				}
				if(current.right!=null){
					if(Niddle==null){
						begin = current.right;
						Niddle = current.right;
					}
					else{
						Niddle.next = current.right;
						Niddle = Niddle.next;
					}
				}
				current = current.next;
			}while(current!=null);
			
			if(Niddle!=null){
				Niddle.next = null;
				Niddle = null;
			}
		}
	}
}