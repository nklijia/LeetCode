package ValidBinarySearchTree;

import TreeNode.TreeNode;


public class Solution {
    public int current = Integer.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        current = Integer.MIN_VALUE;
        return ValidBST(root);
    }
    public boolean ValidBST(TreeNode root){
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root == null){
            return true;
        }
        if(ValidBST(root.left)==false){
            return false;
        }
        
        if(root.val<=current){
            return false;
        }else{
            current = root.val;
        }
        
        if(ValidBST(root.right)==false){
            return false;
        }
        
        return true;
        
    }
}
