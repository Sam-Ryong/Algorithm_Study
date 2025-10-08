import java.util.*;

class Solution {
    
    Cell[][] table = new Cell[51][51];
    List<String> buffer = new ArrayList<String>();
    
    public String[] solution(String[] commands) {
        
        
        for (int i = 1; i <= 50; i++){
            for (int j = 1; j <= 50; j++){
                table[i][j] = new Cell();
            }
        }

        
        for (String cmd : commands){
            
            String[] args = cmd.split(" ");
            String type = args[0];
            
            if (type.equals("UPDATE")){
                if (args.length == 4){
                    int r = Integer.parseInt(args[1]);
                    int c = Integer.parseInt(args[2]);
                    String value = args[3];
                    update(r, c, value);
                }
                else if (args.length == 3){
                    String value1 = args[1];
                    String value2 = args[2];
                    update(value1, value2);
                }
            }
            else if (type.equals("MERGE")){
                int r1 = Integer.parseInt(args[1]);
                int c1 = Integer.parseInt(args[2]);
                int r2 = Integer.parseInt(args[3]);
                int c2 = Integer.parseInt(args[4]);
                
                merge(r1, c1, r2, c2);
            }
            else if (type.equals("UNMERGE")){
                int r = Integer.parseInt(args[1]);
                int c = Integer.parseInt(args[2]);
                
                unmerge(r,c);
            }
            else if (type.equals("PRINT")){
                int r = Integer.parseInt(args[1]);
                int c = Integer.parseInt(args[2]);
                
                print(r,c);
            }
            
            // for (int i = 1; i <= 4; i++){
            //     for (int j = 1; j <= 4; j++){
            //         System.out.print(table[i][j].value == null ? "  " : table[i][j].value + " ");
            //     }
            //     System.out.println();
            // }
            // System.out.println();     
        }
        
        
        String[] answer = new String[buffer.size()];
        
        for (int i = 0; i < buffer.size(); i++){
            answer[i] = buffer.get(i);
        }
        
        return answer;
    }
    
    
    
    void update(int r, int c, String value){
        
        table[r][c].value = value;

      
    }
    
    void update(String value1, String value2){
        for (int i = 1; i <= 50; i++){
            for (int j = 1; j <= 50; j++){
                if (table[i][j].value != null && table[i][j].value.equals(value1)){
                    table[i][j].value = value2;
                }
            }
        }
    }
    
    void merge(int r1, int c1, int r2, int c2){
        if (r1 == r2 && c1 == c2)
            return;

        if (table[r1][c1].value == null && table[r2][c2].value != null){
            for (int i = 1; i <= 50; i++){
                for (int j = 1; j <= 50; j++){
                    if (i == r1 && j == c1)
                        continue;
                    if (table[i][j] == table[r1][c1]){
                        table[i][j] = table[r2][c2];
                    }
                }
            }
            table[r1][c1] = table[r2][c2];
        }
        else if (table[r1][c1].value != null && table[r2][c2].value == null){
     
            for (int i = 1; i <= 50; i++){
                for (int j = 1; j <= 50; j++){
                    if (i == r2 && j == c2)
                        continue;
                    if (table[i][j] == table[r2][c2]){
                        table[i][j] = table[r1][c1];
                    } 
                }
            }
            table[r2][c2] = table[r1][c1];
        }
        else if (table[r1][c1].value != null && table[r2][c2].value != null){
 
            for (int i = 1; i <= 50; i++){
                for (int j = 1; j <= 50; j++){
                    if (i == r2 && j == c2)
                        continue;
                    if (table[i][j] == table[r2][c2]){
                        table[i][j] = table[r1][c1];
                    }
                }
            }
            table[r2][c2] = table[r1][c1];
        }
        else{
             for (int i = 1; i <= 50; i++){
                for (int j = 1; j <= 50; j++){
                    if (i == r2 && j == c2)
                        continue;
                    if (table[i][j] == table[r2][c2]){
                        table[i][j] = table[r1][c1];
                    }
                }
            }
            table[r2][c2] = table[r1][c1];
        }
        
    }
    
    void unmerge(int r, int c){
        
        for (int i = 1; i <= 50; i++){
            for (int j = 1; j <= 50; j++){
                if (i == r && j == c)
                    continue;
                if (table[i][j] == table[r][c]){
                    table[i][j] = new Cell();
                }
            }
        }

        
    }
    
    void print(int r, int c){
        
        if (table[r][c].value == null){
            buffer.add("EMPTY");
        }
        else{
            buffer.add(table[r][c].value);
        }
        
    }
    
    class Cell{
        String value;
    }
    
    
}