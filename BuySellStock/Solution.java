package BuySellStock;

public class Solution {
    public int maxProfit(int[] prices) {
       int max = 0;
       int currentMax = Integer.MIN_VALUE;
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
       }
       return max;
    }
}