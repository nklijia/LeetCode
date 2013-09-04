package PascalTriangle2;

import java.util.ArrayList;

public class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        rowIndex++;
        if (rowIndex>=1){
            result.add(1);
        }
        for(int i=2; i<=rowIndex; i++){
            result.add(1);
            for(int j=result.size()-2; j>0; j--){
                result.set(j,result.get(j)+result.get(j-1));
            }
        }
        return result;
    }
}