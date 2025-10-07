import java.lang.*;

class Solution {
    int answer = Integer.MAX_VALUE;
    int[][] rectangle;
    //matrixX[i][j] = 선분 i,j <-> i,j+1
    int[][] matrixX = new int[52][52];
    
    //matrixY[i][j] = 선분 i,j <-> i+1,j
    int[][] matrixY = new int[52][52];
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        
        this.rectangle = rectangle;
        
        for (int[] xy : rectangle){
            int minX = xy[0];
            int minY = xy[1];
            int maxX = xy[2];
            int maxY = xy[3];
            
            for (int i = minX; i < maxX; i++){
                matrixX[minY][i] = 1;
                matrixX[maxY][i] = 1;
            }
            
            for (int i = minY; i < maxY; i++){
                matrixY[i][minX] = 1;
                matrixY[i][maxX] = 1;
            }
                  
        }
        
        
        for (int[] xy : rectangle){
            int minX = xy[0];
            int minY = xy[1];
            int maxX = xy[2];
            int maxY = xy[3];
            
            
            
            for (int i = minY + 1; i < maxY; i++){
                for (int j = minX; j < maxX; j++){
                    matrixX[i][j] = 0;
                }
            }
            
            for (int i = minY; i < maxY; i++){
                for (int j = minX + 1; j < maxX; j++){
                    matrixY[i][j] = 0;
                }
            }
                  
        }
        
        trace(characterY, characterX, itemX, itemY, 0, new boolean[51][51]);
        
        return answer;
    }
    
    void trace(int i, int j, int itemX, int itemY, int count, boolean[][] visit){
        if (i < 0 || j < 0 || i > 50 || j > 50)
            return;
        if (visit[i][j])
            return;
        if (i == itemY && j == itemX){
            answer = Math.min(count, answer);
            return;
        }
        // System.out.println(j + " " + i);
        visit[i][j] = true;
        if (i < 50 && matrixY[i][j] == 1){
            trace(i+1,j,itemX,itemY,count+1,visit);
        }
        if (i > 0 && matrixY[i-1][j] == 1){
            trace(i-1,j,itemX,itemY,count+1,visit);
        }
        if (j < 50 && matrixX[i][j] == 1){
            trace(i,j + 1,itemX,itemY,count+1,visit);
        }
        if (j > 0 && matrixX[i][j-1] == 1){
            trace(i,j - 1,itemX,itemY,count+1,visit);
        }
    }
        
    
}