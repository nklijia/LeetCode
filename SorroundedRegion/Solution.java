package SorroundedRegion;

import java.util.LinkedList;

public class Solution {
	public class Pair{
		public int x;
		public int y;
		public Pair(int i, int j){
			x = i;
			y = j;
		}
	}
    public void solve(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function

        LinkedList<Pair> list = new LinkedList<Pair>();
        if(board.length<=1){
        	return;
        }
        
        int height = board.length;
        int width = board[0].length;
        for(int j=0; j<width; j++){
        	if(board[0][j]=='O'){
        		board[0][j] = 'R';
        		list.add(new Pair(0,j));
        	}
        	if(board[height-1][j]=='O'){
        		board[height-1][j] = 'R';
        		list.add(new Pair(height-1,j));
        	}
        }
        
        for(int i=1; i<height-1; i++){
        	if(board[i][0]=='O'){
        		board[i][0] = 'R';
        		list.add(new Pair(i,0));
        	}
        	if(board[i][width-1]=='O'){
        		board[i][width-1] = 'R';
        		list.add(new Pair(i,width-1));
        	}
        }
        
        while(list.size()>0){
    		Pair pos = list.pollLast();
    		int x = pos.x;
    		int y = pos.y;
    		if(x-1>=0 && board[x-1][y]=='O'){
    			board[x-1][y] = 'R';
    			list.add(new Pair(x-1, y));
    		}
    		
    		if(y-1>=0 && board[x][y-1]=='O'){
    			board[x][y-1] = 'R';
    			list.add(new Pair(x,y-1));
    		}
    		
    		if(x+1<height && board[x+1][y]=='O'){
    			board[x+1][y] = 'R';
    			list.add(new Pair(x+1,y));
    		}
    		
    		if(y+1<width && board[x][y+1]=='O'){
    			board[x][y+1] = 'R';
    			list.add(new Pair(x,y+1));
    		}
    	}
        
        for(int i=0; i<height; i++){
        	for(int j=0; j<width; j++){
        		if(board[i][j]=='O'){
        			board[i][j] = 'X';
        		}
        		if(board[i][j]=='R'){
        			board[i][j] = 'O';
        		}
        	}
        }
    }
}