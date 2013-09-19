package SameTree;
import TreeNode.TreeNode;
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(p==null || q==null){
           if(p==null && q==null){
               return true;
           }else{
               return false;
           }
        }
        if(p.val != q.val){
            return false;
        }
        return(isSameTree(p.left,q.left) & isSameTree(p.right, q.right));
    }
}