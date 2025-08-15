import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        
        Location[] map = new Location[n+1];
        
        for (int i = 1; i < n + 1; i++){
            map[i] = new Location(i);
        }
        
        for (int[] road : roads){
            int a = road[0];
            int b = road[1];
            map[a].update(map[b]);
            map[b].update(map[a]);
            
        }
        
        int len = 1;
        int[] path = new int[n+1];
        path[destination] = 1;
        List<Location> now = new ArrayList<>();
        List<Location> temp = new ArrayList<>();
        now.addAll(map[destination].next);
        while (now.size() > 0){
            for (Location location : now){
                if (path[location.num] == 0){
                    path[location.num] = len;
                    temp.addAll(location.next);
                }
            }
            
            now.clear();
            now.addAll(temp);
            temp.clear();
            len++;
        }
        
        for (int i = 0; i < sources.length; i++){
            int s = sources[i];
            if (path[s] > 0){
                answer[i] = path[s];
                if (s == destination)
                    answer[i] = 0;
            }
            else{
                answer[i] = -1;
            }
            
        }
        
        return answer;
    }
    
    class Location{
        List<Location> next = new ArrayList<>();
        int num;
        public Location(int num){
            this.num = num;
        }
        public void update(Location l){
            this.next.add(l);
        }
    }
    

}