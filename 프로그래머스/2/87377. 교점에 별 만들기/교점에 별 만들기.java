import java.util.*;
import java.lang.*;

class Solution {
    public String[] solution(int[][] line) {

        List<Long[]> memory = new ArrayList<>();
        
        long maxX = Long.MIN_VALUE;
        long maxY = Long.MIN_VALUE;
        long minX = Long.MAX_VALUE;
        long minY = Long.MAX_VALUE;
        
        for (int i = 0; i < line.length; i++){
            for (int j = i + 1; j < line.length; j++){
                long[] inter = intersection(line[i], line[j]);
                if (inter == null)
                    continue;
                maxX = Math.max(inter[0], maxX);
                maxY = Math.max(inter[1], maxY);
                minX = Math.min(inter[0], minX);
                minY = Math.min(inter[1], minY);
                memory.add(new Long[]{inter[0], inter[1]});
            }
        }
        
        
        
        String[][] matrix = new String[(int)(maxY - minY) + 1][(int)(maxX - minX) + 1];
        
        for (Long[] m : memory){
            matrix[(int)(m[1] - minY)][(int)(m[0] - minX)] = "*";
        }
        long len = maxY - minY + 1;
        String[] answer = new String[(int) len];
        
        for (int i = 0; i < answer.length; i++){
            
            StringBuilder st = new StringBuilder();
            for (int j = 0; j < matrix[0].length; j++){
                if (matrix[i][j] == null)
                    st.append(".");
                else
                    st.append("*");
            }
            
            answer[answer.length - i - 1] = st.toString();
            
        }
        
        
        return answer;
    }
    
    long[] intersection(int[] a, int[] b){
        
        if (a[1] * b[0] == a[0] * b[1])
            return null;
        
        long A = (long) a[0];
        long B = (long) a[1];
        long C = (long) b[0];
        long D = (long) b[1];
        long E = (long) a[2];
        long F = (long) b[2];
        
        if (A*D == B*C)
            return null;
        
        if ((B*F - E*D) % (A*D-B*C) != 0 ||  (E*C - A*F) % (A*D-B*C) != 0)
            return null;
        
        long x = (B*F - E*D) / (A*D-B*C);
        long y = (E*C - A*F) / (A*D-B*C);
        
        return new long[]{x, y};
        
    }
}