import java.util.*;
import java.lang.*;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        List<String> result = new ArrayList<>();
        
        dartResult = dartResult.replace("10","X");
        int before = 0;
        for (int i = 1; i < dartResult.length(); i++){
            if (dartResult.substring(i,i+1).equals("0")){
                result.add(dartResult.substring(before, i));
                before = i;
            }
            else if (dartResult.substring(i,i+1).equals("1")){
                result.add(dartResult.substring(before, i));
                before = i;
            }
            else if (dartResult.substring(i,i+1).equals("2")){
                result.add(dartResult.substring(before, i));
                before = i;
            }
            else if (dartResult.substring(i,i+1).equals("3")){
                result.add(dartResult.substring(before, i));
                before = i;
            }
            else if (dartResult.substring(i,i+1).equals("4")){
                result.add(dartResult.substring(before, i));
                before = i;
            }
            else if (dartResult.substring(i,i+1).equals("5")){
                result.add(dartResult.substring(before, i));
                before = i;
            }
            else if (dartResult.substring(i,i+1).equals("6")){
                result.add(dartResult.substring(before, i));
                before = i;
            }
            else if (dartResult.substring(i,i+1).equals("7")){
                result.add(dartResult.substring(before, i));
                before = i;
            }
            else if (dartResult.substring(i,i+1).equals("8")){
                result.add(dartResult.substring(before, i));
                before = i;
            }
            else if (dartResult.substring(i,i+1).equals("9")){
                result.add(dartResult.substring(before, i));
                before = i;
            }
            else if (dartResult.substring(i,i+1).equals("X")){
                result.add(dartResult.substring(before, i));
                before = i;
            }
        }
        
        result.add(dartResult.substring(before));
        
        int[] score = new int[result.size()];
        
        for (int i = 0; i < result.size(); i++){
            String s = result.get(i);
            
            Integer a = s.substring(0,1).equals("X") ? 10 : Integer.parseInt(s.substring(0,1));
            Integer b = 0;
            if (s.substring(1,2).equals("S"))
                b = 1;
            else if (s.substring(1,2).equals("D"))
                b = 2;
            else if (s.substring(1,2).equals("T"))
                b = 3;
            
            if (s.length() == 2){
                score[i] = (int) Math.pow(a,b);
            }
            else{
                if (s.substring(2,3).equals("#")){
                    score[i] = - (int) Math.pow(a,b);
                }
                else{
                    score[i] = (int) Math.pow(a,b) * 2;
                    if (i > 0)
                        score[i-1] = score[i-1] * 2;
                }
            }
            
        }
        
        for (int i = 0; i < result.size(); i++){
            answer += score[i];
        }
        
        return answer;
    }
}