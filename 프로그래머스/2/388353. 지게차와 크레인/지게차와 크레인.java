import java.util.*;

class Solution {
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        
        String[][] container = new String[storage.length][storage[0].length()];
        
        boolean[][] available = new boolean[storage.length][storage[0].length()];
        
        for (int i = 0; i < storage.length; i++){
            for (int j = 0; j < storage[0].length(); j++){
                container[i][j] = storage[i].substring(j,j+1);
                if (i == 0 || i == storage.length - 1)
                    available[i][j] = true;
                if (j == 0 || j == storage[0].length() - 1)
                    available[i][j] = true;
            }
        }
 
        for (String req : requests){
   
            List<Integer[]> changed = new ArrayList<>();
            if (req.length() == 1){
                changed.addAll(single(req.substring(0,1), container, available));
                answer += changed.size();
            }
            else if (req.length() == 2){
                changed.addAll(multi(req.substring(0,1), container));
                answer += changed.size();
            }
            for (Integer[] xy : changed){
                
                int i = xy[0];
                int j = xy[1];
                
                if (available[i][j])
                    updateAvailable(available,container, i, j);

            }
            
          
        }
        
        
        
        
        return storage.length * storage[0].length() - answer;
    }
    
    public void updateAvailable(boolean[][] available, String[][] container, int i, int j){
        
        boolean[][] visit = new boolean[available.length][available[0].length];
        List<Integer[]> now = new ArrayList<>();
        List<Integer[]> temp = new ArrayList<>();
        
        now.add(new Integer[]{i,j});
        while (now.size() > 0){
            
            for (Integer[] xy : now){
                
                int x = xy[0];
                int y = xy[1];
                if (x < 0 || y < 0 || x > available.length - 1 || y > available[0].length - 1)
                    continue;
                if (visit[x][y])
                    continue;
                
                visit[x][y] = true;
                
                if (container[x][y].equals("-")){
                    if (!available[x][y])
                        available[x][y] = true;
                    temp.add(new Integer[]{x-1,y});
                    temp.add(new Integer[]{x+1,y});
                    temp.add(new Integer[]{x,y-1});
                    temp.add(new Integer[]{x,y+1});
                }
                else if (!container[x][y].equals("-") && !available[x][y]){
                    available[x][y] = true;
                }     
                
            }
            
            now.clear();
            now.addAll(temp);
            temp.clear();
            
        }
        
    }
    

    
    public List<Integer[]> single(String product, String[][] container, boolean[][] available){
        
        List<Integer[]> result = new ArrayList<>();
        
        for (int i = 0; i < container.length; i++){
            for (int j = 0; j < container[0].length; j++){
                if (product.equals(container[i][j]) && available[i][j]){
                    result.add(new Integer[]{i,j});
                    container[i][j] = "-";
                }
            }
        }
        
        
        return result;
        
    }
    
    public List<Integer[]> multi(String product, String[][] container){
        
        List<Integer[]> result = new ArrayList<>();
        
        for (int i = 0; i < container.length; i++){
            for (int j = 0; j < container[0].length; j++){
                if (product.equals(container[i][j])){
                    result.add(new Integer[]{i,j});
                    container[i][j] = "-";
                
                }
            }
        }
        
        return result;
        
    }
}