import java.util.*;
import java.lang.*;

class Solution {
    public String[] solution(String[] files) {
        String[] answer = {};
        
        Map<String, Integer> index = new HashMap<>();
        for (int i = 0; i < files.length; i++){
            index.put(files[i], i);
        }
        

        Comparator<String> cmp = (a, b) ->{
            
            String[] A = headNumberTail(a);
                
            String[] B = headNumberTail(b);
            
            for (int i = 0; i < 2; i++){
                A[i] = A[i].toLowerCase();
                B[i] = B[i].toLowerCase();
            }
            
            if (!A[0].equals(B[0])){
                return A[0].compareTo(B[0]);
            }
            if (Integer.parseInt(A[1]) != Integer.parseInt(B[1])){
                return Integer.compare(Integer.parseInt(A[1]), Integer.parseInt(B[1]));
            }
            
            return Integer.compare(index.get(a), index.get(b));
            
        };
        
        Arrays.sort(files, cmp);

        
        return files;
    }
    
    String[] headNumberTail(String a){
        String head = "";
        int point = 0;
        for (int i = 0; i < a.length(); i++){
            if (48 <= a.charAt(i) && a.charAt(i) <= 57){
                head = a.substring(0,i);
                point = i;
                break;
            }
        }
        String number = "";
        for (int i = point; i <= Math.min(point + 5, a.length()); i++){
            if (i == a.length()){
                number = a.substring(point,i);
                break;
            }
            if (!(48 <= a.charAt(i) && a.charAt(i) <= 57)){
                number = a.substring(point,i);
                break;
            }
        }

        
        return new String[]{head, number};
    }
    

}