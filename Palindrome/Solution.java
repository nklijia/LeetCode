package Palindrome;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

//Palindrome Problem Part 1

public class Solution {
	public ArrayList<ArrayList<String>> candidate; // the result ArrayList
	public Solution(){
		candidate =  new ArrayList<ArrayList<String>>();;
	}
	// the class to store the small piece of palindrome
	public class Palindrome{	
	    public int start;
	    public int end;
	    public Palindrome(int s, int e){
	        this.start = s;
	        this.end = e;
	    }
	}
    public ArrayList<ArrayList<String>> partition(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	for(int i=0; i<candidate.size(); i++){
    		candidate.get(i).clear();
    	}
    	HashMap<Integer,ArrayList<Palindrome>> tablet = Find_All(s);
    	candidate.clear();
        if(s.length()>0){
        	candidate.add(new ArrayList<String>());
        	grow(candidate.get(0),0,tablet,s);
        }
        return candidate;
    }
    
    
    // Grow from the start the of string, when there are several choice
    // like "a","b","b" and "a","bb". it will generate branches
    public void grow(ArrayList<String> root, int next_Index, HashMap<Integer,ArrayList<Palindrome>> tablet,String s){
    	if(next_Index>=s.length()){
    		return;
    	}
    	ArrayList<Palindrome> tabs = tablet.get(next_Index);
    	for(int i=tabs.size()-1; i>0; i--){
    		ArrayList<String> branch = new ArrayList<String>(root);
    		branch.add(s.substring(tabs.get(i).start, tabs.get(i).end+1));
    		candidate.add(branch);
    		grow(branch,tabs.get(i).end+1,tablet,s);
    	}
    	root.add(s.substring(tabs.get(0).start, tabs.get(0).end+1));
    	grow(root,tabs.get(0).end+1,tablet,s);
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