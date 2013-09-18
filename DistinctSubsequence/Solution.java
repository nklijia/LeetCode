package DistinctSubsequence;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
    public int numDistinct(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if(T==null || S==null){
    		return 0;
    	}
    	if(T.length()==0 || S.length()==0){
    		return 0;
    	}
        int patternLength = T.length();
        
        HashMap<Character, ArrayList<Integer>> posMap = new HashMap<Character, ArrayList<Integer>>();
        for(int i=patternLength-1; i>=0; i--){
        	if(posMap.containsKey(T.charAt(i))){
        		posMap.get(T.charAt(i)).add(i);
        	}else{
        		ArrayList<Integer> temp = new ArrayList<Integer>();
        		temp.add(i);
        		posMap.put(T.charAt(i), temp);
        	}
        }
        
        int count[] = new int[patternLength];
        for(int i=0; i<patternLength; i++){
        	count[i] = 0;
        }
        
        for(int i=0; i<S.length(); i++){
        	if(posMap.containsKey(S.charAt(i))){
        		ArrayList<Integer> pos = posMap.get(S.charAt(i));
        		for(int j=0; j<pos.size(); j++){
        			int index = pos.get(j);
        			if(index>0){
        				count[index]=count[index] + count[index-1];
        			}else if(index==0){
        				count[0]++;
        			}
        		}
        	}
        }
        
        
        return count[patternLength-1];
    }
    
    public static void main(String[] args){
    	Solution s = new Solution();
    	s.numDistinct("CCC", "C");
    }
}