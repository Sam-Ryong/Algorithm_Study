import java.lang.*;

class Solution {
    int answer1 = 0;
    int answer2 = 0;
    int[][] rectangle;
    int[][] matrix = new int[52][52];
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        
        this.rectangle = rectangle;
        
        for (int[] xy : rectangle){
            int minX = xy[0];
            int minY = xy[1];
            int maxX = xy[2];
            int maxY = xy[3];
            
            for (int i = minY; i <= maxY; i++){
                for (int j = minX; j <= maxX; j++){
                    if (matrix[i][j] == 1){
                        continue;
                    }
    
                    if (i == minY || i == maxY || j == minX || j == maxX){
                        if (matrix[i][j] == 2)
                            matrix[i][j] = 3;
                        else
                            matrix[i][j] = 2;
                    }
                    else
                        matrix[i][j] = 1;
                }
            }
            
        }
        int[][] temp = new int[52][52];
        
        spread(0, 0, matrix, temp, new boolean[51][51]);
        
        // matrix = temp;
        for (int i = 50; i >= 1; i--){
            for (int j = 1; j < 51; j++){
                if (matrix[i][j] == 2 || matrix[i][j] == 3){
                    int count = 0;
                    if (matrix[i-1][j] == 2 || matrix[i-1][j] == 3)
                        count++;
                    if (matrix[i+1][j] == 2 || matrix[i+1][j] == 3)
                        count++;
                    if (matrix[i][j-1] == 2 || matrix[i][j-1] == 3)
                        count++;
                    if (matrix[i][j+1] == 2 || matrix[i][j+1] == 3)
                        count++;
                    
                    if (count >= 2)
                        matrix[i][j] = 2;
                    else
                        matrix[i][j] = 0;
                }
            }
        }
        matrix[itemY][itemX] = -1;
        
        travel(characterY, characterX, 0, new boolean[51][51], 0);
        
        for (int i = 50; i >= 0; i--){
            for (int j = 0; j < 51; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        
        return Math.min(answer1, answer2);
    }
    
    void spread(int i, int j, int[][] matrix, int[][] temp, boolean[][] visit){
        if (i < 0 || j < 0 || i > 50 || j > 50)
            return;
        if (visit[i][j])
            return;
        visit[i][j] = true;
        if (matrix[i][j] != 0){
            temp[i][j] = 1;
            return;
        }
        else{
            spread(i-1,j,matrix,temp, visit);
            spread(i+1,j,matrix,temp, visit);
            spread(i,j-1,matrix,temp, visit);
            spread(i,j+1,matrix,temp, visit);
            spread(i-1,j-1,matrix,temp, visit);
            spread(i+1,j-1,matrix,temp, visit);
            spread(i+1,j+1,matrix,temp, visit);
            spread(i-1,j+1,matrix,temp, visit);
        }
    }
    
    void travel(int i, int j, int dist, boolean[][] temp, int direction){
        if (i < 0 || j < 0 || i > 50 || j > 50)
            return;
        if (temp[i][j])
            return;
        if (matrix[i][j] == 0 || matrix[i][j] == 1)
            return;
        if (matrix[i][j] == -1){
            if (direction == 1)
                answer1 = Math.max(answer1, dist);
            if (direction == -1)
                answer2 = Math.max(answer2, dist);
            return;
        }
        boolean[][] visit = new boolean[51][51];
        for (int x = 0; x < 51; x++){
            visit[x] = temp[x].clone();
        }
        visit[i][j] = true;
        for (int[] xy : rectangle){
            int minX = xy[0];
            int minY = xy[1];
            int maxX = xy[2];
            int maxY = xy[3];
                
            if (j == maxX || j == minX){
                if (minY <= i && i <= maxY && minY <= i+1 && i+1 <= maxY){
                    travel(i+1,j,dist+1, visit, direction == 0 ? 1 : direction);
                }
                if (minY <= i && i <= maxY && minY <= i-1 && i-1 <= maxY){
                    travel(i-1,j,dist+1, visit, direction == 0 ? -1 : direction);
                }
            }
            if (i == maxY || i == minY){
                if (minX <= j && j <= maxX && minX <= j+1 && j+1 <= maxX){
                    travel(i,j+1,dist+1, visit, direction == 0 ? 1 : direction);
                }
                if (minX <= j && j <= maxX && minX <= j-1 && j-1 <= maxX){
                    travel(i,j-1,dist+1, visit, direction == 0 ? -1 : direction);
                }
            }
        }
        
    }
}