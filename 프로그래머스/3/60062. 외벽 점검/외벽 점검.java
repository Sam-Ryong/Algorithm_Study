import java.util.*;
import java.lang.*;

class Solution {
    int answer = -1;
    int[] weak;
    int[] dist;
    int n;
    public int solution(int n, int[] weak, int[] dist) {
        
        this.n = n;
        this.weak = weak;
        this.dist = dist;

        reverse();
        
        Set<Integer> set = new HashSet<>();
        Set<Integer> temp = new HashSet<>();
        set.add(0);

        for (int i = 0; i <= dist.length; i++){
            for (int x : set){
                if (x == ((1 << weak.length) - 1)){
                    return i;
                }
                if (dist.length == i)
                    continue;
                for (int j = 0; j < weak.length; j++){
                    int startValue = weak[j];
                    int capacity = dist[i];
                    int next = x;
                    
                    for (int k = 0; k < weak.length; k++){
                        if ((next & (1 << k)) != 0)
                            continue;
                        if (startValue + capacity >= n){
                            if ((weak[k] >= startValue) || ((startValue + capacity - n) >= weak[k])){
                                
                                next = next | (1 << k);
                            }
                        }
                        else{
                            if (weak[k] >= startValue && startValue + capacity >= weak[k]){
                                next = next | (1 << k);
                            }
                        }
                    }
                    temp.add(next);
                }
            }
            set.clear();
            set.addAll(temp);
            temp.clear();
            
        }
        
        return answer;
    }
    
  
    
    void reverse(){
        for (int i = 0; i < dist.length; i++){
            dist[i] = - dist[i];
        }
        Arrays.sort(dist);
        for (int i = 0; i < dist.length; i++){
            dist[i] = - dist[i];
        }
    }
    

}