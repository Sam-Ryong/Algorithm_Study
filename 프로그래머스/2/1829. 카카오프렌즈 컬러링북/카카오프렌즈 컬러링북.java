import java.lang.*;

class Solution {
    int numberOfArea = 0;
    int maxSizeOfOneArea = 0;
    
    int temp = 0;
    
    public int[] solution(int m, int n, int[][] picture) {
        
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (picture[i][j] > 0){
                    spread(i,j,picture[i][j], -(++numberOfArea), picture);
                    maxSizeOfOneArea = Math.max(temp, maxSizeOfOneArea);
                    temp = 0;
                }
            }
        }
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        
        return answer;
    }
    
    void spread(int i, int j, int color, int section, int[][] picture){
        
        if (i < 0 || j < 0 || i >= picture.length || j >= picture[0].length)
            return;
        
        if (picture[i][j] != color)
            return;
        
        picture[i][j] = section;
        temp++;
        spread(i+1,j,color,section,picture);
        spread(i-1,j,color,section,picture);
        spread(i,j+1,color,section,picture);
        spread(i,j-1,color,section,picture);
        
    }
}