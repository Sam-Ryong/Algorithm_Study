import java.util.*;

class Solution {
    public String solution(String new_id) {
        String answer = "";
        // 1단계
        new_id = new_id.toLowerCase();

        //2단계 a: 97, z : 122, 0 : 48, 9 : 57
        for (int i = 0; i < new_id.length(); i++){
            if (new_id.charAt(i) >= 97 && new_id.charAt(i) <= 122){
                answer += new_id.charAt(i);
            }
            else if (new_id.charAt(i) >= 48 && new_id.charAt(i) <= 57){
                answer += new_id.charAt(i);
            }
            else if (new_id.charAt(i) == '-' || new_id.charAt(i) == '_' || new_id.charAt(i) == '.'){
                answer += new_id.charAt(i);
            }
        }

        //3단계
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < answer.length(); i++){
            if (stack.isEmpty()){
                stack.push(answer.substring(i,i+1));
            }
            else{
                if (stack.peek().equals(".") && answer.substring(i,i+1).equals(".")){
                    continue;
                }
                else{
                    stack.push(answer.substring(i,i+1));
                }
            }
        }

        
        //4단계
        answer = "";
        while (!stack.isEmpty()){
            answer += stack.pop();
        }
        if (answer.length() > 1){
             if (answer.charAt(0) == '.'){
                answer = answer.substring(1, answer.length());
            }
            if (answer.charAt(answer.length() - 1) == '.'){
                answer = answer.substring(0, answer.length() -1);
            }
        }
        else{
            if (answer.charAt(0) == '.'){
                answer = "";
            }
        }

        //5단계
        if (answer.length() == 0){
            answer = "a";
        }

        //6단계
        if (answer.length() >= 16){
            answer = answer.substring(answer.length() - 15, answer.length());
            if (answer.charAt(0) == '.')
                answer = answer.substring(1,answer.length());
        }
        
        //7단계
        if (answer.length() <= 2){
            while (answer.length() < 3){
                answer = answer.charAt(0) + answer;
            }
        }
        
        String temp = "";
        for (int i = 0; i < answer.length(); i++){
            temp += answer.charAt(answer.length() - i - 1);
        }
       
        return temp;
    }
}