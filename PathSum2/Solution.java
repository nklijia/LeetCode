package PathSum2;

import java.util.ArrayList;

public class Solution {
	
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root==null){
            return new ArrayList<ArrayList<Integer>>();
        }
        ArrayList<ArrayList<Integer>> result = findPath(root, sum);
        if(result==null){
            return new ArrayList<ArrayList<Integer>>();
        }
        for(int i=0; i<result.size(); i++){
            ArrayList<Integer> item = result.get(i);
            for(int j=0; j<(item.size()+1)/2; j++){
                int temp = item.get(j);
                item.set(j, item.get(item.size()-1-j));
                item.set(item.size()-1-j,temp);
            }
        }
        return result;
        
    }
    
    public ArrayList<ArrayList<Integer>> findPath(TreeNode root, int sum) {
        if(root==null){
            return null;
        }
        ArrayList<ArrayList<Integer>> result = null;
        if(root.left==null && root.right==null){
           if(root.val == sum){
               result = new ArrayList<ArrayList<Integer>>();
               result.add(new ArrayList<Integer>());
               result.get(0).add(root.val);
               return result;
           }else{
               return null;
           } 
        }
        
        ArrayList<ArrayList<Integer>> leftResult = findPath(root.left, sum-root.val);
        ArrayList<ArrayList<Integer>> rightResult = findPath(root.right, sum-root.val);
        if(leftResult ==null && rightResult == null){
            return null;
        }else{
            result = new ArrayList<ArrayList<Integer>>();
            if(leftResult != null){
                for(int i=0; i<leftResult.size(); i++){
                    ArrayList<Integer> leftResultItem = leftResult.get(i);
                    leftResultItem.add(root.val);
                    result.add(leftResultItem);
                }
            }
            if(rightResult != null){
                for(int i=0; i<rightResult.size(); i++){
                    ArrayList<Integer> rightResultItem = rightResult.get(i);
                    rightResultItem.add(root.val);
                    result.add(rightResultItem);
                }
            }
            return result;
        }
    }
    
    public static void main(String[] args){
    	TreeNode node = new TreeNode(1);
    	Solution s = new Solution();
    	s.findPath(node, 0);
    }
}