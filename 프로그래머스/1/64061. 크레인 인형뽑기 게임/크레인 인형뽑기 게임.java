import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        Stack<Integer>[] machine = new Stack[board[0].length];
        Stack<Integer> basket = new Stack<>();
        
        for (int i = 0; i < machine.length; i++){
            machine[i] = new Stack<Integer>();
        }
        
        for (int i = board.length - 1; i >= 0; i--){
            for (int j = 0; j < board[0].length; j++){
                if (board[i][j] != 0){
                    machine[j].push(board[i][j]);
                }
            }
        }
        
        for (int move : moves){
            if (machine[move-1].isEmpty())
                continue;
            
            int doll = machine[move-1].pop();
            
            if (!basket.isEmpty() && basket.peek() == doll){
                basket.pop();
                answer += 2;
            }
            else{
                basket.push(doll);
            }
        }
        
        return answer;
    }
}