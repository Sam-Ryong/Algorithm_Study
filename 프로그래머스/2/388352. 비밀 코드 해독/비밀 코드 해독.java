class Solution {
    public int solution(int n, int[][] q, int[] ans) {
        int answer = 0;
        
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++){
            numbers[0] = n+1;
        }
        
        for (int a = 1; a < n+1; a++){
            for (int b = a+1; b < n+1; b++){
                for (int c = b+1; c < n+1; c++){
                    for (int d = c+1; d < n+1; d++){
                         for (int e = d+1; e < n+1; e++){
                            
                             if (check(a,b,c,d,e,q,ans))
                                 answer++;
                             
                        }
                    }
                }
            }
        }
        
        return answer;
                
    }
    
    public boolean check(int a, int b, int c, int d, int e, int[][] q, int[] ans){
        boolean result = true;
        for (int i = 0; i < q.length; i++){
            int answer = 0;
            int[] query = q[i];
            for (int j = 0; j < 5; j++){
                if (query[j] == a)
                    answer++;
                else if (query[j] == b)
                    answer++;
                else if (query[j] == c)
                    answer++;
                else if (query[j] == d)
                    answer++;
                else if (query[j] == e)
                    answer++;
            }
            
            if (answer != ans[i]){
                result = false;
                break;
            }
                
        }
        
        return result;
        
    }
}