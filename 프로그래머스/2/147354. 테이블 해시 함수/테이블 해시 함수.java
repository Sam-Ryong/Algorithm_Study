import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        
        Comparator<int[]> cmp = (a,b) -> {
            if (a[col-1] != b[col-1]){
                return Integer.compare(a[col-1],b[col-1]);
            }
            else
                return Integer.compare(b[0],a[0]);
        };
        
        Arrays.sort(data,cmp);
        
        for (int i = row_begin; i <= row_end; i++){
            int[] now = data[i-1];
            int s = 0;
            for (int j = 0; j < now.length; j++){
                //System.out.print(now[j] + " ");
                s += now[j] % (i);
            }
            //System.out.println();
            
            answer = answer ^ s;
        }
        
        return answer;
    }
}