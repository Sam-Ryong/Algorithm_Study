import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        List<Integer[]> list = new ArrayList<Integer[]>();
        List<Integer[]> temp = new ArrayList<Integer[]>();
        
        Arrays.sort(routes, (o1,o2) -> Integer.compare(o1[1],o2[1]));
        
        int point = routes[0][1];
        
        for (int[] route : routes){            
            if (route[0] <= point && point <= route[1])
                continue;
            else{
                Integer[] car = new Integer[2];
                car[0] = route[0];
                car[1] = route[1];
                list.add(car);    
            }
        }
        answer++;
        
        while (list.size() > 0){
            point = list.get(0)[1];
            for (Integer[] route : list){            
                if (route[0] <= point && point <= route[1])
                    continue;
                else
                    temp.add(route);            
            }
            list.clear();
            list.addAll(temp);
            temp.clear();
            answer++;
        }
        
        
        
        return answer;
    }
    
    
}