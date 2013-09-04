package WordLadder2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Solution {
	HashMap<String,Integer> startDiscoveredLevel;
	HashMap<String,ArrayList<String>> startDiscoveredParent;
    HashMap<String,Integer> endDiscoveredLevel;
    HashMap<String,ArrayList<String>> endDiscoveredParent;
    LinkedList<String> startToExpand;
    LinkedList<String> endToExpand;
    ArrayList<ArrayList<String>> result;
    
    HashSet<String> resultPivot;
    
    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
    	startDiscoveredLevel = new HashMap<String,Integer>();
    	endDiscoveredLevel = new HashMap<String,Integer>();
    	startDiscoveredParent = new HashMap<String,ArrayList<String>>();
    	endDiscoveredParent = new HashMap<String,ArrayList<String>>();
    	
    	startToExpand = new LinkedList<String>();
    	endToExpand = new LinkedList<String>();
    	resultPivot = new HashSet<String>();
        
        
        startToExpand.add(start);
        startDiscoveredLevel.put(start, 0);
        startDiscoveredParent.put(start, null);
        
        endToExpand.add(end);
        endDiscoveredLevel.put(end, 0);
        endDiscoveredParent.put(end, null);
        
        int startPool = 1;
        int endPool = 1;
        
        
        while(startPool>0 || endPool>0){
	        if(startPool>0){
	        	int count = 0;
	        	for(int i=0; i<startPool; i++){
	        		String current = startToExpand.pollFirst();
	        		int currentLevel = startDiscoveredLevel.get(current);
	        		for(int j=0; j<current.length(); j++){
	        			StringBuilder sb = new StringBuilder();
	        			sb.append(current);
	        			for(int k='a'; k<='z'; k++){
	        				sb.setCharAt(j, (char) k);
	        				String temp = sb.toString();
	        				if(dict.contains(temp)){
	        					if(!startDiscoveredLevel.containsKey(temp)){
	        						count++;
	        						startToExpand.add(temp);
	        						startDiscoveredLevel.put(temp, currentLevel+1);
	        						ArrayList<String> parentList = new ArrayList<String>();
	        						parentList.add(current);
	        						startDiscoveredParent.put(temp, parentList);
	        						if(endDiscoveredLevel.containsKey(temp)){
	        							resultPivot.add(temp);
	        						}
	        					}else if(startDiscoveredLevel.get(temp)>currentLevel){
	        						startDiscoveredParent.get(temp).add(current);
	        					}
	        				}
	        			}
	        		}
	        	}
	        	startPool = count;
	        }
	       
	        if(resultPivot.size()>0){
	        	return GetResult();
	        }
	        
	        
	        if(endPool>0){
	        	int count = 0;
	        	for(int i=0; i<endPool; i++){
	        		String current = endToExpand.pollFirst();
	        		int currentLevel = endDiscoveredLevel.get(current);
	        		for(int j=0; j<current.length(); j++){
	        			StringBuilder sb = new StringBuilder();
	        			sb.append(current);
	        			for(int k='a'; k<='z'-'a'; k++){
	        				sb.setCharAt(j, (char) k);
	        				String temp = sb.toString();
	        				if(dict.contains(temp)){
	        					if(!endDiscoveredLevel.containsKey(temp)){
	        						count++;
	        						endToExpand.add(temp);
	        						endDiscoveredLevel.put(temp, currentLevel+1);
	        						ArrayList<String> parentList = new ArrayList<String>();
	        						parentList.add(current);
	        						endDiscoveredParent.put(temp, parentList);
	        						if(startDiscoveredLevel.containsKey(temp)){
	        							resultPivot.add(temp);
	        						}
	        					}else if(endDiscoveredLevel.get(temp)>currentLevel){
	        						endDiscoveredParent.get(temp).add(current);
	        					}
	        				}
	        			}
	        		}
	        	}
	        	endPool = count;
	        }
	        
	        if(resultPivot.size()>0){
	        	return GetResult();
	        }
	        
        }
        
        return new ArrayList<ArrayList<String>>();
        
    }
    
    public ArrayList<ArrayList<String>> GetResult(){
    	ArrayList<LinkedList<String>> result = new ArrayList<LinkedList<String>>();
    	for(String pivot : resultPivot){
    		LinkedList<String> temp = new LinkedList<String>();
    		temp.add(pivot);
    		ArrayList<LinkedList<String>> upperBranches = growUp(temp);
    		for(LinkedList<String> branch : upperBranches){
    			result.addAll(growDown(branch));
    		}
    	}
    	ArrayList<ArrayList<String>> arrays = new ArrayList<ArrayList<String>>();
    	for(LinkedList<String> item: result){
    		ArrayList<String> array = new ArrayList<String>();
    		array.addAll(item);
    		arrays.add(array);
    	}
    	return arrays;
    }
    
    public ArrayList<LinkedList<String>> growUp(LinkedList<String> current){
    	ArrayList<LinkedList<String>> result = new ArrayList<LinkedList<String>>();
    	String head = current.peekFirst();
    	ArrayList<String> parent = startDiscoveredParent.get(head);
    	if(parent == null){
    		result.add(current);
    		return result;
    	}else{
    		for(String item: parent){
    			LinkedList<String> branch = new LinkedList<String>();
    			branch.addAll(current);
    			branch.addFirst(item);
    			ArrayList<LinkedList<String>> branches = growUp(branch);
    			result.addAll(branches);
    		}
    		return result;
    	}
    }
    
    public ArrayList<LinkedList<String>> growDown(LinkedList<String> current){
    	ArrayList<LinkedList<String>> result = new ArrayList<LinkedList<String>>();
    	String tail = current.peekLast();
    	ArrayList<String> parent = endDiscoveredParent.get(tail);
    	if(parent == null){
    		result.add(current);
    		return result;
    	}else{
    		for(String item: parent){
    			LinkedList<String> branch = new LinkedList<String>();
    			branch.addAll(current);
    			branch.addLast(item);
    			ArrayList<LinkedList<String>> branches = growDown(branch);
    			result.addAll(branches);
    		}
    		return result;
    	}
    }
    
    
    public static void main(String [] args){
    	Solution solution = new Solution();
    	String start = "hot";
    	String end = "dog";
    	HashSet<String> dict = new HashSet<String>();
    	dict.add("hot");
    	dict.add("dog");
    	dict.add("hog");
    	dict.add("dot");
    	System.out.println(solution.findLadders(start, end, dict));
    }
}