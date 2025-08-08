import java.util.*;

class Solution {
    int[][] game;
    int[][] visit;
    public int solution(String[] board) {
        int answer = -1;
        game = new int[board.length][board[0].length()];
        visit = new int[board.length][board[0].length()];
        int[] start = new int[2];
        int[] end = new int[2];
        for (int i = 0; i < game.length; i++){
            for (int j = 0; j < game[0].length; j++){
                if (board[i].substring(j,j+1).equals("D"))
                    game[i][j] = 1;
                else if (board[i].substring(j,j+1).equals("R")){
                    start[0] = i;
                    start[1] = j;
                }
                else if (board[i].substring(j,j+1).equals("G")){
                    end[0] = i;
                    end[1] = j;
                }
            }
        }
        List<int[]> now = new ArrayList<>();
        List<int[]> temp = new ArrayList<>();
        now.add(start);
        int count = 0;
        while (now.size() > 0){
            boolean found = false;
            for (int[] xy : now){
                visit[xy[0]][xy[1]] = 1;
                if (xy[0] == end[0] && xy[1] == end[1]){
                    answer = count;
                    found = true;
                    break;
                }
                for (int i = 0; i < 4; i++){
                    int[] next = where(i,xy);
                    if (!(xy[0] == next[0] && xy[1] == next[1])){
                        if (visit[next[0]][next[1]] != 1)
                            temp.add(next);
                    }
                }
            }
            if (found)
                break;
            now.clear();
            now.addAll(temp);
            temp.clear();
            count++;
        }
        return answer;
    }
    
    int[] where(int direction, int[] prev){
        int[] now = new int[2];
        now[0] = prev[0];
        now[1] = prev[1];
        if (direction == 0){ // up
            while (now[0] > 0){
                if (game[now[0]-1][now[1]] == 1)
                    break;
                now[0]--;
            }
        }
        else if (direction == 1){ // down
            while (now[0] < game.length - 1){
                if (game[now[0]+1][now[1]] == 1)
                    break;
                now[0]++;
            }
        } 
        else if (direction == 2){ // left
            while (now[1] > 0){
                if (game[now[0]][now[1]-1] == 1)
                    break;
                now[1]--;
            }
        }
        else if (direction == 3){ // left
            while (now[1] < game[0].length - 1){
                if (game[now[0]][now[1] + 1] == 1)
                    break;
                now[1]++;
            }
        } 
        
        return now;
    }
}