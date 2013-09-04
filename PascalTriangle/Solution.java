package PascalTriangle;

import java.util.ArrayList;

public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(numRows>=1){
        	ArrayList<Integer> root = new ArrayList<Integer>();
        	root.add(1);
        	result.add(root);
        }
        for(int i=2; i<=numRows; i++){
        	ArrayList<Integer> previous = result.get(result.size()-1);
        	ArrayList<Integer> current = new ArrayList<Integer>();
        	current.add(1);
        	for(int j=1; j<i-1; j++){
        		current.add(previous.get(j-1)+previous.get(j));
        	}
        	current.add(1);
        	result.add(current);
        }
        return result;
    }
}