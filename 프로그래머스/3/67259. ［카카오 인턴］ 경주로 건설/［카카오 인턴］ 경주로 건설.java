import java.lang.*;

public class Solution {

    int answer = Integer.MAX_VALUE;
    int[][] boards;
    int[][][] visit;
    
	public int solution(int[][] b) {
	
        boards = b;
        
        visit = new int[boards.length][boards.length][2];
        dfs(1,0,100,"수평");
        if (visit[boards.length-1][boards.length-1][0] > 0)
            answer = Math.min(visit[boards.length-1][boards.length-1][0], answer);
        if (visit[boards.length-1][boards.length-1][1] > 0)
            answer = Math.min(visit[boards.length-1][boards.length-1][1], answer);
        
        visit = new int[boards.length][boards.length][2];
        dfs(0,1,100,"수직");
        if (visit[boards.length-1][boards.length-1][0] > 0)
            answer = Math.min(visit[boards.length-1][boards.length-1][0], answer);
        if (visit[boards.length-1][boards.length-1][1] > 0)
            answer = Math.min(visit[boards.length-1][boards.length-1][1], answer);

        
        return answer;

	}
    
    void dfs(int i, int j, int cost, String direction){
        
        if (i > visit.length - 1 || j > visit.length - 1 || i < 0 || j < 0)
            return;
        
        if (boards[i][j] == 1)
            return;
  
        if (direction.equals("수직")){
            if (visit[i][j][0] == 0 || visit[i][j][0] > cost)
                visit[i][j][0] = cost;
            else
                return;  
        }
        else{
            if (visit[i][j][1] == 0 || visit[i][j][1] > cost)
                visit[i][j][1] = cost;
            else
                return; 
        }

         

        if (direction.equals("수평")){
            dfs(i+1,j,cost+100,"수평");
            dfs(i-1,j,cost+100,"수평");
            dfs(i,j+1,cost+600,"수직");
            dfs(i,j-1,cost+600,"수직");
        }
        
        else {
            dfs(i+1,j,cost+600,"수평");
            dfs(i-1,j,cost+600,"수평");
            dfs(i,j+1,cost+100,"수직");
            dfs(i,j-1,cost+100,"수직");
        }
            
        
    }

}