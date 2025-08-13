import java.lang.*;
import java.util.*;

class Solution {
    public long solution(String expression) {
        long answer = 0;

        List<String> queue = new ArrayList<>();


        int p = 0;
        for (int i = 0; i < expression.length(); i++){
            if (Character.isDigit(expression.charAt(i)))
                continue;
            else{
                queue.add(expression.substring(p,i));
                queue.add(expression.substring(i,i+1));
                p = i + 1;
            }
        }
        queue.add(expression.substring(p));
        
        
        
        String[] priority = new String[]{"*+-","*-+","-*+","-+*","+*-","+-*"};
        
        for (String pr : priority){
            
            List<String> queue1 = new ArrayList<>();
            List<String> temp = new ArrayList<>();
            
            queue1.addAll(queue);
            String op1 = pr.substring(0,1);
            String op2 = pr.substring(1,2);
            String op3 = pr.substring(2,3);
            
            for (int j = 0; j < queue1.size(); j++){
                if (queue1.get(j).equals(op1)){
                    long a = Long.parseLong(temp.get(temp.size()-1));
                    long b = Long.parseLong(queue1.get(j+1));
                    j = j + 1;
                    temp.remove(temp.size()-1);
                    if (op1.equals("*"))
                        temp.add(String.valueOf(a*b));
                    else if (op1.equals("-"))
                        temp.add(String.valueOf(a-b));
                    else if (op1.equals("+"))
                        temp.add(String.valueOf(a+b));    
                }
                else{
                    temp.add(queue1.get(j));
                }

            }
            queue1.clear();
            queue1.addAll(temp);
            temp.clear();
            
            for (int j = 0; j < queue1.size(); j++){
                if (queue1.get(j).equals(op2)){
                    long a = Long.parseLong(temp.get(temp.size()-1));
                    long b = Long.parseLong(queue1.get(j+1));
                    j = j + 1;
                    temp.remove(temp.size()-1);
                    if (op2.equals("*"))
                        temp.add(String.valueOf(a*b));
                    else if (op2.equals("-"))
                        temp.add(String.valueOf(a-b));
                    else if (op2.equals("+"))
                        temp.add(String.valueOf(a+b));    
                }
                else{
                    temp.add(queue1.get(j));
                }
            }
            queue1.clear();
            queue1.addAll(temp);
            temp.clear();
            
            for (int j = 0; j < queue1.size(); j++){
                if (queue1.get(j).equals(op3)){
                    long a = Long.parseLong(temp.get(temp.size()-1));
                    long b = Long.parseLong(queue1.get(j+1));
                    j = j + 1;
                    temp.remove(temp.size()-1);
                    if (op3.equals("*"))
                        temp.add(String.valueOf(a*b));
                    else if (op3.equals("-"))
                        temp.add(String.valueOf(a-b));
                    else if (op3.equals("+"))
                        temp.add(String.valueOf(a+b));    
                }
                else{
                    temp.add(queue1.get(j));
                }
            }
            
            answer = Math.max(Math.abs(Long.parseLong(temp.get(0))),answer);
        
            
        }
        
        
        return answer;
    }
}