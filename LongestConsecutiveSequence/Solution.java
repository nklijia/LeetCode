package LongestConsecutiveSequence;

import java.util.HashSet;

public class Solution {
	public int longestConsecutive(int[] num) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int max = 0;
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i=0; i<num.length; i++){
			set.add(num[i]);
		}
		while(set.size()>max){
			int bot = set.iterator().next();
			int top = bot;
			int count=1;
			set.remove(bot);
			while(set.contains(bot-1)){
				set.remove(bot-1);
				bot = bot-1;
				count++;
			}
			while(set.contains(top+1)){
				set.remove(top+1);
				top = top+1;
				count++;
			}
			if(count>max){
				max = count;
			}
		}
		return max;
	}
}
