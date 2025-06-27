import java.util.*;

class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        

        while (true){
            int before = countBlank(m,n,board);
            disappear(m, n, board);
            for (int i = 0; i < m; i++){
                down(m,n,board);
            }
            int after = countBlank(m,n,board);
            if (before == after)
                break;
        }
        
        
  
        
        return countBlank(m,n,board);
    }
    
    int countBlank(int m, int n, String[] board){
         
        int result = 0;
        
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){    
                if (board[i].charAt(j) == ' '){
                    result++;
                }
            }
        }
        
        return result;
    }
    
    void down(int m, int n, String[] board){
        
        for (int i = 1; i < m; i++){
            String s1 = "";
            String s2 = "";
            for (int j = 0; j < n; j++){
                if (board[i].charAt(j) == ' '){
                    s1 += " ";
                    s2 += board[i-1].charAt(j);
                }
                else{
                    s1 += board[i-1].charAt(j);
                    s2 += board[i].charAt(j);
                }            
            }
            board[i-1] = s1;
            board[i] = s2;
        }
        
    }
    
    void disappear(int m, int n, String[] board){
        
        List<Integer[]> temp = new ArrayList<>();
        
        for (int i = 0; i < m - 1; i++){
            for (int j = 0; j < n - 1; j++){
                
                char a = board[i].charAt(j);
                char b = board[i].charAt(j+1);
                char c = board[i+1].charAt(j);
                char d = board[i+1].charAt(j+1);
                
                if (a == b && b == c && c == d){
                    Integer[] point = new Integer[2];
                    point[0] = i;
                    point[1] = j;
                    temp.add(point);
                }
                       
            }
        }
        
        for (Integer[] point : temp){
            int i = point[0];
            int j = point[1];
            
            String s1 = "";
            String s2 = "";
            
            for (int k = 0; k < n; k++){
                if (k == j || k == j + 1)
                    s1 += " ";
                else
                    s1 += board[i].charAt(k);
            }
            
            for (int k = 0; k < n; k++){
                if (k == j || k == j + 1)
                    s2 += " ";
                else
                    s2 += board[i+1].charAt(k);
            }
            
            board[i] = s1;
            board[i+1] = s2;
            
        }
        
    }
    
    
}