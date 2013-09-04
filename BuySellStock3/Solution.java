package BuySellStock3;

public class Solution {
    public int maxProfit(int[] prices) {
    	int[] leftMax = new int[prices.length];
    	int[] rightMax = new int[prices.length];
    	int max = 0;
        int currentMax = 0;
        int diff = 0;
        for(int i=1; i<prices.length; i++){
        	diff = prices[i] - prices[i-1];
        	if(currentMax>0){
        		currentMax+=diff;
        	}else{
        		currentMax=diff;
        	}
        	if(currentMax>max){
        		max = currentMax;
        	}
        	leftMax[i] = max;
        }
        
        max = 0;
        currentMax = 0;
        for(int i=prices.length-2; i>0; i--){
        	diff = prices[i+1]-prices[i];
        	if(currentMax>0){
        		currentMax+=diff;
        	}else{
        		currentMax=diff;
        	}
        	if(currentMax>max){
        		max = currentMax;
        	}
        	rightMax[i] = max;
        }
        
        int maxSum = 0;
        for(int i=0; i<prices.length; i++){
        	if(leftMax[i]+rightMax[i]>maxSum){
        		maxSum = leftMax[i]+rightMax[i];
        	}
        }
        return maxSum;
    }
    
    public static void main(String[] args){
    	Solution s = new Solution();
    	int[] test = {1,2};
    	System.out.println(s.maxProfit(test));
    }
}
