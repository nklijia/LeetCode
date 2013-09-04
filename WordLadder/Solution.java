package WordLadder;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Solution {
	HashMap<String,Integer> startDiscovered;
    HashMap<String,Integer> endDiscovered;
    LinkedList<String> startToExpand;
    LinkedList<String> endToExpand;
    public int ladderLength(String start, String end, HashSet<String> dict) {
    	startDiscovered = new HashMap<String,Integer>();
    	endDiscovered = new HashMap<String,Integer>();
    	startToExpand = new LinkedList<String>();
    	endToExpand = new LinkedList<String>();
        
        
        startToExpand.add(start);
        startDiscovered.put(start, 0);
        
        endToExpand.add(end);
        endDiscovered.put(end, 0);
        
        int startPool = 1;
        int endPool = 1;
        
        while(startPool>0 || endPool>0){
	        if(startPool>0){
	        	int count = 0;
	        	for(int i=0; i<startPool; i++){
	        		String current = startToExpand.pollFirst();
	        		int currentLevel = startDiscovered.get(current);
	        		for(int j=0; j<current.length(); j++){
	        			StringBuilder sb = new StringBuilder();
	        			sb.append(current);
	        			for(int k='a'; k<='z'; k++){
	        				sb.setCharAt(j, (char) k);
	        				String temp = sb.toString();
	        				if(dict.contains(temp)){
	        					if(!startDiscovered.containsKey(temp)){
	        						count++;
	        						startToExpand.add(temp);
	        						startDiscovered.put(temp, currentLevel+1);
	        						if(endDiscovered.containsKey(temp)){
	        							return startDiscovered.get(temp)+endDiscovered.get(temp)+1;
	        						}
	        					}
	        				}
	        			}
	        		}
	        	}
	        	startPool = count;
	        }
	        
	        
	        if(endPool>0){
	        	int count = 0;
	        	for(int i=0; i<endPool; i++){
	        		String current = endToExpand.pollFirst();
	        		int currentLevel = endDiscovered.get(current);
	        		for(int j=0; j<current.length(); j++){
	        			StringBuilder sb = new StringBuilder();
	        			sb.append(current);
	        			for(int k='a'; k<='z'; k++){
	        				sb.setCharAt(j, (char) k);
	        				String temp = sb.toString();
	        				if(dict.contains(temp)){
	        					if(!endDiscovered.containsKey(temp)){
	        						count++;
	        						endToExpand.add(temp);
	        						endDiscovered.put(temp, currentLevel+1);
	        						if(startDiscovered.containsKey(temp)){
	        							return startDiscovered.get(temp)+endDiscovered.get(temp)+1;
	        						}
	        					}
	        				}
	        			}
	        		}
	        	}
	        	endPool = count;
	        }
        }
        
        return 0;
    }
    
    public static void main(String [] args){
    	Solution solution = new Solution();
    	String start = "a";
    	String end = "c";
    	HashSet<String> dict = new HashSet<String>();
    	dict.add("a");
    	dict.add("b");
    	dict.add("c");
    	System.out.println(solution.ladderLength(start, end, dict));
    }
}