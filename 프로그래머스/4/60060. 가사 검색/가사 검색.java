import java.util.*;

class Solution {
    public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];
        
        Map<Character, Node> startMap = new HashMap<>();
        Map<Character, Node> endMap = new HashMap<>();
        
        for (int i = 0; i < words.length; i++){
            String word = words[i];
            
            if (startMap.get(word.charAt(0)) == null){
                Node node = new Node();
                startMap.put(word.charAt(0), node);
            }
            
            Node currentStartNode = startMap.get(word.charAt(0));
            // if (currentStartNode.count.get(word.length()) == null)
            //     currentStartNode.count.put(word.length(), 0);
            // currentStartNode.count.replace(word.length(), currentStartNode.count.get(word.length()) + 1);
            for (int j = 1; j < word.length(); j++){
                
                Character now = word.charAt(j);
                Node node = currentStartNode.child.get(now);
                if (node == null) {
                    node = new Node();
                    currentStartNode.child.put(now, node);
                }
                 if (currentStartNode.count.get(word.length()) == null)
                    currentStartNode.count.put(word.length(), 0);
                currentStartNode.count.replace(word.length(),currentStartNode.count.get(word.length()) + 1);

                currentStartNode = node; 
     
            }
            
            if (endMap.get(word.charAt(word.length() - 1)) == null){
                Node node = new Node();
                endMap.put(word.charAt(word.length() - 1), node);
            }
            
            Node currentEndNode = endMap.get(word.charAt(word.length() - 1));
            // if (currentEndNode.count.get(word.length()) == null)
            //     currentEndNode.count.put(word.length(), 0);
            // currentEndNode.count.replace(word.length(), currentEndNode.count.get(word.length()) + 1);
            for (int j = 1; j < word.length(); j++){
                
                Character now = word.charAt(word.length() - 1- j);
                Node node = currentEndNode.child.get(now);
                if (node == null) {
                    node = new Node();
                    currentEndNode.child.put(now, node);
                }
                if (currentEndNode.count.get(word.length()) == null)
                    currentEndNode.count.put(word.length(), 0);
                currentEndNode.count.replace(word.length(), currentEndNode.count.get(word.length()) + 1);
                currentEndNode = node; 
     
            }
 
        }
        
        for (int i = 0; i < queries.length; i++){
            String query = queries[i];
            
            if (query.length() == 1){
                for (Character key : startMap.keySet()){
                    if (startMap.get(key).count.get(1) != null)
                        answer[i] += startMap.get(key).count.get(1);
                }
                continue;
            }
            
            if (query.charAt(0) == '?'){
                if (query.charAt(query.length() - 1) == '?'){
                    for (Character key : startMap.keySet()){
                        if (startMap.get(key).count.get(query.length()) != null)
                            answer[i] += startMap.get(key).count.get(query.length());
                    }
                }
                Node currentNode = endMap.get(query.charAt(query.length() - 1));
                if (currentNode == null)
                    continue;
                for (int j = query.length() - 2; j >= 0; j--){
                    
                    // if (currentNode.child.get(query.charAt(j)) == null)
                    //     break;

                    if (query.charAt(j) == '?'){
                        break;
                    }
                    if (currentNode.count.get(query.length()) == null)
                        break;
                    
                    currentNode = currentNode.child.get(query.charAt(j));
                    if (currentNode == null)
                        break;

                    
                }
                if (currentNode == null)
                    continue;
                answer[i] = currentNode.count.get(query.length())  != null ? currentNode.count.get(query.length()) : 0;
            }
            else{
                Node currentNode = startMap.get(query.charAt(0));
                if (currentNode == null)
                    continue;
                for (int j = 1; j <= query.length() - 1; j++){
                    
                    // if (currentNode.child.get(query.charAt(j)) == null)
                    //     break;
                    if (query.charAt(j) == '?'){
                        break;
                    }
   
                    if (currentNode.count.get(query.length()) == null)
                        break;
                    
                    currentNode = currentNode.child.get(query.charAt(j));
                    if (currentNode == null)
                        break;
                    
                }
                if (currentNode == null)
                    continue;
                
                answer[i] = currentNode.count.get(query.length())  != null ? currentNode.count.get(query.length()) : 0;
            }
        }
        

        return answer;
    }
    
    class Node{

        Map<Integer, Integer> count = new HashMap<>();
        Map<Character, Node> child = new HashMap<>();
        
        @Override
        public String toString(){
            return count.toString();
        }
    }
}