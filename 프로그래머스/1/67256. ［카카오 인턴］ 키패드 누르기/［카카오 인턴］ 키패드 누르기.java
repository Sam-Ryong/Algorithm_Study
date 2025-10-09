import java.lang.*;
import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        
        Map<Integer, Integer[]> buttons = new HashMap<>();
        
        buttons.put(1, new Integer[] {0,0});
        buttons.put(2, new Integer[] {0,1});
        buttons.put(3, new Integer[] {0,2});
        buttons.put(4, new Integer[] {1,0});
        buttons.put(5, new Integer[] {1,1});
        buttons.put(6, new Integer[] {1,2});
        buttons.put(7, new Integer[] {2,0});
        buttons.put(8, new Integer[] {2,1});
        buttons.put(9, new Integer[] {2,2});
        buttons.put(0, new Integer[] {3,1});
        buttons.put(-1, new Integer[] {3,0}); //*
        buttons.put(-2, new Integer[] {3,2}); //#
        Integer[] left = buttons.get(-1);
        Integer[] right = buttons.get(-2);
        
        for (int n : numbers){
            
            Integer[] now = buttons.get(n);
            
            if (n == 1 || n == 4 || n == 7){
                answer += "L";
                left = now;
                continue;
            }
            else if (n == 3 || n == 6 || n == 9){
                answer += "R";
                right = now;
                continue;
            }
            
            int leftD = distance(now, left);
            int rightD = distance(now, right);
            
            if (leftD == rightD){
                if (hand.equals("right")){
                    answer += "R";
                    right = now;
                }
                else{
                    answer += "L";
                    left = now;
                }
            }
            else{
                if (rightD > leftD){
                    answer += "L";
                    left = now;
                }
                else{
                    answer += "R";
                    right = now;
                }
            }
            
        }
        
        
        return answer;
    }
    
    int distance(Integer[] a, Integer[] b){
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}