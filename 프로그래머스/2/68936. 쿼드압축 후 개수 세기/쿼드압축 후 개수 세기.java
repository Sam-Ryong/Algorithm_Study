class Solution {
    int[] answer = new int[2];
    public int[] solution(int[][] arr) {
        
        int[][] visit = new int[arr.length][arr[0].length];
        
        int size = arr.length;
        
        while (size > 0){
            count(size, arr, visit);
            size = size / 2;
        
        }
        
        
        return answer;
    }
    
    void count (int size, int[][] arr, int[][] visit){
        
        for (int i = 0; i < arr.length / size; i++){
            for (int j = 0; j < arr.length / size; j++){
                int zero = 0;
                int one = 0;
                for (int a = 0; a < size; a++){
                    for (int b = 0; b < size; b++){
                        if (visit[i * size + a][j * size + b] == 0){
                            if (arr[i * size + a][j * size + b] == 0)
                                zero++;
                            else
                                one++;
                        }
                    }
                }
                if (one * zero == 0){
                    if (zero > 0 && one == 0)
                        answer[0]++;
                    else if (zero == 0 && one > 0)
                        answer[1]++;
                    for (int a = 0; a < size; a++){
                        for (int b = 0; b < size; b++){
                            visit[i * size + a][j * size + b] = 1;
                        
                        }
                    }
                    
                }
                    
            }
        }
        
    }
    

}