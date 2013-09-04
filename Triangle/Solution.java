package Triangle;

import java.util.ArrayList;

public class Solution {
	int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		ArrayList<Integer> previous = null;
		ArrayList<Integer> current = null;
		for(int i=0; i<triangle.size();i++){
			current = new ArrayList<Integer>();
			current.addAll(triangle.get(i));
			if(previous==null){
				previous = current;
				continue;
			}else{
				current.set(0, current.get(0)+previous.get(0));
				current.set(current.size()-1, current.get(current.size()-1)+previous.get(current.size()-2));
				for(int j=1; j<current.size()-1; j++){
					int distance = 0;
					if(previous.get(j-1)<previous.get(j)){
						distance = previous.get(j-1);
					}else{
						distance = previous.get(j);
					}
					current.set(j, current.get(j)+distance);
				}
				previous.clear();
				previous = current;
			}
		}
		int min = Integer.MAX_VALUE;
		for(int i=0; i<previous.size(); i++){
			if(previous.get(i)<min){
				min=previous.get(i);
			}
		}
		return min;
	}
	
	public static void main(String[] args){
		Solution s = new Solution();
		ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> level0 = new ArrayList<Integer>();
		level0.add(1);
		ArrayList<Integer> level1 = new ArrayList<Integer>();
		level1.add(2);
		level1.add(3);
		triangle.add(level0);
		triangle.add(level1);
		System.out.println(s.minimumTotal(triangle));
	}
}
