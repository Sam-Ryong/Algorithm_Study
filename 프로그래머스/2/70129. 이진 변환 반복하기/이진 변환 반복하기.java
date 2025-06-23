import java.util.*;

class Solution {
    public int[] solution(String s) 
    {
        int transformCount = 0;
        int zeroCount = 0;
        
        while (true){
            
            String temp = s;
            s = binaryTransform(s);
            
            zeroCount += countZero(temp);
            transformCount++;
            
            if (s.equals("1"))
                break;
            
        }
        
        
        return new int[]{transformCount,zeroCount};
    }
    
    String binaryTransform(String s){
        int result = 0;
        for (char c : s.toCharArray()){
            if (c == '1'){
                result++;
            }
        }
        return Integer.toBinaryString(result);
    }
    
    Integer countZero(String s){
        int result = 0;
        for (char c : s.toCharArray()){
            if (c == '0'){
                result++;
            }
        }
        return result;
    }
}