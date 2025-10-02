import java.util.*;

class Solution {
    boolean[][][] matrix;
    int n;
    public int[][] solution(int n, int[][] build_frame) {
        int[][] answer;
        List<Integer[]> memory = new ArrayList<>();
        matrix = new boolean[n+1][n+1][2];
        this.n = n;
        
        for (int[] cmd : build_frame){
            
            int x = cmd[0];
            int y = cmd[1];
            int a = cmd[2];
            int b = cmd[3];
            
            if (a == 1){
                if (b == 1 && isOkayBoo(x,y))
                    matrix[x][y][1] = true;
                if (b == 0){
                    matrix[x][y][1] = false;
                    if (matrix[x][y][0] && !isOkayGidung(x,y)){
                        matrix[x][y][1] = true;
                        continue;
                    }
                    if (matrix[x+1][y][0] && !isOkayGidung(x+1,y)){
                        matrix[x][y][1] = true;
                        continue;
                    }
                    if (x > 0 && matrix[x-1][y][1] && !isOkayBoo(x-1,y)){
                        matrix[x][y][1] = true;
                        continue;
                    }
                    if (x < n && matrix[x+1][y][1] && !isOkayBoo(x+1,y)){
                        matrix[x][y][1] = true;
                        continue;
                    }      
                }
            }
            else{
                if (b == 1 && isOkayGidung(x,y)){
                    matrix[x][y][0] = true;
                }
                if (b == 0){
                    matrix[x][y][0] = false;
                    if (matrix[x][y+1][1] && !isOkayBoo(x,y+1)){
                        matrix[x][y][0] = true;
                        continue;
                    }
                    if (x > 0 && matrix[x-1][y+1][1] && !isOkayBoo(x-1,y+1)){
                        matrix[x][y][0] = true;
                        continue;
                    }
                    if (y < n && matrix[x][y+1][0] && !isOkayGidung(x,y+1)){
                        matrix[x][y][0] = true;
                        continue;
                    }
                }
            }
            
        }        
        
        for (int i = 0; i < n+1; i++){
            for (int j = 0; j < n+1; j++){
                if(matrix[i][j][0]){
                    memory.add(new Integer[]{i,j,0});
                }
                if (matrix[i][j][1]){
                    memory.add(new Integer[]{i,j,1});
                }
            }
        }
        answer = new int[memory.size()][3];
        for (int i = 0; i < memory.size(); i++){
            for (int j = 0; j < 3; j++){
                answer[i][j] = memory.get(i)[j];
            }
        }
        
        Arrays.sort(answer, (a, b) -> {
            if (a[0] != b[0])
                return Integer.compare(a[0], b[0]);
            else{
                if (a[1] != b[1])
                    return Integer.compare(a[1],b[1]);
                else
                    return Integer.compare(a[2], b[2]);    
            }
            
        });
        
        return answer;
    }
    
    boolean isOkayBoo(int x, int y){
        if (x < 0 || y <= 0 || x > n - 1 || y > n)
            return false;
        if (y > 0)
            if (matrix[x][y-1][0])
                return true;
        if (x < n && y > 0)
            if (matrix[x+1][y-1][0])
                return true;
        if (x > 0 && x < n)
            return (matrix[x-1][y][1] && matrix[x+1][y][1]);
        return false;
    }
    
    boolean isOkayGidung(int x, int y){
        if (x < 0 || y < 0 || x > n || y > n - 1)
            return false;
        if (y == 0)
            return true;
        if (x > 0)
            if (matrix[x-1][y][1])
                return true;
        if (y > 0)
            if (matrix[x][y-1][0])
                return true;
        return matrix[x][y][1];

    }
}