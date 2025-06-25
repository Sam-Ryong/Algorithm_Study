import java.util.*;


class Solution {
    public int[] solution(String s) {
        List<Integer> result = new ArrayList<Integer>();
        for (String json : parseString(s)){
            int[] arr = parseJson(json);
            for (Integer num : result){
                for (int i = 0; i < arr.length; i++){
                    if (num == arr[i]){
                        arr[i] = -1;
                    }
                }
            }
            for (int i = 0; i < arr.length; i++){
                if (arr[i] != -1){
                    result.add(arr[i]);
                }
            }       
        }
        
        int[] answer = new int[result.size()];
        for (int i = 0; i < answer.length; i++){
            answer[i] = result.get(i);
        }
        
        return answer;
    }
    
    List<String> parseString(String s){
        s = s.substring(1,s.length()-1); 
        List<String> result = new ArrayList<String>();
        int left = -1;
        int right = -1;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '{'){
                left = i;
            }
            else if (s.charAt(i) == '}'){
                right = i;
                result.add(s.substring(left,right+1));
            }
        }
        result.sort((o1,o2) -> Integer.compare(o1.length(), o2.length()));
        return result;
    }
    int[] parseJson(String json){
        json = json.substring(1,json.length()-1);
        String[] elem = json.split(",");
        int[] result = new int[elem.length];
        for (int i = 0; i < elem.length; i++){
            result[i] = Integer.parseInt(elem[i]);
        }
        return result;
    }
}