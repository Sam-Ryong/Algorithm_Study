import java.util.*;
import java.lang.*;

class Solution {
    
    int now = 0;
    
    public int solution(int[] food_times, long k) {
        int answer = 0;
        List<Food> list = new ArrayList<>();
        
        for (int i = 0; i < food_times.length; i++){
            Food food = new Food();
            food.index = i+1;
            food.amount = food_times[i];
            list.add(food);
        }
        
        Collections.sort(list, (a,b) -> {
            return Integer.compare(b.amount, a.amount);
        });
        
        int min = 0;
        while (list.size() > 0){
            int amount = list.get(list.size()-1).amount;
            if (k - (long) (amount - min) * list.size() >= 0){
                
                k = k - (long) (amount - min) * list.size();
                min = amount;
                list.remove(list.size()-1);
            }
            else
                break;
        }
        
        
        if (list.size() == 0)
            return -1;
        
        Collections.sort(list, (a,b) -> {
            return Integer.compare(a.index, b.index);
        });
        
        return list.get((int) (k % list.size())).index;

    }
    
    class Food{
        int amount;
        int index;
        
        @Override
        public String toString(){
            return index + " " + amount;
        }
    }
}