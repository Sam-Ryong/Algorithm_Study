import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        StringBuilder answer = new StringBuilder();
        
        Stack<Node> stack = new Stack<>();
        boolean[] removed = new boolean[n];
        Node[] nodes = new Node[n];
        
        nodes[0] = new Node(0);
        for (int i = 1; i < n; i++){
            nodes[i] = new Node(i);
            nodes[i-1].right = nodes[i];
            nodes[i].left = nodes[i-1];
        }
        
        Node current = nodes[k];
 
        for (String c : cmd){
            
            if (c.substring(0,1).equals("D")){
                int N = Integer.parseInt(c.substring(2));
                for (int i = 0; i < N; i++){
                    current = current.right;
                }
            }
            else if (c.substring(0,1).equals("U")){
                int N = Integer.parseInt(c.substring(2));
                for (int i = 0; i < N; i++){
                    current = current.left;
                }
                
            }
            else if (c.substring(0,1).equals("C")){
                
                if (current.right == null){
                    current = current.left;
                    stack.push(current.right);
                    current.right = null;
                    removed[stack.peek().val] = true;
                }
                else if (current.left == null){
                    stack.push(current);
                    current = current.right;
                    current.left = null;
                    removed[stack.peek().val] = true;
                }
                else{
                    stack.push(current);
                    current.left.right = stack.peek().right;
                    current.right.left = stack.peek().left;
                    current = current.right;
                    removed[stack.peek().val] = true;
                }
                
            }
            else if (c.substring(0,1).equals("Z")){
                Node recover = stack.pop();
                removed[recover.val] = false;
                while (recover.left != null && removed[recover.left.val] == true){
                    recover.left = recover.left.left;
                    if (recover.left == null)
                        break;
                }
                while (recover.right != null && removed[recover.right.val] == true){
                    recover.right = recover.right.right;
                    if (recover.right == null)
                        break;
                }
                if (recover.left != null)
                    recover.left.right = recover;
                if (recover.right != null)
                    recover.right.left = recover;
            }
            
        }
        
        for (boolean ox : removed){
            answer.append(ox ? "X" : "O");
        }
        
          
        return answer.toString();
    }
    
    class Node{
        int val;
        Node left;
        Node right;
        public Node(int val){
            this.val = val;
        }
    }
}