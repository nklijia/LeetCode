package Palindrome2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

//Palindrome Problem Part 2
//Dynamic Programming 

public class Solution {
	// the class to store the small piece of palindrome
	public class Palindrome{	
	    public int start;
	    public int end;
	    public Palindrome(int s, int e){
	        this.start = s;
	        this.end = e;
	    }
	}
    public int minCut(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	HashMap<Integer,ArrayList<Palindrome>> tablets = Find_All(s);
    	int size = s.length();
    	int[] optimal = new int[size+1];
    	for(int i=0; i<size+1; i++){
    		optimal[i] = Integer.MAX_VALUE;
    	}
    	optimal[size]=0;
    	for(int i=size-1; i>=0; i--){
    		ArrayList<Palindrome> tabs = tablets.get(i);
    		for(int j=0; j<tabs.size(); j++){
    			int step = optimal[tabs.get(j).end+1]+1;
    			if(optimal[i]>step){
    				optimal[i]=step;
    			}
    		}
    	}
    	return optimal[0]-1;
    	
    }
    
    // Find all pieces of palindrom and store them in HashMap, use the start index as key
    public HashMap<Integer,ArrayList<Palindrome>> Find_All(String s){
    	HashMap<Integer,ArrayList<Palindrome>> result = new HashMap<Integer,ArrayList<Palindrome>>();
    	LinkedList<Palindrome> queue = new LinkedList<Palindrome>();
        for(int i=0; i<s.length(); i++){
        	Palindrome temp = new Palindrome(i,i);
        	queue.add(temp);
            result.put(i, new ArrayList<Palindrome>());
            result.get(i).add(temp);
            if(i+1<s.length()){
            	if(s.charAt(i)==s.charAt(i+1)){
            		temp = new Palindrome(i,i+1);
            		queue.add(temp);
            		result.get(i).add(temp);
            	}
            }
        }
        int start=0;
        int end=0;
        while(queue.isEmpty()==false){
        	Palindrome current = queue.poll();
        	start = current.start-1;
        	end = current.end+1;
        	if(start>=0 && end<s.length()){
        		if(s.charAt(start)==s.charAt(end)){
        			Palindrome temp = new Palindrome(start,end);
        			queue.add(temp);
        			result.get(start).add(temp);
        		}
        	}
        }
        return result;
        
    }
}
