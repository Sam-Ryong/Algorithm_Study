import java.util.*;

class Solution {
    public int solution(String[] words) {
        int answer = 0;
        Map<Character, Node> map = new HashMap<>();
        
        String before = "";
        for (String word : words){
            
            if (map.get(word.charAt(0)) == null){
                Node node = new Node();
                node.val = 1;
                map.put(word.charAt(0), node);
            }
            
            Node currentNode = map.get(word.charAt(0));
            
            for (int i = 1; i < word.length(); i++){

                
                Node node = new Node();
                node.val = i+1;
                currentNode.pass++;
                if (currentNode.child.get(word.charAt(i)) == null){
                    currentNode.child.put(word.charAt(i), node);
                    currentNode = currentNode.child.get(word.charAt(i));
                }
                else{
                    currentNode = currentNode.child.get(word.charAt(i));
                }
            }
            Node node = new Node();
            node.val = word.length();
            currentNode.child.put(' ', node);
            currentNode.pass++;
            
        }
        
        
         for (String word : words){
            
            Node node = map.get(word.charAt(0));
            int memory = 1;

            for (int i = 1; i < word.length(); i++){

                if (node.pass == 1){
                    memory = node.val;
                    break;
                }
                
                node = node.child.get(word.charAt(i));
            }
            if (node.val == word.length()){
                memory = node.val;
            }
                

            answer += memory;
 
        }

      
        
        return answer;
    }
    
    class Node{
        int val;
        int pass = 0;
        Map<Character, Node> child = new HashMap<>();
        

    }
    

    

}