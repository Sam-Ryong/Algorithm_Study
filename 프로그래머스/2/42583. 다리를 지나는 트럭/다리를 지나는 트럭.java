import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        LinkedList<Integer> trucks = new LinkedList<>();
        LinkedList<Integer> bridge = new LinkedList<>();
        for (int truck : truck_weights){
            trucks.offer(truck);
        }
        for (int i = 0; i < bridge_length; i++){
            bridge.offer(-1);
        }
        int onBridge = 0;
        int time = 0;
        while (true){
            
            int out = bridge.poll();
            if (out != -1){
                onBridge -= out;
            }
            
            if (!trucks.isEmpty() && ((trucks.peek() + onBridge) <= weight)){
                int truck = trucks.poll();
                bridge.offer(truck);
                onBridge += truck;
            }
            else{
                bridge.offer(-1);
            }
            
            
            
            
            
            time++;  
            if (onBridge == 0 && trucks.isEmpty())
                break;
        }
        
        
        return time;
    }
}