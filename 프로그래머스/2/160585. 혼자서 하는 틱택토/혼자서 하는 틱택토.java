class Solution {
    String[] board;
    int answer = 0;
    public int solution(String[] b) {
        
        board = b;
        
        String[] init = new String[3];
        for (int i = 0; i < 3; i++){
            init[i] = "...";
        }
        
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                dfs("O", i, j, init);     
            }
        }
        
        return answer;
    }
    
    public void dfs(String turn, int r, int c, String[] now){
        
        if (answer == 1)
            return;
        
        if (checkSame(now)){
            answer = 1;
            return;
        }
        
        if (checkEnd(now)){

            return;
        }
        
        if (!now[r].substring(c,c+1).equals("."))
            return;
        
        String[] temp = now.clone();
        
        temp[r] = temp[r].substring(0,c) + turn + temp[r].substring(c+1);
        if (turn.equals("X"))
            turn = "O";
        else
            turn = "X";
        
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                dfs(turn, i, j, temp);
                
            }
        }
        
    }
    
    public boolean checkSame(String[] now){
        
        boolean result = true;
        for (int i = 0; i < now.length; i++){
            if (!now[i].equals(board[i])){
                result = false;
                break;
            }
        }
        return result;   
    }
    
    public boolean checkEnd(String[] now){
        
        boolean result = false;
        for (int i = 0; i < now.length; i++){
            if (now[i].equals("XXX") || now[i].equals("OOO")){
                return true;
            }    
        }
        for (int i = 0; i < now.length; i++){
            if (now[0].substring(i,i+1).equals(now[1].substring(i,i+1)) && now[1].substring(i,i+1).equals(now[2].substring(i,i+1))){
                if (!now[0].substring(i,i+1).equals("."))
                    return true;
            }
        }
        if (now[0].substring(0,1).equals(now[1].substring(1,2)) && now[1].substring(1,2).equals(now[2].substring(2,3)))
            if (!now[0].substring(0,1).equals("."))
                return true;
        if (now[0].substring(2,3).equals(now[1].substring(1,2)) && now[1].substring(1,2).equals(now[2].substring(0,1)))
            if (!now[0].substring(2,3).equals("."))
                return true;
        
        return result;   
    }
}