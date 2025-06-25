class Solution {
    public int solution(String dirs) {
        int answer = 0;
        int[][][] memory = new int[11][11][4];
        int I = 5;
        int J = 5;
        
        for (char c : dirs.toCharArray()){
            int i = I;
            int j = J;
            
            if (c == 'L'){
                if (memory[i][j][0] == 0){
                    memory[i][j][0] = 1;
                    if (j > 0)
                        answer++;
                }
                if (j > 0){
                    j -= 1;
                    memory[i][j][1] = 1;
                }
            }
            else if (c == 'R'){
                if (memory[i][j][1] == 0){
                    memory[i][j][1] = 1;
                    if (j < 10)
                        answer++;
                }
                if (j < 10){
                    j += 1;
                    memory[i][j][0] = 1;
                }
            }
            else if (c == 'U'){
                if (memory[i][j][2] == 0){
                    memory[i][j][2] = 1;
                    if (i > 0)
                        answer++;
                }
                if (i > 0){
                    i -= 1;
                    memory[i][j][3] = 1;
                }
            }
            else if (c == 'D'){
                if (memory[i][j][3] == 0){
                    memory[i][j][3] = 1;
                    if (i < 10)
                        answer++;
                }
                if (i < 10){
                    i += 1;
                    memory[i][j][2] = 1;
                }
            }
            I = i;
            J = j;

        }
        return answer;
    }
}