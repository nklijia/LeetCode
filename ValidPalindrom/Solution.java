package ValidPalindrom;

public class Solution {
    public boolean isPalindrome(String s) {
        if(s==null){
        	return true;
        }
        s=s.toLowerCase();
        s=s.replaceAll("\\W", "");
        int length = s.length();
        for(int i=0; i<(length+1)/2; i++){
        	if(s.charAt(i)!=s.charAt(length-i-1)){
        		return false;
        	}
        }
        return true;
    }
    
    public static void main(String[] args){
    	Solution s = new Solution();
    	System.out.println(s.isPalindrome("A man, a plan, a canal: Panama"));
    }
}
